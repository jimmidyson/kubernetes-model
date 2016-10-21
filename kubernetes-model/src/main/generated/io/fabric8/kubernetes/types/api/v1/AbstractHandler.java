package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Handler defines a specific action that should be taken
 * TODO: pass structured data to these actions, and document that data here.
 */
@Value.Immutable
abstract class AbstractHandler {
  /*
   * One and only one of the following should be specified.
   * Exec specifies the action to take.
   */
  @JsonProperty("exec")
  public abstract io.fabric8.kubernetes.types.api.v1.ExecAction getExec();

  /*
   * HTTPGet specifies the http request to perform.
   */
  @JsonProperty("httpGet")
  public abstract io.fabric8.kubernetes.types.api.v1.HTTPGetAction getHttpGet();

  /*
   * TCPSocket specifies an action involving a TCP port.
   * TCP hooks not yet supported
   * TODO: implement a realistic TCP lifecycle hook
   */
  @JsonProperty("tcpSocket")
  public abstract io.fabric8.kubernetes.types.api.v1.TCPSocketAction getTcpSocket();

}
