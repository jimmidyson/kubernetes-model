package io.fabric8.openshift.types.sdn.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * EgressNetworkPolicySpec provides a list of policies on outgoing network traffic
 */
@Value.Immutable
abstract class AbstractEgressNetworkPolicySpec {
  /*
   * egress contains the list of egress policy rules
   */
  @JsonProperty("egress")
  public abstract java.util.List<io.fabric8.openshift.types.sdn.v1.EgressNetworkPolicyRule> getEgress();

}
