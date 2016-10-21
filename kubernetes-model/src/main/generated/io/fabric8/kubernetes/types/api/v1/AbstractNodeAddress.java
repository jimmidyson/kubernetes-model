package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * NodeAddress contains information for the node's address.
 */
@Value.Immutable
abstract class AbstractNodeAddress {
  /*
   * Node address type, one of Hostname, ExternalIP or InternalIP.
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * The node address.
   */
  @JsonProperty("address")
  public abstract String getAddress();

}
