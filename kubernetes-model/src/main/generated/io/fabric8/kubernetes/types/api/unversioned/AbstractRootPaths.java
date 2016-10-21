package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * RootPaths lists the paths available at root.
 * For example: "/healthz", "/apis".
 */
@Value.Immutable
abstract class AbstractRootPaths {
  /*
   * paths are the paths available at root.
   */
  @JsonProperty("paths")
  public abstract java.util.List<String> getPaths();

}
