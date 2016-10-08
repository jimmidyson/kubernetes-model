package generator

import (
	"path/filepath"
	"strings"
)

func javaPackage(rootPackage, pkgPath string) string {
	var javaSubPackage string
	if strings.HasPrefix(pkgPath, "github.com/openshift/origin/pkg/") {
		goApiPackage := strings.TrimPrefix(pkgPath, "github.com/openshift/origin/pkg/")
		javaSubPackage = "openshift.types." + strings.Replace(strings.Replace(goApiPackage, "/api", "", -1), "/", ".", -1)
	} else {
		goApiPackage := strings.TrimPrefix(pkgPath, "k8s.io/kubernetes/pkg/")
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
