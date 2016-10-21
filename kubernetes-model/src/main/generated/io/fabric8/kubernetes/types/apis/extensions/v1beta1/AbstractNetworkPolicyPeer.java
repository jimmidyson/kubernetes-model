package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;


@Value.Immutable
abstract class AbstractNetworkPolicyPeer {
  /*
   * This is a label selector which selects Pods in this namespace.
   * This field follows standard label selector semantics.
   * If not provided, this selector selects no pods.
   * If present but empty, this selector selects all pods in this namespace.
   */
  @JsonProperty("podSelector")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.LabelSelector getPodSelector();

  /*
   * Selects Namespaces using cluster scoped-labels.  This
   * matches all pods in all namespaces selected by this label selector.
   * This field follows standard label selector semantics.
   * If omitted, this selector selects no namespaces.
   * If present but empty, this selector selects all namespaces.
   */
  @JsonProperty("namespaceSelector")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.LabelSelector getNamespaceSelector();

}
