package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * HTTPGetAction describes an action based on HTTP Get requests.
 */
@Value.Immutable
abstract class AbstractHTTPGetAction {
  /*
   * Path to access on the HTTP server.
   */
  @JsonProperty("path")
  public abstract String getPath();

  /*
   * Name or number of the port to access on the container.
   * Number must be in the range 1 to 65535.
   * Name must be an IANA_SVC_NAME.
   */
  @JsonProperty("port")
  public abstract io.fabric8.kubernetes.types.util.intstr.IntOrString getPort();

  /*
   * Host name to connect to, defaults to the pod IP. You probably want to set
   * "Host" in httpHeaders instead.
   */
  @JsonProperty("host")
  public abstract String getHost();

  /*
   * Scheme to use for connecting to the host.
   * Defaults to HTTP.
   */
  @JsonProperty("scheme")
  public abstract String getScheme();

  /*
   * Custom headers to set in the request. HTTP allows repeated headers.
   */
  @JsonProperty("httpHeaders")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.HTTPHeader> getHttpHeaders();

}
