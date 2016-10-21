package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ServerAddressByClientCIDR helps the client to determine the server address that they should use, depending on the clientCIDR that they match.
 */
@Value.Immutable
abstract class AbstractServerAddressByClientCIDR {
  /*
   * The CIDR with which clients can match their IP to figure out the server address that they should use.
   */
  @JsonProperty("clientCIDR")
  public abstract String getClientCIDR();

  /*
   * Address of this server, suitable for a client that matches the above CIDR.
   * This can be a hostname, hostname:port, IP or IP:port.
   */
  @JsonProperty("serverAddress")
  public abstract String getServerAddress();

}
