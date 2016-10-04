package main

import (
	"os"

	"github.com/inconshreveable/log15"
	flag "github.com/spf13/pflag"

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
	_ "k8s.io/kubernetes/pkg/api/unversioned"
	_ "k8s.io/kubernetes/pkg/api/v1"
	_ "k8s.io/kubernetes/pkg/apis/apps/v1alpha1"
	_ "k8s.io/kubernetes/pkg/apis/authentication/v1beta1"
	_ "k8s.io/kubernetes/pkg/apis/autoscaling/v1"
	_ "k8s.io/kubernetes/pkg/apis/batch/v1"
	_ "k8s.io/kubernetes/pkg/apis/batch/v2alpha1"
	_ "k8s.io/kubernetes/pkg/apis/extensions/v1beta1"
	_ "k8s.io/kubernetes/pkg/apis/policy/v1alpha1"
	_ "k8s.io/kubernetes/pkg/apis/rbac/v1alpha1"

	"github.com/fabric8io/kubernetes-model/pkg/loader"
	"github.com/fabric8io/kubernetes-model/pkg/log"
)

type config struct {
	Packages []string
}

var (
	defaultAPIPackages = []string{
		"k8s.io/kubernetes/pkg/api/unversioned",

		"k8s.io/kubernetes/pkg/api/v1",

		"k8s.io/kubernetes/pkg/apis/apps/v1alpha1",
		"k8s.io/kubernetes/pkg/apis/authentication/v1beta1",
		"k8s.io/kubernetes/pkg/apis/autoscaling/v1",
		"k8s.io/kubernetes/pkg/apis/batch/v1",
		"k8s.io/kubernetes/pkg/apis/batch/v2alpha1",
		"k8s.io/kubernetes/pkg/apis/extensions/v1beta1",
		"k8s.io/kubernetes/pkg/apis/policy/v1alpha1",
		"k8s.io/kubernetes/pkg/apis/rbac/v1alpha1",

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
	}

	defaultLogLevel = log15.LvlInfo

	packages = flag.StringSliceP("package", "p", defaultAPIPackages, "packages to generate JSON schema for")

	verbose = flag.BoolP("verbose", "v", false, "verbose output")
)

func main() {
	flag.Parse()

	logger := log.Log

	logger.SetHandler(log15.CallerFileHandler(log15.StderrHandler))

	logLvl := defaultLogLevel
	if *verbose {
		logLvl = log15.LvlDebug
	}
	logger.SetHandler(log15.LvlFilterHandler(logLvl, log.Log.GetHandler()))

	ldr := loader.New(*packages, logger)
	loadedPackages, err := ldr.Load()
	if err != nil {
		logger.Crit("failed to load packages", "error", err, "stack", err.Error())
		os.Exit(1)
	}

	logger.Info("loaded packages", "packages", loadedPackages)
}
