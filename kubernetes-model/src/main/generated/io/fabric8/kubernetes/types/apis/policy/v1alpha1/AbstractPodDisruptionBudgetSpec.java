package io.fabric8.kubernetes.types.apis.policy.v1alpha1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PodDisruptionBudgetSpec is a description of a PodDisruptionBudget.
 */
@Value.Immutable
abstract class AbstractPodDisruptionBudgetSpec {
  /*
   * The minimum number of pods that must be available simultaneously.  This
   * can be either an integer or a string specifying a percentage, e.g. "28%".
   */
  @JsonProperty("minAvailable")
  public abstract io.fabric8.kubernetes.types.util.intstr.IntOrString getMinAvailable();

  /*
   * Label query over pods whose evictions are managed by the disruption
   * budget.
   */
  @JsonProperty("selector")
  public abstract io.fabric8.kubernetes.types.api.unversioned.LabelSelector getSelector();

}
