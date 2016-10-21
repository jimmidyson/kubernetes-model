package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * LocalObjectReference contains enough information to let you locate the
 * referenced object inside the same namespace.
 */
@Value.Immutable
abstract class AbstractLocalObjectReference {
  /*
   * Name of the referent.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/identifiers.md#names
   * TODO: Add other useful fields. apiVersion, kind, uid?
   */
  @JsonProperty("name")
  public abstract String getName();

}
