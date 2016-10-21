package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * LoadBalancerStatus represents the status of a load-balancer.
 */
@Value.Immutable
abstract class AbstractLoadBalancerStatus {
  /*
   * Ingress is a list containing ingress points for the load-balancer.
   * Traffic intended for the service should be sent to these ingress points.
   */
  @JsonProperty("ingress")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.LoadBalancerIngress> getIngress();

}
