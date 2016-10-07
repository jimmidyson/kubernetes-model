package pkg1

// +genclient=true

// Type1 is a normal type
// with a single field and a description.
type Type1 struct {
	// Some doc.
	Field1 int
	Field2 uint64 `json:"f2"`
	// Some more doc.
	Field3 uint64 `json:"-"`
	// Even more doc.
	Field4 uint64 `json:",omitempty"`
	// And some
	// more doc.
	Field5 uint64 `json:"f5,omitempty"`
	Type5  `json:",omitempty"`
}

// Type2 is a normal type
// with a single unexported field and a description.
type Type2 struct {
	field1 int
}

// type3 is an unexported type
// with a single unexported field and a description.
type type3 struct {
	field1 int
}

// type4 is an unexported type
// with a single exported field and a description.
type type4 struct {
	Field1 int
}

// +genclient=true,nonNamespaced=true

type Type5 struct {
	Type5Field uint64 `json:"t5"`
}
