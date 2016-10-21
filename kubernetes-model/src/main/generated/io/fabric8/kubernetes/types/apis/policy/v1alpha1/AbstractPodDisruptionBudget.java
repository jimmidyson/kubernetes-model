package io.fabric8.kubernetes.types.apis.policy.v1alpha1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PodDisruptionBudget is an object to define the max disruption that can be caused to a collection of pods
 */
@Value.Immutable
abstract class AbstractPodDisruptionBudget implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("PodDisruptionBudget", "policy/v1alpha1");
  }

  @Value.Derived
  public String getApiVersion() {
    return getTypeMeta().getApiVersion();
  }

  @Value.Derived
  public String getKind() {
    return getTypeMeta().getKind();
  }


  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Specification of the desired behavior of the PodDisruptionBudget.
   */
  @JsonProperty("spec")
  public abstract io.fabric8.kubernetes.types.apis.policy.v1alpha1.PodDisruptionBudgetSpec getSpec();

  /*
   * Most recently observed status of the PodDisruptionBudget.
   */
  @JsonProperty("status")
  public abstract io.fabric8.kubernetes.types.apis.policy.v1alpha1.PodDisruptionBudgetStatus getStatus();

}
