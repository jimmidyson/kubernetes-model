package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ResourceRequirements describes the compute resource requirements.
 */
@Value.Immutable
abstract class AbstractResourceRequirements {
  /*
   * Limits describes the maximum amount of compute resources allowed.
   * More info: http://releases.k8s.io/release-1.3/docs/design/resources.md#resource-specifications
   */
  @JsonProperty("limits")
  public abstract java.util.Map<String, io.fabric8.kubernetes.types.api.resource.Quantity> getLimits();

  /*
   * Requests describes the minimum amount of compute resources required.
   * If Requests is omitted for a container, it defaults to Limits if that is explicitly specified,
   * otherwise to an implementation-defined value.
   * More info: http://releases.k8s.io/release-1.3/docs/design/resources.md#resource-specifications
   */
  @JsonProperty("requests")
  public abstract java.util.Map<String, io.fabric8.kubernetes.types.api.resource.Quantity> getRequests();

}
