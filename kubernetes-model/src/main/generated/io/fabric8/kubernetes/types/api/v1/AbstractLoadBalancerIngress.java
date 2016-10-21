package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * LoadBalancerIngress represents the status of a load-balancer ingress point:
 * traffic intended for the service should be sent to an ingress point.
 */
@Value.Immutable
abstract class AbstractLoadBalancerIngress {
  /*
   * IP is set for load-balancer ingress points that are IP based
   * (typically GCE or OpenStack load-balancers)
   */
  @JsonProperty("ip")
  public abstract String getIp();

  /*
   * Hostname is set for load-balancer ingress points that are DNS based
   * (typically AWS load-balancers)
   */
  @JsonProperty("hostname")
  public abstract String getHostname();

}
