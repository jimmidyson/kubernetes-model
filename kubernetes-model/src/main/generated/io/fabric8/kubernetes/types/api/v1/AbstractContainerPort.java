package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ContainerPort represents a network port in a single container.
 */
@Value.Immutable
abstract class AbstractContainerPort {
  /*
   * If specified, this must be an IANA_SVC_NAME and unique within the pod. Each
   * named port in a pod must have a unique name. Name for the port that can be
   * referred to by services.
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * Number of port to expose on the host.
   * If specified, this must be a valid port number, 0 < x < 65536.
   * If HostNetwork is specified, this must match ContainerPort.
   * Most containers do not need this.
   */
  @JsonProperty("hostPort")
  public abstract Integer getHostPort();

  /*
   * Number of port to expose on the pod's IP address.
   * This must be a valid port number, 0 < x < 65536.
   */
  @JsonProperty("containerPort")
  public abstract Integer getContainerPort();

  /*
   * Protocol for port. Must be UDP or TCP.
   * Defaults to "TCP".
   */
  @JsonProperty("protocol")
  public abstract String getProtocol();

  /*
   * What host IP to bind the external port to.
   */
  @JsonProperty("hostIP")
  public abstract String getHostIP();

}
