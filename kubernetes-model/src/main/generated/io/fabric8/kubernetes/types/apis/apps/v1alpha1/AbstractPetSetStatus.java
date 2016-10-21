package io.fabric8.kubernetes.types.apis.apps.v1alpha1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PetSetStatus represents the current state of a PetSet.
 */
@Value.Immutable
abstract class AbstractPetSetStatus {
  /*
   * most recent generation observed by this autoscaler.
   */
  @JsonProperty("observedGeneration")
  public abstract Long getObservedGeneration();

  /*
   * Replicas is the number of actual replicas.
   */
  @JsonProperty("replicas")
  public abstract Integer getReplicas();

}
