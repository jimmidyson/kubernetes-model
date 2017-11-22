package main

import (
	"os"

	"github.com/inconshreveable/log15"
	flag "github.com/spf13/pflag"

	_ "k8s.io/apimachinery/pkg/apis/meta/v1"

	_ "github.com/openshift/origin/pkg/apps/apis/apps/v1"
	_ "github.com/openshift/origin/pkg/authorization/apis/authorization/v1"
	_ "github.com/openshift/origin/pkg/build/apis/build/v1"
	_ "github.com/openshift/origin/pkg/image/apis/image/v1"
	_ "github.com/openshift/origin/pkg/network/apis/network/v1"
	_ "github.com/openshift/origin/pkg/oauth/apis/oauth/v1"
	_ "github.com/openshift/origin/pkg/project/apis/project/v1"
	_ "github.com/openshift/origin/pkg/quota/apis/quota/v1"
	_ "github.com/openshift/origin/pkg/route/apis/route/v1"
	_ "github.com/openshift/origin/pkg/security/apis/security/v1"
	_ "github.com/openshift/origin/pkg/template/apis/template/v1"
	_ "github.com/openshift/origin/pkg/user/apis/user/v1"

	_ "k8s.io/kubernetes/pkg/api/v1"
	_ "k8s.io/kubernetes/pkg/apis/admission/v1alpha1"
	_ "k8s.io/kubernetes/pkg/apis/admissionregistration/v1alpha1"
	_ "k8s.io/kubernetes/pkg/apis/apps/v1beta1"
	_ "k8s.io/kubernetes/pkg/apis/authentication/v1"
	_ "k8s.io/kubernetes/pkg/apis/authentication/v1beta1"
	_ "k8s.io/kubernetes/pkg/apis/authorization/v1"
	_ "k8s.io/kubernetes/pkg/apis/authorization/v1beta1"
	_ "k8s.io/kubernetes/pkg/apis/autoscaling/v1"
	_ "k8s.io/kubernetes/pkg/apis/autoscaling/v2alpha1"
	_ "k8s.io/kubernetes/pkg/apis/batch/v1"
	_ "k8s.io/kubernetes/pkg/apis/batch/v2alpha1"
	_ "k8s.io/kubernetes/pkg/apis/certificates/v1beta1"
	_ "k8s.io/kubernetes/pkg/apis/extensions/v1beta1"
	_ "k8s.io/kubernetes/pkg/apis/imagepolicy/v1alpha1"
	_ "k8s.io/kubernetes/pkg/apis/networking/v1"
	_ "k8s.io/kubernetes/pkg/apis/policy/v1beta1"
	_ "k8s.io/kubernetes/pkg/apis/rbac/v1alpha1"
	_ "k8s.io/kubernetes/pkg/apis/rbac/v1beta1"
	_ "k8s.io/kubernetes/pkg/apis/settings/v1alpha1"
	_ "k8s.io/kubernetes/pkg/apis/storage/v1"
	_ "k8s.io/kubernetes/pkg/apis/storage/v1beta1"

	"github.com/fabric8io/kubernetes-model/pkg/generator"
	"github.com/fabric8io/kubernetes-model/pkg/loader"
	"github.com/fabric8io/kubernetes-model/pkg/log"
)

var (
	defaultAPIPackages = []string{
		"k8s.io/apimachinery/pkg/apis/meta/v1",

		"k8s.io/kubernetes/pkg/api/v1",
		"k8s.io/kubernetes/pkg/apis/admission/v1alpha1",
		"k8s.io/kubernetes/pkg/apis/admissionregistration/v1alpha1",
		"k8s.io/kubernetes/pkg/apis/apps/v1beta1",
		"k8s.io/kubernetes/pkg/apis/authentication/v1",
		"k8s.io/kubernetes/pkg/apis/authentication/v1beta1",
		"k8s.io/kubernetes/pkg/apis/authorization/v1",
		"k8s.io/kubernetes/pkg/apis/authorization/v1beta1",
		"k8s.io/kubernetes/pkg/apis/autoscaling/v1",
		"k8s.io/kubernetes/pkg/apis/autoscaling/v2alpha1",
		"k8s.io/kubernetes/pkg/apis/batch/v1",
		"k8s.io/kubernetes/pkg/apis/batch/v2alpha1",
		"k8s.io/kubernetes/pkg/apis/certificates/v1beta1",
		"k8s.io/kubernetes/pkg/apis/extensions/v1beta1",
		"k8s.io/kubernetes/pkg/apis/imagepolicy/v1alpha1",
		"k8s.io/kubernetes/pkg/apis/meta/v1",
		"k8s.io/kubernetes/pkg/apis/networking/v1",
		"k8s.io/kubernetes/pkg/apis/policy/v1beta1",
		"k8s.io/kubernetes/pkg/apis/rbac/v1alpha1",
		"k8s.io/kubernetes/pkg/apis/rbac/v1beta1",
		"k8s.io/kubernetes/pkg/apis/settings/v1alpha1",
		"k8s.io/kubernetes/pkg/apis/storage/v1",
		"k8s.io/kubernetes/pkg/apis/storage/v1beta1",

		"github.com/openshift/origin/pkg/authorization/apis/authorization/v1",
		"github.com/openshift/origin/pkg/build/apis/build/v1",
		"github.com/openshift/origin/pkg/apps/apis/apps/v1",
		"github.com/openshift/origin/pkg/image/apis/image/v1",
		"github.com/openshift/origin/pkg/oauth/apis/oauth/v1",
		"github.com/openshift/origin/pkg/project/apis/project/v1",
		"github.com/openshift/origin/pkg/quota/apis/quota/v1",
		"github.com/openshift/origin/pkg/route/apis/route/v1",
		"github.com/openshift/origin/pkg/network/apis/network/v1",
		"github.com/openshift/origin/pkg/security/apis/security/v1",
		"github.com/openshift/origin/pkg/template/apis/template/v1",
		"github.com/openshift/origin/pkg/user/apis/user/v1",
	}

	defaultLogLevel = log15.LvlInfo

	defaultOutputDirectory = "kubernetes-model/src/main/java"

	defaultGenerator = "immutables"

	defaultJavaPackage = "io.fabric8"

	packages = flag.StringSliceP("package", "p", defaultAPIPackages, "packages to generate JSON schema for")

	verbose = flag.BoolP("verbose", "v", false, "verbose output")

	outputDirectory = flag.StringP("output-directory", "o", defaultOutputDirectory, "the directory to output generated files to")

	gen = flag.StringP("generator", "g", defaultGenerator, "the generator to use")

	javaPackage = flag.StringP("java-package", "j", defaultJavaPackage, "the root package to generate classes in")

	force = flag.BoolP("force", "f", false, "force overwrite of existing files")

	validGenerators = map[string]struct{}{
		"immutables": struct{}{},
		"sundrio":    struct{}{},
	}
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

	if _, ok := validGenerators[*gen]; !ok {
		logger.Crit("unknown generator", "generator", *gen)
		os.Exit(1)
	}

	cfg := generator.Config{
		OutputDirectory: *outputDirectory,
		JavaRootPackage: *javaPackage,
		Logger:          logger,
		Force:           *force,
	}

	g, err := generator.New(*gen, cfg)
	if err != nil {
		logger.Crit("failed to create generator", "error", err)
		os.Exit(1)
	}

	ldr := loader.New(*packages, logger)
	loadedPackages, err := ldr.Load()
	if err != nil {
		logger.Crit("failed to load packages", "error", err, "stack", err.Error())
		os.Exit(1)
	}

	if err := g.Generate(loadedPackages); err != nil {
		logger.Crit("failed to generate output", "error", err)
		os.Exit(1)
	}
}
