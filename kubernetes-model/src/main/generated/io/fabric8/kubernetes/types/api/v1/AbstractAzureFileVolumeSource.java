package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * AzureFile represents an Azure File Service mount on the host and bind mount to the pod.
 */
@Value.Immutable
abstract class AbstractAzureFileVolumeSource {
  /*
   * the name of secret that contains Azure Storage Account Name and Key
   */
  @JsonProperty("secretName")
  public abstract String getSecretName();

  /*
   * Share Name
   */
  @JsonProperty("shareName")
  public abstract String getShareName();

  /*
   * Defaults to false (read/write). ReadOnly here will force
   * the ReadOnly setting in VolumeMounts.
   */
  @JsonProperty("readOnly")
  public abstract Boolean isReadOnly();

}
