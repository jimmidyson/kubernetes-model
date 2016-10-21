package io.fabric8.openshift.types.quota.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ClusterResourceQuotaList is a collection of ClusterResourceQuotas
 */
@Value.Immutable
abstract class AbstractClusterResourceQuotaList {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ClusterResourceQuotaList", "v1");
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
   * Standard object's metadata.
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.unversioned.ListMeta getMetadata();

  /*
   * Items is a list of ClusterResourceQuotas
   */
  @JsonProperty("items")
  public abstract java.util.List<io.fabric8.openshift.types.quota.v1.ClusterResourceQuota> getItems();

}
