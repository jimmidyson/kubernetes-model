package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DaemonEndpoint contains information about a single Daemon endpoint.
 */
@Value.Immutable
abstract class AbstractDaemonEndpoint {
  /*
   * Port number of the given endpoint.
   */
  @JsonProperty("Port")
  public abstract Integer getPort();

}
