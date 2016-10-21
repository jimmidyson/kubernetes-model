package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * This NetworkPolicyIngressRule matches traffic if and only if the traffic matches both ports AND from.
 */
@Value.Immutable
abstract class AbstractNetworkPolicyIngressRule {
  /*
   * List of ports which should be made accessible on the pods selected for this rule.
   * Each item in this list is combined using a logical OR.
   * If this field is not provided, this rule matches all ports (traffic not restricted by port).
   * If this field is empty, this rule matches no ports (no traffic matches).
   * If this field is present and contains at least one item, then this rule allows traffic
   * only if the traffic matches at least one port in the list.
   * TODO: Update this to be a pointer to slice as soon as auto-generation supports it.
   */
  @JsonProperty("ports")
  public abstract java.util.List<io.fabric8.kubernetes.types.apis.extensions.v1beta1.NetworkPolicyPort> getPorts();

  /*
   * List of sources which should be able to access the pods selected for this rule.
   * Items in this list are combined using a logical OR operation.
   * If this field is not provided, this rule matches all sources (traffic not restricted by source).
   * If this field is empty, this rule matches no sources (no traffic matches).
   * If this field is present and contains at least on item, this rule allows traffic only if the
   * traffic matches at least one item in the from list.
   * TODO: Update this to be a pointer to slice as soon as auto-generation supports it.
   */
  @JsonProperty("from")
  public abstract java.util.List<io.fabric8.kubernetes.types.apis.extensions.v1beta1.NetworkPolicyPeer> getFrom();

}
