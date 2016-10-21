package io.fabric8.openshift.types.quota.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ClusterResourceQuotaSpec defines the desired quota restrictions
 */
@Value.Immutable
abstract class AbstractClusterResourceQuotaSpec {
  /*
   * Selector is the selector used to match projects.
   * It should only select active projects on the scale of dozens (though it can select
   * many more less active projects).  These projects will contend on object creation through
   * this resource.
   */
  @JsonProperty("selector")
  public abstract io.fabric8.openshift.types.quota.v1.ClusterResourceQuotaSelector getSelector();

  /*
   * Quota defines the desired quota
   */
  @JsonProperty("quota")
  public abstract io.fabric8.kubernetes.types.api.v1.ResourceQuotaSpec getQuota();

}
