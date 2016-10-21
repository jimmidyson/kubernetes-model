package io.fabric8.openshift.types.deploy.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeploymentConfigStatus represents the current deployment state.
 */
@Value.Immutable
abstract class AbstractDeploymentConfigStatus {
  /*
   * LatestVersion is used to determine whether the current deployment associated with a deployment
   * config is out of sync.
   */
  @JsonProperty("latestVersion")
  public abstract Long getLatestVersion();

  /*
   * ObservedGeneration is the most recent generation observed by the deployment config controller.
   */
  @JsonProperty("observedGeneration")
  public abstract Long getObservedGeneration();

  /*
   * Replicas is the total number of pods targeted by this deployment config.
   */
  @JsonProperty("replicas")
  public abstract Integer getReplicas();

  /*
   * UpdatedReplicas is the total number of non-terminated pods targeted by this deployment config
   * that have the desired template spec.
   */
  @JsonProperty("updatedReplicas")
  public abstract Integer getUpdatedReplicas();

  /*
   * AvailableReplicas is the total number of available pods targeted by this deployment config.
   */
  @JsonProperty("availableReplicas")
  public abstract Integer getAvailableReplicas();

  /*
   * UnavailableReplicas is the total number of unavailable pods targeted by this deployment config.
   */
  @JsonProperty("unavailableReplicas")
  public abstract Integer getUnavailableReplicas();

  /*
   * Details are the reasons for the update to this deployment config.
   * This could be based on a change made by the user or caused by an automatic trigger
   */
  @JsonProperty("details")
  public abstract io.fabric8.openshift.types.deploy.v1.DeploymentDetails getDetails();

}
