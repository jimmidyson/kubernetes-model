package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * An empty preferred scheduling term matches all objects with implicit weight 0
 * (i.e. it's a no-op). A null preferred scheduling term matches no objects (i.e. is also a no-op).
 */
@Value.Immutable
abstract class AbstractPreferredSchedulingTerm {
  /*
   * Weight associated with matching the corresponding nodeSelectorTerm, in the range 1-100.
   */
  @JsonProperty("weight")
  public abstract Integer getWeight();

  /*
   * A node selector term, associated with the corresponding weight.
   */
  @JsonProperty("preference")
  public abstract io.fabric8.kubernetes.types.api.v1.NodeSelectorTerm getPreference();

}
