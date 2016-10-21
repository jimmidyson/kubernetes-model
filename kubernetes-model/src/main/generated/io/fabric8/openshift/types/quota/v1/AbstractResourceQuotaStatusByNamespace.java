package io.fabric8.openshift.types.quota.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ResourceQuotaStatusByNamespace gives status for a particular project
 */
@Value.Immutable
abstract class AbstractResourceQuotaStatusByNamespace {
  /*
   * Namespace the project this status applies to
   */
  @JsonProperty("namespace")
  public abstract String getNamespace();

  /*
   * Status indicates how many resources have been consumed by this project
   */
  @JsonProperty("status")
  public abstract io.fabric8.kubernetes.types.api.v1.ResourceQuotaStatus getStatus();

}
