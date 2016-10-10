package generator

import (
	"os"
	"path"
	"path/filepath"
	"regexp"
	"strings"
	"text/template"
	"unicode"
	"unicode/utf8"

	"github.com/pkg/errors"

	"github.com/fabric8io/kubernetes-model/pkg/loader"
)

const immutableTemplateText = `package {{.JavaPackage}};

import org.immutables.value.Value;

{{if .Doc}}{{comment .Doc ""}}{{end}}
@Value.Immutable
public abstract class {{.ClassName}} {{"{"}}{{$className := .ClassName}}{{$goPackage := .GoPackage}}{{range .Fields}}
{{if .Doc}}{{comment .Doc "  "}}{{end}}{{if eq .Name ""}}
  @JsonUnwrapped{{end}}{{if typeName .Type | ne "TypeMeta"}}
  public abstract {{.Type}} {{if .Name}}{{.Name}}{{else}}{{typeName .Type | lowerFirst}}{{end}}();{{else}}
  @Value.Derived
  public {{.Type}} {{typeName .Type | lowerFirst}}() {
    return {{.Type}}.of("{{$className}}", "{{apiVersion $goPackage}}");
  }{{end}}
{{end}}
}
`

var startOfLineRegexp = regexp.MustCompile(`(?m:^)`)

var immutableTemplate = template.Must(template.New("immutable").
	Funcs(
		template.FuncMap{
			"comment": func(doc string, indent string) string {
				return startOfLineRegexp.ReplaceAllString(doc, indent+"// ")
			},
			"typeName": func(s string) string {
				lastDotIndex := strings.LastIndex(s, ".")
				if lastDotIndex >= 0 {
					return s[lastDotIndex+1:]
				} else {
					return s
				}
			},
			"packageName": func(s string) string {
				lastDotIndex := strings.LastIndex(s, ".")
				if lastDotIndex >= 0 {
					return s[:lastDotIndex]
				} else {
					return s
				}
			},
			"lowerFirst": func(s string) string {
				if s == "" {
					return ""
				}
				r, n := utf8.DecodeRuneInString(s)
				return string(unicode.ToLower(r)) + s[n:]
			},
			"apiVersion": func(s string) string {
				apiVersion := path.Base(s)
				apiGroup := path.Base(strings.TrimSuffix(s, apiVersion))
				if apiGroup != "api" {
					apiVersion = apiGroup + "/" + apiVersion
				}
				return apiVersion
			},
		},
	).
	Parse(immutableTemplateText))

type immutablesGenerator struct {
	config Config
}

var _ Generator = &immutablesGenerator{}

func (g *immutablesGenerator) Generate(pkgs []loader.Package) error {
	g.config.Logger.Debug("generating")
	for _, pkg := range pkgs {
		javaPkg := javaPackage(g.config.JavaRootPackage, pkg.Path)
		pkgDir := javaPackageToDir(g.config.OutputDirectory, javaPkg)
		g.config.Logger.Debug("generating for package", "package", pkg.Path, "javaPackage", javaPkg, "dir", pkgDir)

		if err := os.MkdirAll(pkgDir, 0755); err != nil && os.IsExist(err) {
			return errors.Wrapf(err, "failed to create directory %s", pkgDir)
		}

		for _, typ := range pkg.Types {
			fp := filepath.Join(pkgDir, typ.Name+".java")

			if !g.config.Force {
				_, err := os.Stat(fp)
				if err == nil {
					return errors.Errorf("target file %s already exists", fp)
				}
				if !os.IsNotExist(err) {
					return errors.Errorf("failed to check if target file %s exists: %v", fp, err)
				}
			}

			f, err := os.OpenFile(fp, os.O_WRONLY|os.O_CREATE|os.O_TRUNC, 0644)
			if err != nil {
				return errors.Wrap(err, "failed to open file to write")
			}

			if err := g.write(javaPkg, typ, f); err != nil {
				return errors.Wrap(err, "failed to write file")
			}
		}
	}

	return nil
}

func (g *immutablesGenerator) write(pkg string, typ loader.Type, f *os.File) error {
	defer func() {
		_ = f.Close()
	}()

	type field struct {
		Type string
		Name string
		Doc  string
	}

	type data struct {
		JavaPackage string
		GoPackage   string
		ClassName   string
		Doc         string
		Fields      []field
	}

	fields := make([]field, 0, len(typ.Fields))

	for _, fld := range typ.Fields {
		javaType, err := javaType(g.config.JavaRootPackage, fld.Type, fld.TypeName)
		if err != nil {
			return errors.Wrapf(err, "unhandled field type %s for field %s.%s.%s", pkg, typ.Name, fld.Type.String())
		}

		fields = append(fields, field{javaType, fld.JSONProperty, fld.Doc})
	}

	return immutableTemplate.Execute(f, data{
		JavaPackage: pkg,
		GoPackage:   typ.Package,
		ClassName:   typ.Name,
		Doc:         typ.Doc,
		Fields:      fields,
	})
}
