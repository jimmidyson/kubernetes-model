// 	Package unversioned is a generated protocol buffer package.
// 
// 	It is generated from these files:
// 		k8s.io/kubernetes/pkg/api/unversioned/generated.proto
// 
// 	It has these top-level messages:
// 		APIGroup
// 		APIGroupList
// 		APIResource
// 		APIResourceList
// 		APIVersions
// 		Duration
// 		ExportOptions
// 		GroupKind
// 		GroupResource
// 		GroupVersion
// 		GroupVersionForDiscovery
// 		GroupVersionKind
// 		GroupVersionResource
// 		LabelSelector
// 		LabelSelectorRequirement
// 		ListMeta
// 		RootPaths
// 		ServerAddressByClientCIDR
// 		Status
// 		StatusCause
// 		StatusDetails
// 		Time
// 		Timestamp
// 		TypeMeta
// 
// Package unversioned contains API types that are common to all versions.
// 
// The package contains two categories of types:
// - external (serialized) types that lack their own version (e.g TypeMeta)
// - internal (never-serialized) types that are needed by several different
//   api groups, and so live here, to avoid duplication and/or import loops
//   (e.g. LabelSelector).
// In the future, we will probably move these categories of objects into
// separate packages.
// 
@io.fabric8.kubernetes.types.api.ImmutablesStyle
package io.fabric8.kubernetes.types.api.unversioned;
