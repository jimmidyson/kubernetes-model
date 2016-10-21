package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Represents a Flocker volume mounted by the Flocker agent.
 * Flocker volumes do not support ownership management or SELinux relabeling.
 */
@Value.Immutable
abstract class AbstractFlockerVolumeSource {
  /*
   * Required: the volume name. This is going to be store on metadata -> name on the payload for Flocker
   */
  @JsonProperty("datasetName")
  public abstract String getDatasetName();

}
