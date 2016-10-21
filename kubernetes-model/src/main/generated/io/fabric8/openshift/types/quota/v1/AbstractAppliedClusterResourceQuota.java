package io.fabric8.openshift.types.quota.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * AppliedClusterResourceQuota mirrors ClusterResourceQuota at a project scope, for projection
 * into a project.  It allows a project-admin to know which ClusterResourceQuotas are applied to
 * his project and their associated usage.
 */
@Value.Immutable
abstract class AbstractAppliedClusterResourceQuota implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("AppliedClusterResourceQuota", "v1");
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
