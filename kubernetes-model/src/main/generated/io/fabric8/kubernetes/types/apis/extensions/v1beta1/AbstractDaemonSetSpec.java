package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DaemonSetSpec is the specification of a daemon set.
 */
@Value.Immutable
abstract class AbstractDaemonSetSpec {
  /*
   * Selector is a label query over pods that are managed by the daemon set.
   * Must match in order to be controlled.
   * If empty, defaulted to labels on Pod template.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/labels.md#label-selectors
   */
  @JsonProperty("selector")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.LabelSelector getSelector();

  /*
   * Template is the object that describes the pod that will be created.
   * The DaemonSet will create exactly one copy of this pod on every node
   * that matches the template's node selector (or on every node if no node
   * selector is specified).
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/replication-controller.md#pod-template
   */
  @JsonProperty("template")
  public abstract io.fabric8.kubernetes.types.api.v1.PodTemplateSpec getTemplate();

}
