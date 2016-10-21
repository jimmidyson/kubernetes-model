package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * The weights of all of the matched WeightedPodAffinityTerm fields are added per-node to find the most preferred node(s)
 */
@Value.Immutable
abstract class AbstractWeightedPodAffinityTerm {
  /*
   * weight associated with matching the corresponding podAffinityTerm,
   * in the range 1-100.
   */
  @JsonProperty("weight")
  public abstract Integer getWeight();

  /*
   * Required. A pod affinity term, associated with the corresponding weight.
   */
  @JsonProperty("podAffinityTerm")
  public abstract io.fabric8.kubernetes.types.api.v1.PodAffinityTerm getPodAffinityTerm();

}
