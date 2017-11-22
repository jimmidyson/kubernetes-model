package generator

import (
	"github.com/inconshreveable/log15"
	"github.com/pkg/errors"

	"github.com/fabric8io/kubernetes-model/pkg/loader"
)

type Generator interface {
	Generate([]loader.Package) error
}

type Config struct {
	OutputDirectory string
	JavaRootPackage string
	Logger          log15.Logger
	Force           bool
}

func New(k string, c Config) (Generator, error) {
	c.Logger.Debug("creating generator", "type", k)
	switch k {
	case "immutables":
		return &immutablesGenerator{
			config: c,
		}, nil
	case "sundrio":
		return &sundrioGenerator{
			config: c,
		}, nil
	default:
		return nil, errors.Errorf("unknown generator type %s", k)
	}
}
