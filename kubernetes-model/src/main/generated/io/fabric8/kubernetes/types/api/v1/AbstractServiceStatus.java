package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ServiceStatus represents the current status of a service.
 */
@Value.Immutable
abstract class AbstractServiceStatus {
  /*
   * LoadBalancer contains the current status of the load-balancer,
   * if one is present.
   */
  @JsonProperty("loadBalancer")
  public abstract io.fabric8.kubernetes.types.api.v1.LoadBalancerStatus getLoadBalancer();

}
