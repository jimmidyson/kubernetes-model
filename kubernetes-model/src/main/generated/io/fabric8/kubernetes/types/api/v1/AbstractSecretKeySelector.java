package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SecretKeySelector selects a key of a Secret.
 */
@Value.Immutable
abstract class AbstractSecretKeySelector {
  /*
   * The name of the secret in the pod's namespace to select from.
   */
  @JsonUnwrapped
  public abstract io.fabric8.kubernetes.types.api.v1.LocalObjectReference getLocalObjectReference();

  /*
   * The key of the secret to select from.  Must be a valid secret key.
   */
  @JsonProperty("key")
  public abstract String getKey();

}
