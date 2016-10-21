package io.fabric8.openshift.types.quota.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ClusterResourceQuotaStatus defines the actual enforced quota and its current usage
 */
@Value.Immutable
abstract class AbstractClusterResourceQuotaStatus {
  /*
   * Total defines the actual enforced quota and its current usage across all projects
   */
  @JsonProperty("total")
  public abstract io.fabric8.kubernetes.types.api.v1.ResourceQuotaStatus getTotal();

  /*
   * Namespaces slices the usage by project.  This division allows for quick resolution of
   * deletion reconcilation inside of a single project without requiring a recalculation
   * across all projects.  This can be used to pull the deltas for a given project.
   */
  @JsonProperty("namespaces")
  public abstract java.util.List<io.fabric8.openshift.types.quota.v1.ResourceQuotaStatusByNamespace> getNamespaces();

}
