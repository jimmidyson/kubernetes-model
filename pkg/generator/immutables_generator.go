package generator

import (
	"go/types"
	"os"
	"path/filepath"
	"reflect"
	"text/template"

	"github.com/pkg/errors"

	"github.com/fabric8io/kubernetes-model/pkg/loader"
)

const immutableTemplateText = `package {{.Package}};
{{range $key, $type := .Imports}}
import {{$key}};{{end}}

import org.immutables.value.Value;

public interface {{.ClassName}} {{"{"}}{{range .Fields}}
    {{.}}();
{{end}}
}
`

var immutableTemplate = template.Must(template.New("immutable").Parse(immutableTemplateText))

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

	type data struct {
		Package   string
		ClassName string
		Imports   map[string]struct{}
		Fields    []string
	}

	imports := map[string]struct{}{}
	fields := make([]string, 0, len(typ.Fields))

	for _, fld := range typ.Fields {
		switch fldT := fld.Type.Underlying().(type) {
		case *types.Slice:
			imports["java.util.List"] = struct{}{}
			elemType := javaPackage(g.config.JavaRootPackage, fldT.Elem().String())
			imports[elemType] = struct{}{}
			fields = append(fields, "List<"+elemType+"> "+fld.JSONProperty)
		case *types.Map:
			imports["java.util.Map"] = struct{}{}
			keyType := javaPackage(g.config.JavaRootPackage, fldT.Key().String())
			imports[keyType] = struct{}{}
			elemType := javaPackage(g.config.JavaRootPackage, fldT.Elem().String())
			imports[elemType] = struct{}{}
			fields = append(fields, "Map<"+keyType+", "+elemType+"> "+fld.JSONProperty)
		case *types.Struct:
			javaType := javaPackage(g.config.JavaRootPackage, fld.TypeName)
			imports[javaType] = struct{}{}
			fields = append(fields, javaType+" "+fld.JSONProperty)
		case *types.Pointer:
			javaType := javaPackage(g.config.JavaRootPackage, fldT.Elem().String())
			imports[javaType] = struct{}{}
			fields = append(fields, javaType+" "+fld.JSONProperty)
		default:
			g.config.Logger.Error("unhandled field type", "type", typ.Name, "field", fld.Name, "fieldType", reflect.TypeOf(fldT))
		}
	}

	return immutableTemplate.Execute(f, data{
		Package:   pkg,
		ClassName: typ.Name,
		Imports:   imports,
		Fields:    fields,
	})
}
