package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * EndpointPort is a tuple that describes a single port.
 */
@Value.Immutable
abstract class AbstractEndpointPort {
  /*
   * The name of this port (corresponds to ServicePort.Name).
   * Must be a DNS_LABEL.
   * Optional only if one port is defined.
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * The port number of the endpoint.
   */
  @JsonProperty("port")
  public abstract Integer getPort();

  /*
   * The IP protocol for this port.
   * Must be UDP or TCP.
   * Default is TCP.
   */
  @JsonProperty("protocol")
  public abstract String getProtocol();

}
