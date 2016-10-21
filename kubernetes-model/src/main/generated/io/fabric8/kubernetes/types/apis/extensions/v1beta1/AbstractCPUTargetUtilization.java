package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;


@Value.Immutable
abstract class AbstractCPUTargetUtilization {
  /*
   * fraction of the requested CPU that should be utilized/used,
   * e.g. 70 means that 70% of the requested CPU should be in use.
   */
  @JsonProperty("targetPercentage")
  public abstract Integer getTargetPercentage();

}
