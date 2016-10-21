package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * IngressStatus describe the current state of the Ingress.
 */
@Value.Immutable
abstract class AbstractIngressStatus {
  /*
   * LoadBalancer contains the current status of the load-balancer.
   */
  @JsonProperty("loadBalancer")
  public abstract io.fabric8.kubernetes.types.api.v1.LoadBalancerStatus getLoadBalancer();

}
