package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * EndpointSubset is a group of addresses with a common set of ports. The
 * expanded set of endpoints is the Cartesian product of Addresses x Ports.
 * For example, given:
 *   {
 *     Addresses: [{"ip": "10.10.1.1"}, {"ip": "10.10.2.2"}],
 *     Ports:     [{"name": "a", "port": 8675}, {"name": "b", "port": 309}]
 *   }
 * The resulting set of endpoints can be viewed as:
 *     a: [ 10.10.1.1:8675, 10.10.2.2:8675 ],
 *     b: [ 10.10.1.1:309, 10.10.2.2:309 ]
 */
@Value.Immutable
abstract class AbstractEndpointSubset {
  /*
   * IP addresses which offer the related ports that are marked as ready. These endpoints
   * should be considered safe for load balancers and clients to utilize.
   */
  @JsonProperty("addresses")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.EndpointAddress> getAddresses();

  /*
   * IP addresses which offer the related ports but are not currently marked as ready
   * because they have not yet finished starting, have recently failed a readiness check,
   * or have recently failed a liveness check.
   */
  @JsonProperty("notReadyAddresses")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.EndpointAddress> getNotReadyAddresses();

  /*
   * Port numbers available on the related IP addresses.
   */
  @JsonProperty("ports")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.EndpointPort> getPorts();

}
