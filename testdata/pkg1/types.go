package pkg1

// Struct1 is a brilliant struct.
type Struct1 struct {
	// ExportedField is a required public field.
	// With a two line comment.
	ExportedField string `json:"public"`

	// ExportedFieldOptional is an optinal field.
	ExportedFieldOptional string `json:"publicOptional,omitempty"`

	// unexportedField is not exported.
	unexportedField string

	// Nested struct from other package.
	pkg2.Pkg2Exported `json:"pkg2exported,omitempty"`

	// Inline unexportedStruct.
	unexportedStruct `json:",inline"`
}

// unexportedStruct is not exported.
type unexportedStruct struct {
	// ExportedField is an exported field of an unexported struct...
	ExportedField int `json:"exportedField"`

	// unexportedField is not exported from an struct that is not exported.
	unexportedField string
}
