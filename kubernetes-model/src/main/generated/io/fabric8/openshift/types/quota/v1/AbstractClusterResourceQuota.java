package io.fabric8.openshift.types.quota.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ClusterResourceQuota mirrors ResourceQuota at a cluster scope.  This object is easily convertible to
 * synthetic ResourceQuota object to allow quota evaluation re-use.
 */
@Value.Immutable
abstract class AbstractClusterResourceQuota implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ClusterResourceQuota", "v1");
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
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Spec defines the desired quota
   */
  @JsonProperty("spec")
  public abstract io.fabric8.openshift.types.quota.v1.ClusterResourceQuotaSpec getSpec();

  /*
   * Status defines the actual enforced quota and its current usage
   */
  @JsonProperty("status")
  public abstract io.fabric8.openshift.types.quota.v1.ClusterResourceQuotaStatus getStatus();

}
