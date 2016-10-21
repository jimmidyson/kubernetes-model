package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeploymentStatus is the most recently observed status of the Deployment.
 */
@Value.Immutable
abstract class AbstractDeploymentStatus {
  /*
   * The generation observed by the deployment controller.
   */
  @JsonProperty("observedGeneration")
  public abstract Long getObservedGeneration();

  /*
   * Total number of non-terminated pods targeted by this deployment (their labels match the selector).
   */
  @JsonProperty("replicas")
  public abstract Integer getReplicas();

  /*
   * Total number of non-terminated pods targeted by this deployment that have the desired template spec.
   */
  @JsonProperty("updatedReplicas")
  public abstract Integer getUpdatedReplicas();

  /*
   * Total number of available pods (ready for at least minReadySeconds) targeted by this deployment.
   */
  @JsonProperty("availableReplicas")
  public abstract Integer getAvailableReplicas();

  /*
   * Total number of unavailable pods targeted by this deployment.
   */
  @JsonProperty("unavailableReplicas")
  public abstract Integer getUnavailableReplicas();

}
