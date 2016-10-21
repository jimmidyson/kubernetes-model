package io.fabric8.kubernetes.types.apis.autoscaling.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ScaleStatus represents the current status of a scale subresource.
 */
@Value.Immutable
abstract class AbstractScaleStatus {
  /*
   * actual number of observed instances of the scaled object.
   */
  @JsonProperty("replicas")
  public abstract Integer getReplicas();

  /*
   * label query over pods that should match the replicas count. This is same
   * as the label selector but in the string format to avoid introspection
   * by clients. The string will be in the same format as the query-param syntax.
   * More info about label selectors: http://releases.k8s.io/release-1.3/docs/user-guide/labels.md#label-selectors
   */
  @JsonProperty("selector")
  public abstract String getSelector();

}
