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

	// It("parses single packages", func() {
	// 	loader := New([]string{"github.com/fabric8io/kubernetes-model/pkg/loader/testdata/pkg1"}, logger)
	// 	pkgs, err := loader.Load()
	// 	Expect(err).NotTo(HaveOccurred())
	// 	Expect(pkgs).To(HaveLen(1))
	// 	Expect(pkgs).To(Equal(map[string]Package{
	// 		"github.com/fabric8io/kubernetes-model/pkg/loader/testdata/pkg1": {
	// 			Path: "github.com/fabric8io/kubernetes-model/pkg/loader/testdata/pkg1",
	// 			Types: []Type{
	// 				{
	// 					Name: "Type1",
	// 					Fields: []Field{
	// 						{Name: "Field1", Doc: "Some doc.", Anonymous: false, JSONRequired: true, JSONProperty: "Field1", Type: types.Typ[types.Int]},
	// 						{Name: "Field2", Doc: "", Anonymous: false, JSONRequired: true, JSONProperty: "f2", Type: types.Typ[types.String]},
	// 						{Name: "Field4", Doc: "Even more doc.", Anonymous: false, JSONRequired: false, JSONProperty: "", Type: types.NewSlice(types.Typ[types.String])},
	// 						{Name: "Field5", Doc: "And some\nmore doc.", Anonymous: false, JSONRequired: false, JSONProperty: "f5", Type: types.NewMap(types.Typ[types.String], types.Typ[types.Bool])},
	// 						{Name: "Type5", Doc: "", Anonymous: true, JSONRequired: false, JSONProperty: "", Type: pkgs["github.com/fabric8io/kubernetes-model/pkg/loader/testdata/pkg1"].Types["Type1"].Fields["Type5"].Type},
	// 						{Name: "Type5s", Doc: "", JSONRequired: false, JSONProperty: "t5s", Type: pkgs["github.com/fabric8io/kubernetes-model/pkg/loader/testdata/pkg1"].Types["Type1"].Fields["Type5s"].Type},
	// 					},
	// 					Doc:            "Type1 is a normal type\nwith a single field and a description.",
	// 					GenerateClient: true,
	// 					Namespaced:     true,
	// 				},
	// 				{
	// 					Name: "Type5",
	// 					Fields: []Field{
	// 						{Name: "Type5Field", Doc: "Something.", Anonymous: false, JSONRequired: true, JSONProperty: "t5", Type: types.Typ[types.Uint32]},
	// 						{Name: "Type5Field2", Doc: "Something else.", Anonymous: false, JSONRequired: true, JSONProperty: "t6", Type: types.NewSlice(types.Typ[types.Uint32])},
	// 					},
	// 					Doc:            "",
	// 					GenerateClient: true,
	// 					Namespaced:     false,
	// 				},
	// 			},
	// 		},
	// 	}))
	// })
})
