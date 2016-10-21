package io.fabric8.openshift.types.sdn.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * EgressNetworkPolicyList is a collection of EgressNetworkPolicy
 */
@Value.Immutable
abstract class AbstractEgressNetworkPolicyList {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("EgressNetworkPolicyList", "v1");
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
   * metadata for EgressNetworkPolicyList
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.unversioned.ListMeta getMetadata();

  /*
   * items is the list of policies
   */
  @JsonProperty("items")
  public abstract java.util.List<io.fabric8.openshift.types.sdn.v1.EgressNetworkPolicy> getItems();

}
