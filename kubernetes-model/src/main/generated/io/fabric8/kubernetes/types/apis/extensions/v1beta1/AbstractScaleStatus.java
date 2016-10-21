package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * represents the current status of a scale subresource.
 */
@Value.Immutable
abstract class AbstractScaleStatus {
  /*
   * actual number of observed instances of the scaled object.
   */
  @JsonProperty("replicas")
  public abstract Integer getReplicas();

  /*
   * label query over pods that should match the replicas count. More info: http://releases.k8s.io/release-1.3/docs/user-guide/labels.md#label-selectors
   */
  @JsonProperty("selector")
  public abstract java.util.Map<String, String> getSelector();

  /*
   * label selector for pods that should match the replicas count. This is a serializated
   * version of both map-based and more expressive set-based selectors. This is done to
   * avoid introspection in the clients. The string will be in the same format as the
   * query-param syntax. If the target type only supports map-based selectors, both this
   * field and map-based selector field are populated.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/labels.md#label-selectors
   */
  @JsonProperty("targetSelector")
  public abstract String getTargetSelector();

}
