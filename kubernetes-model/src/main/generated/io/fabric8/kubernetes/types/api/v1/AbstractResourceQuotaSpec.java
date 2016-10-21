package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ResourceQuotaSpec defines the desired hard limits to enforce for Quota.
 */
@Value.Immutable
abstract class AbstractResourceQuotaSpec {
  /*
   * Hard is the set of desired hard limits for each named resource.
   * More info: http://releases.k8s.io/release-1.3/docs/design/admission_control_resource_quota.md#admissioncontrol-plugin-resourcequota
   */
  @JsonProperty("hard")
  public abstract java.util.Map<String, io.fabric8.kubernetes.types.api.resource.Quantity> getHard();

  /*
   * A collection of filters that must match each object tracked by a quota.
   * If not specified, the quota matches all objects.
   */
  @JsonProperty("scopes")
  public abstract java.util.List<String> getScopes();

}
