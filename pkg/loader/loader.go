package loader

import (
	"go/ast"
	"go/parser"
	"go/token"
	"go/types"
	"regexp"
	"sort"
	"strings"

	"github.com/inconshreveable/log15"
	"github.com/pkg/errors"
	"golang.org/x/tools/go/loader"
	codegenutils "k8s.io/code-generator/cmd/client-gen/generators/util"
	reflectutils "k8s.io/kubernetes/third_party/forked/golang/reflect"

	"github.com/fabric8io/kubernetes-model/pkg/loader/astutils"
)

type ASTLoader struct {
	requestedPackages []string
	logger            log15.Logger
	prog              *loader.Program
}

func New(packages []string, logger log15.Logger) *ASTLoader {
	return &ASTLoader{requestedPackages: packages, logger: logger}
}

type Package struct {
	Path     string
	Types    []Type
	Doc      string
	APIGroup string
}

type Type struct {
	Name    string
	Package string
	Fields  []Field
	Doc     string
	Tags    codegenutils.Tags
}

type Field struct {
	Name         string
	Doc          string
	Anonymous    bool
	JSONRequired bool
	JSONProperty string
	Type         types.Type
	TypeName     string
}

var packageAPIGroupRegexp = regexp.MustCompile(`.*\+groupName=([a-zA-Z0-9.]+.*)`)

func (l *ASTLoader) Load() ([]Package, error) {

	var conf loader.Config
	conf.ParserMode = parser.ParseComments

	for _, pkg := range l.requestedPackages {
		conf.Import(pkg)
	}

	prog, err := conf.Load()
	if err != nil {
		return nil, errors.Wrap(err, "cannot load requested packages")
	}
	l.prog = prog

	loadedPackages := make([]Package, 0, len(l.requestedPackages))
	for _, pkg := range prog.InitialPackages() {
		pkgPath := pkg.Pkg.Path()

		if !l.isRequestedPackage(pkgPath) {
			continue
		}

		l.logger.Debug("parsing package", "package", pkgPath)

		l.logger.Debug("extracting package docs", "package", pkgPath)
		pkgDoc := astutils.PackageDoc(pkgPath, pkg.Files, prog.Fset)

		exportedTypes := []Type{}
		for _, file := range pkg.Files {
			filePos := prog.Fset.Position(file.Pos())
			l.logger.Debug("parsing file", "package", pkgPath, "file", filePos.Filename)

			parsedFile, err := parser.ParseFile(prog.Fset, filePos.Filename, nil, parser.ParseComments)
			if err != nil {
				return nil, errors.Wrapf(err, "failed to parse file %s", filePos.Filename)
			}
			l.logger.Debug("sorting comments", "package", pkgPath, "file", filePos.Filename)
			sortedComments := astutils.SortCommentsByPos(parsedFile.Comments)
			l.logger.Debug("sorting objects", "package", pkgPath, "file", filePos.Filename)
			sortedObjects := astutils.SortObjectsByPos(file.Scope.Objects)

			for i, currentObj := range sortedObjects {
				t, ok := currentObj.Decl.(*ast.TypeSpec)
				if !ok || !t.Name.IsExported() {
					continue
				}
				astStructType, ok := t.Type.(*ast.StructType)
				if !ok {
					continue
				}

				typ, ok := pkg.Types[t.Type]
				if !ok {
					return nil, errors.Errorf("unable to load struct type: %s", t.Name.Name)
				}
				structType, ok := typ.Type.(*types.Struct)
				if !ok {
					continue
				}
				l.logger.Debug("loaded struct type", "name", t.Name.Name)

				structFields := make([]Field, 0, structType.NumFields())

				for j := 0; j < structType.NumFields(); j++ {
					fld := structType.Field(j)
					if !fld.IsField() || !fld.Exported() {
						continue
					}

					fieldName := fld.Name()
					required := true
					fldTag := structType.Tag(j)
					tags, err := reflectutils.ParseStructTags(fldTag)
					if err != nil {
						return nil, errors.Wrapf(err, "failed to parse struct tag `%s`", fldTag)
					}

					for _, t := range tags {
						if t.Name == "protobuf" {
							if t.Value == "-" {
								fieldName = "-"
								break
							}
							split := strings.Split(t.Value, ",")
							for _, tagValue := range split {
								if strings.HasPrefix(tagValue, "name=") {
									fieldName = tagValue[5:]
								}
								if tagValue == "opt" {
									required = false
								}
							}
							break
						}
						if t.Name == "json" {
							if t.Value == "-" {
								fieldName = "-"
								break
							}
							split := strings.Split(t.Value, ",")
							if split[0] != "" {
								fieldName = split[0]
							}
							for _, tagValue := range split[1:] {
								switch tagValue {
								case "omitempty":
									required = false
								case "inline":
									fieldName = ""
								}
							}
							break
						}
					}

					if fieldName == "-" {
						l.logger.Debug("ignoring struct field as not serialized", "struct", t.Name.Name, "field", fld.Name())
						continue
					}

					l.logger.Debug("adding struct field", "struct", t.Name.Name, "field", fld.Name(), "type", fld.Type().String())
					fldDoc := ""
					if j < astStructType.Fields.NumFields() {
						fldDoc = strings.TrimSpace(astStructType.Fields.List[j].Doc.Text())
					}

					f := Field{
						Name:         fld.Name(),
						Doc:          fldDoc,
						Type:         fld.Type(),
						TypeName:     fld.Type().String(),
						Anonymous:    fld.Anonymous(),
						JSONProperty: fieldName,
						JSONRequired: required && !strings.Contains(fldDoc, "+optional"),
					}
					structFields = append(structFields, f)
					l.logger.Debug("added struct field defition", "struct", t.Name.Name, "field", f)
				}

				if len(structFields) == 0 {
					continue
				}

				var previousObj *ast.Object
				if 0 < i {
					previousObj = sortedObjects[i-1]
				}
				clientTags := extractGenerateClient(currentObj, previousObj, prog.Fset, sortedComments)

				apiType := Type{
					Name:    currentObj.Name,
					Package: pkgPath,
					Doc:     strings.TrimSpace(astutils.TypeDoc(pkgDoc, currentObj.Name)),
					Fields:  structFields,
					Tags:    clientTags,
				}
				exportedTypes = append(exportedTypes, apiType)
			}
		}

		if len(exportedTypes) == 0 {
			l.logger.Debug("skipping package - no exported types", "package", pkgPath)
			continue
		}

		apiGroup := ""

		if matchedAPIGroup := packageAPIGroupRegexp.FindStringSubmatch(pkgDoc.Doc); len(matchedAPIGroup) == 2 {
			apiGroup = matchedAPIGroup[1]
		}

		loadedPackage := Package{
			Path:     pkg.Pkg.Path(),
			Types:    exportedTypes,
			Doc:      pkgDoc.Doc,
			APIGroup: apiGroup,
		}
		loadedPackages = append(loadedPackages, loadedPackage)
	}

	return loadedPackages, nil
}
func (l *ASTLoader) isRequestedPackage(pkgPath string) bool {
	for _, pkg := range l.requestedPackages {
		if pkg == pkgPath {
			return true
		}
	}
	return false
}

func extractGenerateClient(current *ast.Object, previous *ast.Object, fset *token.FileSet, comments []*ast.CommentGroup) codegenutils.Tags {
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
		return codegenutils.Tags{}
	}

	currentPos := fset.Position(current.Pos())
	currentLineNumber := currentPos.Line
	i := previousCommentIndex
	var commentsStrings []string
	for {
		if i == len(comments) {
			break
		}
		commentLineNumber := fset.Position(comments[i].Pos()).Line
		if commentLineNumber >= currentLineNumber {
			break
		}
		for _, s := range strings.Split(comments[i].Text(), "\n") {
			commentsStrings = append(commentsStrings, s)
		}
		i++
	}

	return codegenutils.MustParseClientGenTags(commentsStrings)
}
