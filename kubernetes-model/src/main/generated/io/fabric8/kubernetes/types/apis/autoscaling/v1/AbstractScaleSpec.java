package io.fabric8.kubernetes.types.apis.autoscaling.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ScaleSpec describes the attributes of a scale subresource.
 */
@Value.Immutable
abstract class AbstractScaleSpec {
  /*
   * desired number of instances for the scaled object.
   */
  @JsonProperty("replicas")
  public abstract Integer getReplicas();

}
