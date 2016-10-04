package loader_test

import (
	. "github.com/onsi/ginkgo"
	. "github.com/onsi/gomega"

	. "github.com/fabric8io/kubernetes-model/pkg/loader"
	"github.com/inconshreveable/log15"
)

var _ = Describe("Loader", func() {
	var logger log15.Logger

	BeforeSuite(func() {
		logger = log15.New()
		logger.SetHandler(log15.DiscardHandler())
	})

	It("errors for unknown packages", func() {
		loader := New([]string{"github.com/fabric8io/kubernetes-model/pkg/loader/testdata/unknown"}, logger)
		_, err := loader.Load()
		Expect(err).To(HaveOccurred())
	})

	It("parses single packages", func() {
		loader := New([]string{"github.com/fabric8io/kubernetes-model/pkg/loader/testdata/pkg1"}, logger)
		pkgs, err := loader.Load()
		Expect(err).NotTo(HaveOccurred())
		Expect(pkgs).To(HaveLen(1))
		Expect(pkgs).To(Equal(map[string]Package{
			"github.com/fabric8io/kubernetes-model/pkg/loader/testdata/pkg1": {
				Path: "github.com/fabric8io/kubernetes-model/pkg/loader/testdata/pkg1",
				Types: map[string]Type{
					"Type1": {
						Name: "Type1",
						Fields: map[string]Field{
							"Field1": {Name: "Field1", Doc: "Some doc.", Anonymous: false, Required: true, JSONProperty: "Field1", JSONInline: false},
							"Field2": {Name: "Field2", Doc: "", Anonymous: false, Required: true, JSONProperty: "f2", JSONInline: false},
							"Field4": {Name: "Field4", Doc: "Even more doc.", Anonymous: false, Required: false, JSONProperty: "", JSONInline: true},
							"Field5": {Name: "Field5", Doc: "And some\nmore doc.", Anonymous: false, Required: false, JSONProperty: "f5", JSONInline: false},
							"Type5":  {Name: "Type5", Doc: "", Anonymous: true, Required: false, JSONProperty: "", JSONInline: true},
						},
						Doc:            "Type1 is a normal type\nwith a single field and a description.",
						GenerateClient: false,
						Namespaced:     false,
					},
					"Type5": {
						Name: "Type5",
						Fields: map[string]Field{
							"Type5Field": {Name: "Type5Field", Doc: "", Anonymous: false, Required: true, JSONProperty: "t5", JSONInline: false},
						},
						Doc:            "",
						GenerateClient: false,
						Namespaced:     false,
					},
				},
			},
		}))
	})
})
