package generator

import (
	"go/types"
	"path/filepath"
	"regexp"
	"strings"

	"github.com/fabric8io/kubernetes-model/pkg/loader"
	"github.com/pkg/errors"
	codegenutils "k8s.io/code-generator/cmd/client-gen/generators/util"
)

var (
	kubernetesGoAPIPackagePrefix = regexp.MustCompile(`^k8s.io/(?:kubernetes|apimachinery)/pkg/`)

	openshiftGoAPIPackagePrefix = regexp.MustCompile(`^github.com/openshift/origin/pkg/[^/]+/apis/(?P<apiGroupName>[^/]+)/(?P<apiGroupVersion>[^/]+)`)
)

type field struct {
	Type     string
	Name     string
	Doc      string
	Optional bool
}

type data struct {
	JavaPackage   string
	GoPackage     string
	ClassName     string
	HasMetadata   bool
	HasTypeMeta   bool
	Doc           string
	Fields        []field
	LoaderPackage loader.Package
	Tags          codegenutils.Tags
	RootPackage   string
}

func javaPackage(rootPackage, pkgPath string) string {
	var javaSubPackage string
	if strings.HasPrefix(pkgPath, "github.com/openshift/origin/pkg/") {
		goApiPackage := openshiftGoAPIPackagePrefix.ReplaceAllString(pkgPath, "apis/${apiGroupName}/${apiGroupVersion}")
		javaSubPackage = "openshift.types." + strings.Replace(goApiPackage, "/", ".", -1)
	} else {
		goApiPackage := kubernetesGoAPIPackagePrefix.ReplaceAllString(pkgPath, "")
		javaSubPackage = "kubernetes.types." + strings.Replace(goApiPackage, "/", ".", -1)
	}

	return rootPackage + "." + javaSubPackage
}

func javaPackageToDir(rootDir, javaPackage string) string {
	return filepath.Join(
		rootDir,
		strings.Replace(javaPackage, ".", string(filepath.Separator), -1),
	)
}

func javaType(rootPackage string, typ types.Type, typeName string) (string, error) {
	switch fldT := typ.Underlying().(type) {
	case *types.Slice:
		elemType, err := javaType(rootPackage, fldT.Elem(), fldT.Elem().String())
		if err != nil {
			return "", err
		}
		return "java.util.List<" + elemType + ">", nil
	case *types.Map:
		keyType, err := javaType(rootPackage, fldT.Key(), fldT.Key().String())
		if err != nil {
			return "", err
		}
		elemType, err := javaType(rootPackage, fldT.Elem(), fldT.Elem().String())
		if err != nil {
			return "", err
		}
		return "java.util.Map<" + keyType + ", " + elemType + ">", nil
	case *types.Struct:
		switch typeName {
		case "k8s.io/apimachinery/pkg/runtime.RawExtension":
			return "io.fabric8.kubernetes.types.api.HasMetadata", nil
		case "k8s.io/apimachinery/pkg/apis/meta/v1.Time":
			return "java.time.ZonedDateTime", nil
		case "k8s.io/apimachinery/pkg/apis/meta/v1.MicroTime":
			return "java.time.ZonedDateTime", nil
		case "k8s.io/apimachinery/pkg/api/resource.Quantity":
			return "String", nil
		default:
			return javaPackage(rootPackage, typeName), nil
		}
	case *types.Pointer:
		return javaType(rootPackage, fldT.Elem(), fldT.Elem().String())
	case *types.Basic:
		return javaTypeBasic(fldT.Kind()), nil
	default:
		return "", errors.Errorf("unknown field type %s", fldT.String())
	}
}

func javaTypeBasic(kind types.BasicKind) string {
	switch kind {
	case types.Bool:
		return "Boolean"
	case types.Int, types.Int8, types.Int16, types.Int32,
		types.Uint, types.Uint8, types.Uint16, types.Uint32:
		return "Integer"
	case types.Int64, types.Uint64:
		return "Long"
	case types.String:
		return "String"
	case types.Float32, types.Float64:
		return "Float"
	default:
		return ""
	}
}
