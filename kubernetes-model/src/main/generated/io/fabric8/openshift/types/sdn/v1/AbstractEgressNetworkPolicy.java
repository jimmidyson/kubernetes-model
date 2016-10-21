package io.fabric8.openshift.types.sdn.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * EgressNetworkPolicy describes the current egress network policy for a Namespace. When using
 * the 'redhat/openshift-ovs-multitenant' network plugin, traffic from a pod to an IP address
 * outside the cluster will be checked against each EgressNetworkPolicyRule in the pod's
 * namespace's EgressNetworkPolicy, in order. If no rule matches (or no EgressNetworkPolicy
 * is present) then the traffic will be allowed by default.
 */
@Value.Immutable
abstract class AbstractEgressNetworkPolicy implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("EgressNetworkPolicy", "v1");
  }

  @Value.Derived
  public String getApiVersion() {
    return getTypeMeta().getApiVersion();
  }

  @Value.Derived
  public String getKind() {
    return getTypeMeta().getKind();
  }

  /*
   * metadata for EgressNetworkPolicy
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * spec is the specification of the current egress network policy
   */
  @JsonProperty("spec")
  public abstract io.fabric8.openshift.types.sdn.v1.EgressNetworkPolicySpec getSpec();

}
