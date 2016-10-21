package io.fabric8.openshift.types.deploy.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeploymentConfigSpec represents the desired state of the deployment.
 */
@Value.Immutable
abstract class AbstractDeploymentConfigSpec {
  /*
   * Strategy describes how a deployment is executed.
   */
  @JsonProperty("strategy")
  public abstract io.fabric8.openshift.types.deploy.v1.DeploymentStrategy getStrategy();

  /*
   * MinReadySeconds is the minimum number of seconds for which a newly created pod should
   * be ready without any of its container crashing, for it to be considered available.
   * Defaults to 0 (pod will be considered available as soon as it is ready)
   */
  @JsonProperty("minReadySeconds")
  public abstract Integer getMinReadySeconds();

  /*
   * Triggers determine how updates to a DeploymentConfig result in new deployments. If no triggers
   * are defined, a new deployment can only occur as a result of an explicit client update to the
   * DeploymentConfig with a new LatestVersion. If null, defaults to having a config change trigger.
   */
  @JsonProperty("triggers")
  public abstract java.util.List<io.fabric8.openshift.types.deploy.v1.DeploymentTriggerPolicy> getTriggers();

  /*
   * Replicas is the number of desired replicas.
   */
  @JsonProperty("replicas")
  public abstract Integer getReplicas();

  /*
   * RevisionHistoryLimit is the number of old ReplicationControllers to retain to allow for rollbacks.
   * This field is a pointer to allow for differentiation between an explicit zero and not specified.
   */
  @JsonProperty("revisionHistoryLimit")
  public abstract Integer getRevisionHistoryLimit();

  /*
   * Test ensures that this deployment config will have zero replicas except while a deployment is running. This allows the
   * deployment config to be used as a continuous deployment test - triggering on images, running the deployment, and then succeeding
   * or failing. Post strategy hooks and After actions can be used to integrate successful deployment with an action.
   */
  @JsonProperty("test")
  public abstract Boolean isTest();

  /*
   * Paused indicates that the deployment config is paused resulting in no new deployments on template
   * changes or changes in the template caused by other triggers.
   */
  @JsonProperty("paused")
  public abstract Boolean isPaused();

  /*
   * Selector is a label query over pods that should match the Replicas count.
   */
  @JsonProperty("selector")
  public abstract java.util.Map<String, String> getSelector();

  /*
   * Template is the object that describes the pod that will be created if
   * insufficient replicas are detected.
   */
  @JsonProperty("template")
  public abstract io.fabric8.kubernetes.types.api.v1.PodTemplateSpec getTemplate();

}
