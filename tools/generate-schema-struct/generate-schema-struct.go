package main

import (
	"bytes"
	"fmt"
	"go/format"
	"go/types"
	"io/ioutil"
	"log"
	"os"
	"strconv"
	"strings"
	"text/template"

	"golang.org/x/tools/go/loader"

	_ "k8s.io/kubernetes/pkg/api/resource"
	_ "k8s.io/kubernetes/pkg/api/unversioned"
	_ "k8s.io/kubernetes/pkg/api/v1"
	_ "k8s.io/kubernetes/pkg/apis/apps/v1alpha1"
	_ "k8s.io/kubernetes/pkg/apis/authentication/v1beta1"
	_ "k8s.io/kubernetes/pkg/apis/authorization/v1beta1"
	_ "k8s.io/kubernetes/pkg/apis/autoscaling/v1"
	_ "k8s.io/kubernetes/pkg/apis/batch/v1"
	_ "k8s.io/kubernetes/pkg/apis/batch/v2alpha1"
	_ "k8s.io/kubernetes/pkg/apis/extensions/v1beta1"
	_ "k8s.io/kubernetes/pkg/apis/policy/v1alpha1"
	_ "k8s.io/kubernetes/pkg/apis/rbac/v1alpha1"
	_ "k8s.io/kubernetes/pkg/runtime"
	_ "k8s.io/kubernetes/pkg/util/intstr"

	_ "github.com/openshift/origin/pkg/authorization/api/v1"
	_ "github.com/openshift/origin/pkg/build/api/v1"
	_ "github.com/openshift/origin/pkg/deploy/api/v1"
	_ "github.com/openshift/origin/pkg/image/api/v1"
	_ "github.com/openshift/origin/pkg/oauth/api/v1"
	_ "github.com/openshift/origin/pkg/project/api/v1"
	_ "github.com/openshift/origin/pkg/quota/api/v1"
	_ "github.com/openshift/origin/pkg/route/api/v1"
	_ "github.com/openshift/origin/pkg/sdn/api/v1"
	_ "github.com/openshift/origin/pkg/security/api/v1"
	_ "github.com/openshift/origin/pkg/template/api/v1"
	_ "github.com/openshift/origin/pkg/user/api/v1"
)

var pkgs = []string{
	"github.com/openshift/origin/pkg/authorization/api/v1",
	"github.com/openshift/origin/pkg/build/api/v1",
	"github.com/openshift/origin/pkg/deploy/api/v1",
	"github.com/openshift/origin/pkg/image/api/v1",
	"github.com/openshift/origin/pkg/oauth/api/v1",
	"github.com/openshift/origin/pkg/project/api/v1",
	"github.com/openshift/origin/pkg/quota/api/v1",
	"github.com/openshift/origin/pkg/route/api/v1",
	"github.com/openshift/origin/pkg/sdn/api/v1",
	"github.com/openshift/origin/pkg/security/api/v1",
	"github.com/openshift/origin/pkg/template/api/v1",
	"github.com/openshift/origin/pkg/user/api/v1",

	"k8s.io/kubernetes/pkg/api/v1",
	"k8s.io/kubernetes/pkg/api/unversioned",
	"k8s.io/kubernetes/pkg/api/resource",

	"k8s.io/kubernetes/pkg/runtime",
	"k8s.io/kubernetes/pkg/watch/versioned",
	"k8s.io/kubernetes/pkg/util/intstr",

	"k8s.io/kubernetes/pkg/apis/autoscaling/v1",
	"k8s.io/kubernetes/pkg/apis/authentication/v1beta1",
	"k8s.io/kubernetes/pkg/apis/apps/v1alpha1",
	"k8s.io/kubernetes/pkg/apis/batch/v2alpha1",
	"k8s.io/kubernetes/pkg/apis/batch/v1",
	"k8s.io/kubernetes/pkg/apis/policy/v1alpha1",
	"k8s.io/kubernetes/pkg/apis/extensions/v1beta1",
	"k8s.io/kubernetes/pkg/apis/rbac/v1alpha1",
	"k8s.io/kubernetes/pkg/apis/authorization/v1beta1",
}

const schema = `/*
* CODE GENERATED AUTOMATICALLY
* THIS FILE SHOULD NOT BE EDITED BY HAND
*/

package main

import (
	"github.com/fabric8io/kubernetes-model/pkg/schemagen"
{{range .Imports}}	{{.}}
{{end}}
)

var packages = []schemagen.PackageDescriptor{
{{range .PackageMappings}}	{"{{.GoPackage}}", "{{.JavaPackage}}", "{{.SchemaPrefix}}"},
{{end}}
}

type Schema struct {
{{range .Structs}}	{{.}}
{{end}}
}
`

var t = template.Must(template.New("schema").Parse(schema))

type templateParams struct {
	Imports         []string
	Structs         []string
	PackageMappings []packageMapping
}

type packageMapping struct {
	GoPackage    string
	JavaPackage  string
	SchemaPrefix string
}

func main() {
	var conf loader.Config
	for _, pkgName := range pkgs {
		conf.Import(pkgName)
	}
	prog, err := conf.Load()
	if err != nil {
		fmt.Println(err)
		os.Exit(1)
	}
	var params templateParams
	for i, pkg := range prog.InitialPackages() {
		params.PackageMappings = append(params.PackageMappings, mapPackage(pkg.Pkg))

		scope := pkg.Pkg.Scope()
		aliasedPkg := strings.Replace(strings.Replace(pkg.Pkg.Path(), "/", "_", -1), ".", "_", -1)
		params.Imports = append(params.Imports, aliasedPkg+` "`+pkg.Pkg.Path()+`"`)
		for j, n := range scope.Names() {
			if n != "SchemeGroupVersion" && n != "Zero" {
				o := scope.Lookup(n)
				if o != nil && o.Exported() {
					if s, ok := o.Type().Underlying().(*types.Struct); ok {
						if s.NumFields() > 0 {
							params.Structs = append(params.Structs, "F"+strconv.Itoa(i)+"_"+strconv.Itoa(j)+" "+aliasedPkg+"."+n)
						}
					}
				}
			}
		}
	}
	var doc bytes.Buffer
	if err = t.Execute(&doc, params); err != nil {
		fmt.Println(err)
		os.Exit(1)
	}
	formatted, err := format.Source([]byte(doc.String()))
	if err != nil {
		fmt.Println(err)
		os.Exit(1)
	}
	err = ioutil.WriteFile("generated_schema.go", formatted, 0644)
	if err != nil {
		log.Fatalf("writing output: %s", err)
	}
}

func mapPackage(pkg *types.Package) packageMapping {
	if strings.HasPrefix(pkg.Path(), "github.com/openshift") {
		return mapOpenShiftPackage(pkg)
	}
	if strings.HasPrefix(pkg.Path(), "k8s.io/kubernetes/pkg/apis") {
		return mapKubernetesAPIsPackage(pkg)
	}
	if strings.HasPrefix(pkg.Path(), "k8s.io/kubernetes/pkg/api") {
		return mapKubernetesAPIPackage(pkg)
	}
	return mapMiscellaneousPackage(pkg)
}

func mapOpenShiftPackage(pkg *types.Package) packageMapping {
	splitPackagePath := strings.Split(pkg.Path(), "/")
	apiName := splitPackagePath[len(splitPackagePath)-3]
	apiVersion := splitPackagePath[len(splitPackagePath)-1]
	return packageMapping{
		GoPackage:    pkg.Path(),
		JavaPackage:  fmt.Sprintf("io.fabric8.openshift.api.model.%s.%s", apiName, apiVersion),
		SchemaPrefix: fmt.Sprintf("os_%s_%s_", apiName, apiVersion),
	}
}

func mapKubernetesAPIsPackage(pkg *types.Package) packageMapping {
	splitPackagePath := strings.Split(pkg.Path(), "/")
	apiName := splitPackagePath[len(splitPackagePath)-2]
	apiVersion := splitPackagePath[len(splitPackagePath)-1]
	return packageMapping{
		GoPackage:    pkg.Path(),
		JavaPackage:  fmt.Sprintf("io.fabric8.kubernetes.api.model.%s.%s", apiName, apiVersion),
		SchemaPrefix: fmt.Sprintf("kubernetes_%s_%s_", apiName, apiVersion),
	}
}

func mapKubernetesAPIPackage(pkg *types.Package) packageMapping {
	splitPackagePath := strings.Split(pkg.Path(), "/")
	apiName := splitPackagePath[len(splitPackagePath)-1]
	if apiName == "unversioned" {
		return packageMapping{
			GoPackage:    pkg.Path(),
			JavaPackage:  "io.fabric8.kubernetes.api.model",
			SchemaPrefix: fmt.Sprintf("kubernetes_api_%s_", apiName),
		}
	}
	return packageMapping{
		GoPackage:    pkg.Path(),
		JavaPackage:  fmt.Sprintf("io.fabric8.kubernetes.api.model.%s", apiName),
		SchemaPrefix: fmt.Sprintf("kubernetes_api_%s_", apiName),
	}
}

func mapMiscellaneousPackage(pkg *types.Package) packageMapping {
	splitPackagePath := strings.Split(pkg.Path(), "/")
	name := splitPackagePath[3:]
	return packageMapping{
		GoPackage:    pkg.Path(),
		JavaPackage:  fmt.Sprintf("io.fabric8.kubernetes.api.model.%s", strings.Join(name, ".")),
		SchemaPrefix: fmt.Sprintf("kubernetes_%s_", strings.Join(name, "_")),
	}
}
