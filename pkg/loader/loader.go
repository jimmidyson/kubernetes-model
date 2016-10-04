package loader

import (
	"go/ast"
	"go/parser"
	"go/token"
	"sort"
	"strings"

	"github.com/inconshreveable/log15"
	"github.com/pkg/errors"
	"golang.org/x/tools/go/loader"
	"k8s.io/kubernetes/third_party/golang/reflect"

	"github.com/fabric8io/kubernetes-model/pkg/astutils"
)

type ASTLoader struct {
	requestedPackages []string
	logger            log15.Logger
}

func New(packages []string, logger log15.Logger) *ASTLoader {
	return &ASTLoader{requestedPackages: packages, logger: logger}
}

type Package struct {
	Path  string
	Types map[string]Type
}

type Type struct {
	Name           string
	Fields         map[string]Field
	Doc            string
	GenerateClient bool
	Namespaced     bool
}

type Field struct {
	Name         string
	Doc          string
	Anonymous    bool
	Required     bool
	JSONProperty string
	JSONInline   bool
}

func (l *ASTLoader) Load() (map[string]Package, error) {

	var conf loader.Config
	conf.ParserMode = parser.ParseComments

	for _, pkg := range l.requestedPackages {
		conf.Import(pkg)
	}

	prog, err := conf.Load()
	if err != nil {
		return nil, errors.Wrap(err, "cannot load requested packages")
	}

	loadedPackages := make(map[string]Package, len(l.requestedPackages))
	for _, pkg := range prog.InitialPackages() {
		pkgPath := pkg.Pkg.Path()

		l.logger.Debug("parsing package", "package", pkgPath)

		l.logger.Debug("extracting package docs", "package", pkgPath)
		pkgDoc := astutils.PackageDoc(pkgPath, pkg.Files, prog.Fset)

		exportedTypes := make(map[string]Type)
		for _, file := range pkg.Files {
			filePos := prog.Fset.Position(file.Pos())
			l.logger.Debug("parsing file", "package", pkgPath, "file", filePos.Filename)
			if !ast.FileExports(file) {
				l.logger.Debug("skipping file - no exports", "package", pkgPath, "file", filePos.Filename)
				continue
			}

			parsedFile, err := parser.ParseFile(prog.Fset, filePos.Filename, nil, parser.ParseComments)
			if err != nil {
				return nil, errors.Wrapf(err, "failed to parse file %s", filePos.Filename)
			}

			l.logger.Debug("sorting comments", "package", pkgPath, "file", filePos.Filename)
			sortedComments := astutils.SortCommentsByPos(parsedFile.Comments)
			l.logger.Debug("sorting objects", "package", pkgPath, "file", filePos.Filename)
			sortedObjects := astutils.SortObjectsByPos(parsedFile.Scope.Objects)

			for i, currentObj := range sortedObjects {
				t, ok := currentObj.Decl.(*ast.TypeSpec)
				if !ok || !t.Name.IsExported() {
					continue
				}
				structDef, ok := t.Type.(*ast.StructType)
				if !ok || structDef.Fields.NumFields() == 0 {
					continue
				}

				structFields := make(map[string]Field, structDef.Fields.NumFields())
				for _, fld := range structDef.Fields.List {
					var ident *ast.Ident
					anonymous := false
					if len(fld.Names) > 0 {
						ident = fld.Names[0]
					} else {
						anonymous = true
						switch t := fld.Type.(type) {
						case *ast.SelectorExpr:
							if t.Sel != nil {
								ident = t.Sel
							}
						case *ast.Ident:
							ident = t
						}
					}

					if !ident.IsExported() {
						continue
					}

					name := ident.Name

					if len(name) > 0 {
						required := true
						jsonProperty := name
						if fld.Tag != nil && len(fld.Tag.Value) > 0 {
							tags, err := reflect.ParseStructTags(strings.Trim(fld.Tag.Value, "`"))
							if err != nil {
								return nil, errors.Wrapf(err, "failed to parse struct tag `%s`", fld.Tag.Value)
							}

							for _, t := range tags {
								if t.Name == "json" {
									split := strings.Split(t.Value, ",")
									jsonProperty = split[0]
									for _, tagValue := range split[1:] {
										if tagValue == "omitempty" {
											required = false
										}
									}
									break
								}
							}
						}

						if jsonProperty != "-" {
							structFields[name] = Field{
								Name:         name,
								Doc:          strings.TrimSpace(fld.Doc.Text()),
								Anonymous:    anonymous,
								Required:     required,
								JSONProperty: jsonProperty,
								JSONInline:   len(jsonProperty) == 0,
							}
						}
					}
				}

				if len(structFields) == 0 {
					continue
				}

				var previousObj *ast.Object
				if i > 0 {
					previousObj = sortedObjects[i-1]
				}
				shouldGenerateClient, namespacedType := extractGenerateClient(currentObj, previousObj, prog.Fset, sortedComments)

				apiType := Type{
					Name:           currentObj.Name,
					Doc:            strings.TrimSpace(astutils.TypeDoc(pkgDoc, currentObj.Name)),
					GenerateClient: shouldGenerateClient,
					Namespaced:     namespacedType,
					Fields:         structFields,
				}
				exportedTypes[apiType.Name] = apiType
			}
		}

		if len(exportedTypes) == 0 {
			l.logger.Debug("skipping package - no exported types", "package", pkgPath)
			continue
		}

		loadedPackage := Package{
			Path:  pkg.Pkg.Path(),
			Types: exportedTypes,
		}
		loadedPackages[pkg.Pkg.Path()] = loadedPackage
	}

	return loadedPackages, nil
}

func extractGenerateClient(current *ast.Object, previous *ast.Object, fset *token.FileSet, comments []*ast.CommentGroup) (bool, bool) {
	previousLineNumber := 0
	if previous != nil {
		if n, ok := previous.Decl.(ast.Node); ok {
			previousLineNumber = fset.Position(n.End()).Line
		}
	}

	previousCommentIndex := sort.Search(len(comments), func(i int) bool {
		commentLineNumber := fset.Position(comments[i].Pos()).Line
		return previousLineNumber < commentLineNumber
	})

	if previousCommentIndex >= len(comments) {
		return false, false
	}

	currentPos := fset.Position(current.Pos())
	currentLineNumber := currentPos.Line
	i := previousCommentIndex
	for {
		if i == len(comments) {
			return false, false
		}
		commentLineNumber := fset.Position(comments[i].Pos()).Line
		if commentLineNumber >= currentLineNumber {
			return false, false
		}
		if strings.HasPrefix(strings.TrimSpace(comments[i].Text()), "+genclient") {
			previousCommentIndex = i
			break
		}
		i++
	}

	spl := strings.Split(strings.TrimSpace(comments[previousCommentIndex].Text()[1:]), ",")

	var (
		genClient  = false
		namespaced = true
	)

	if len(spl) > 0 {
		spl := strings.Split(spl[0], "=")
		genClient = len(spl) == 2 && spl[0] == "genclient" && spl[1] == "true"
	}
	if len(spl) > 1 {
		spl := strings.Split(spl[1], "=")
		namespaced = len(spl) != 2 || spl[0] != "nonNamespaced" || spl[1] != "true"
	}

	return genClient, namespaced
}
