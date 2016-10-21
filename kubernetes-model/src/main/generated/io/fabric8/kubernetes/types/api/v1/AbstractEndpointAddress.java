package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * EndpointAddress is a tuple that describes single IP address.
 */
@Value.Immutable
abstract class AbstractEndpointAddress {
  /*
   * The IP of this endpoint.
   * May not be loopback (127.0.0.0/8), link-local (169.254.0.0/16),
   * or link-local multicast ((224.0.0.0/24).
   * IPv6 is also accepted but not fully supported on all platforms. Also, certain
   * kubernetes components, like kube-proxy, are not IPv6 ready.
   * TODO: This should allow hostname or IP, See #4447.
   */
  @JsonProperty("ip")
  public abstract String getIp();

  /*
   * The Hostname of this endpoint
   */
  @JsonProperty("hostname")
  public abstract String getHostname();

  /*
   * Reference to object providing the endpoint.
   */
  @JsonProperty("targetRef")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getTargetRef();

}
