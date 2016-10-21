package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ReplicationControllerSpec is the specification of a replication controller.
 */
@Value.Immutable
abstract class AbstractReplicationControllerSpec {
  /*
   * Replicas is the number of desired replicas.
   * This is a pointer to distinguish between explicit zero and unspecified.
   * Defaults to 1.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/replication-controller.md#what-is-a-replication-controller
   */
  @JsonProperty("replicas")
  public abstract Integer getReplicas();

  /*
   * Selector is a label query over pods that should match the Replicas count.
   * If Selector is empty, it is defaulted to the labels present on the Pod template.
   * Label keys and values that must match in order to be controlled by this replication
   * controller, if empty defaulted to labels on Pod template.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/labels.md#label-selectors
   */
  @JsonProperty("selector")
  public abstract java.util.Map<String, String> getSelector();

  /*
   * Template is the object that describes the pod that will be created if
   * insufficient replicas are detected. This takes precedence over a TemplateRef.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/replication-controller.md#pod-template
   */
  @JsonProperty("template")
  public abstract io.fabric8.kubernetes.types.api.v1.PodTemplateSpec getTemplate();

}
