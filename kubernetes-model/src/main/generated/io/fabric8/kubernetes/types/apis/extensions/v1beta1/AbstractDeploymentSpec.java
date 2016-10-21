package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeploymentSpec is the specification of the desired behavior of the Deployment.
 */
@Value.Immutable
abstract class AbstractDeploymentSpec {
  /*
   * Number of desired pods. This is a pointer to distinguish between explicit
   * zero and not specified. Defaults to 1.
   */
  @JsonProperty("replicas")
  public abstract Integer getReplicas();

  /*
   * Label selector for pods. Existing ReplicaSets whose pods are
   * selected by this will be the ones affected by this deployment.
   */
  @JsonProperty("selector")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.LabelSelector getSelector();

  /*
   * Template describes the pods that will be created.
   */
  @JsonProperty("template")
  public abstract io.fabric8.kubernetes.types.api.v1.PodTemplateSpec getTemplate();

  /*
   * The deployment strategy to use to replace existing pods with new ones.
   */
  @JsonProperty("strategy")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.DeploymentStrategy getStrategy();

  /*
   * Minimum number of seconds for which a newly created pod should be ready
   * without any of its container crashing, for it to be considered available.
   * Defaults to 0 (pod will be considered available as soon as it is ready)
   */
  @JsonProperty("minReadySeconds")
  public abstract Integer getMinReadySeconds();

  /*
   * The number of old ReplicaSets to retain to allow rollback.
   * This is a pointer to distinguish between explicit zero and not specified.
   */
  @JsonProperty("revisionHistoryLimit")
  public abstract Integer getRevisionHistoryLimit();

  /*
   * Indicates that the deployment is paused and will not be processed by the
   * deployment controller.
   */
  @JsonProperty("paused")
  public abstract Boolean isPaused();

  /*
   * The config this deployment is rolling back to. Will be cleared after rollback is done.
   */
  @JsonProperty("rollbackTo")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.RollbackConfig getRollbackTo();

}
