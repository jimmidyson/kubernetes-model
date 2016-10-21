package io.fabric8.openshift.types.sdn.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * EgressNetworkPolicyPeer specifies a target to apply egress network policy to
 */
@Value.Immutable
abstract class AbstractEgressNetworkPolicyPeer {
  /*
   * cidrSelector is the CIDR range to allow/deny traffic to
   */
  @JsonProperty("cidrSelector")
  public abstract String getCidrSelector();

}
