package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * A node selector represents the union of the results of one or more label queries
 * over a set of nodes; that is, it represents the OR of the selectors represented
 * by the node selector terms.
 */
@Value.Immutable
abstract class AbstractNodeSelector {
  /*
   * Required. A list of node selector terms. The terms are ORed.
   */
  @JsonProperty("nodeSelectorTerms")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.NodeSelectorTerm> getNodeSelectorTerms();

}
