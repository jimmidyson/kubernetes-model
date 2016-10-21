package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Adds and removes POSIX capabilities from running containers.
 */
@Value.Immutable
abstract class AbstractCapabilities {
  /*
   * Added capabilities
   */
  @JsonProperty("add")
  public abstract java.util.List<String> getAdd();

  /*
   * Removed capabilities
   */
  @JsonProperty("drop")
  public abstract java.util.List<String> getDrop();

}
