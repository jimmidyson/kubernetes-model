package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * EnvVarSource represents a source for the value of an EnvVar.
 */
@Value.Immutable
abstract class AbstractEnvVarSource {
  /*
   * Selects a field of the pod; only name and namespace are supported.
   */
  @JsonProperty("fieldRef")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectFieldSelector getFieldRef();

  /*
   * Selects a resource of the container: only resources limits and requests
   * (limits.cpu, limits.memory, requests.cpu and requests.memory) are currently supported.
   */
  @JsonProperty("resourceFieldRef")
  public abstract io.fabric8.kubernetes.types.api.v1.ResourceFieldSelector getResourceFieldRef();

  /*
   * Selects a key of a ConfigMap.
   */
  @JsonProperty("configMapKeyRef")
  public abstract io.fabric8.kubernetes.types.api.v1.ConfigMapKeySelector getConfigMapKeyRef();

  /*
   * Selects a key of a secret in the pod's namespace
   */
  @JsonProperty("secretKeyRef")
  public abstract io.fabric8.kubernetes.types.api.v1.SecretKeySelector getSecretKeyRef();

}
