package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SecretSpec specifies a secret to be included in a build pod and its corresponding mount point
 */
@Value.Immutable
abstract class AbstractSecretSpec {
  /*
   * secretSource is a reference to the secret
   */
  @JsonProperty("secretSource")
  public abstract io.fabric8.kubernetes.types.api.v1.LocalObjectReference getSecretSource();

  /*
   * mountPath is the path at which to mount the secret
   */
  @JsonProperty("mountPath")
  public abstract String getMountPath();

}
