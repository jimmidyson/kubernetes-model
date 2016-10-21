package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * TypeMeta describes an individual object in an API response or request
 * with strings representing the type of the object and its API schema version.
 * Structures that are versioned or persisted should inline TypeMeta.
 */
@Value.Immutable
abstract class AbstractTypeMeta {
  /*
   * Kind is a string value representing the REST resource this object represents.
   * Servers may infer this from the endpoint the client submits requests to.
   * Cannot be updated.
   * In CamelCase.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  public abstract String getKind();

  /*
   * APIVersion defines the versioned schema of this representation of an object.
   * Servers should convert recognized schemas to the latest internal value, and
   * may reject unrecognized values.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#resources
   */
  @JsonProperty("apiVersion")
  public abstract String getApiVersion();

}
