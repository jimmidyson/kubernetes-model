package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * TCPSocketAction describes an action based on opening a socket
 */
@Value.Immutable
abstract class AbstractTCPSocketAction {
  /*
   * Number or name of the port to access on the container.
   * Number must be in the range 1 to 65535.
   * Name must be an IANA_SVC_NAME.
   */
  @JsonProperty("port")
  public abstract io.fabric8.kubernetes.types.util.intstr.IntOrString getPort();

}
