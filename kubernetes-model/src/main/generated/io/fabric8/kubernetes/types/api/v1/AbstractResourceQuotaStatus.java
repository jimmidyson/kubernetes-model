package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ResourceQuotaStatus defines the enforced hard limits and observed use.
 */
@Value.Immutable
abstract class AbstractResourceQuotaStatus {
  /*
   * Hard is the set of enforced hard limits for each named resource.
   * More info: http://releases.k8s.io/release-1.3/docs/design/admission_control_resource_quota.md#admissioncontrol-plugin-resourcequota
   */
  @JsonProperty("hard")
  public abstract java.util.Map<String, io.fabric8.kubernetes.types.api.resource.Quantity> getHard();

  /*
   * Used is the current observed total usage of the resource in the namespace.
   */
  @JsonProperty("used")
  public abstract java.util.Map<String, io.fabric8.kubernetes.types.api.resource.Quantity> getUsed();

}
