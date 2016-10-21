package io.fabric8.openshift.types.sdn.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * EgressNetworkPolicyRule contains a single egress network policy rule
 */
@Value.Immutable
abstract class AbstractEgressNetworkPolicyRule {
  /*
   * type marks this as an "Allow" or "Deny" rule
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * to is the target that traffic is allowed/denied to
   */
  @JsonProperty("to")
  public abstract io.fabric8.openshift.types.sdn.v1.EgressNetworkPolicyPeer getTo();

}
