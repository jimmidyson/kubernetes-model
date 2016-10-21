package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Selects a key from a ConfigMap.
 */
@Value.Immutable
abstract class AbstractConfigMapKeySelector {
  /*
   * The ConfigMap to select from.
   */
  @JsonUnwrapped
  public abstract io.fabric8.kubernetes.types.api.v1.LocalObjectReference getLocalObjectReference();

  /*
   * The key to select.
   */
  @JsonProperty("key")
  public abstract String getKey();

}
