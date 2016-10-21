package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ResourceFieldSelector represents container resources (cpu, memory) and their output format
 */
@Value.Immutable
abstract class AbstractResourceFieldSelector {
  /*
   * Container name: required for volumes, optional for env vars
   */
  @JsonProperty("containerName")
  public abstract String getContainerName();

  /*
   * Required: resource to select
   */
  @JsonProperty("resource")
  public abstract String getResource();

  /*
   * Specifies the output format of the exposed resources, defaults to "1"
   */
  @JsonProperty("divisor")
  public abstract io.fabric8.kubernetes.types.api.resource.Quantity getDivisor();

}
