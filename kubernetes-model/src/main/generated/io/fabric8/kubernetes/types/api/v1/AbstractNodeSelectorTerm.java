package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * A null or empty node selector term matches no objects.
 */
@Value.Immutable
abstract class AbstractNodeSelectorTerm {
  /*
   * Required. A list of node selector requirements. The requirements are ANDed.
   */
  @JsonProperty("matchExpressions")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.NodeSelectorRequirement> getMatchExpressions();

}
