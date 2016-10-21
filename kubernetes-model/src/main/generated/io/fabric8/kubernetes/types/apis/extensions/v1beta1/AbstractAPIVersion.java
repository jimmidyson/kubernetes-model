package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * An APIVersion represents a single concrete version of an object model.
 */
@Value.Immutable
abstract class AbstractAPIVersion {
  /*
   * Name of this version (e.g. 'v1').
   */
  @JsonProperty("name")
  public abstract String getName();

}
