package io.fabric8.kubernetes.types.apis.policy.v1alpha1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PodDisruptionBudgetStatus represents information about the status of a
 * PodDisruptionBudget. Status may trail the actual state of a system.
 */
@Value.Immutable
abstract class AbstractPodDisruptionBudgetStatus {
  /*
   * Whether or not a disruption is currently allowed.
   */
  @JsonProperty("disruptionAllowed")
  public abstract Boolean isDisruptionAllowed();

  /*
   * current number of healthy pods
   */
  @JsonProperty("currentHealthy")
  public abstract Integer getCurrentHealthy();

  /*
   * minimum desired number of healthy pods
   */
  @JsonProperty("desiredHealthy")
  public abstract Integer getDesiredHealthy();

  /*
   * total number of pods counted by this disruption budget
   */
  @JsonProperty("expectedPods")
  public abstract Integer getExpectedPods();

}
