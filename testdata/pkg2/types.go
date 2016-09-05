package pkg2

type Int64Alias int64

// Pkg2Exported is exported from pkg2
type Pkg2Exported struct {
	// TypeAliasField uses a type alias.
	TypeAliasField Int64Alias `json:"typeAliasField"`

	// PointerField is a pointer field.
	PointerField *int64 `json:"pointerField,omitempty"`
}
