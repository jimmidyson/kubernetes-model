package io.fabric8.openshift.types.quota.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * AppliedClusterResourceQuotaList is a collection of AppliedClusterResourceQuotas
 */
@Value.Immutable
abstract class AbstractAppliedClusterResourceQuotaList {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("AppliedClusterResourceQuotaList", "v1");
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
   * Items is a list of AppliedClusterResourceQuota
   */
  @JsonProperty("items")
  public abstract java.util.List<io.fabric8.openshift.types.quota.v1.AppliedClusterResourceQuota> getItems();

}
