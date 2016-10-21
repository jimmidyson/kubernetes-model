package io.fabric8.openshift.types.deploy.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeploymentStrategy describes how to perform a deployment.
 */
@Value.Immutable
abstract class AbstractDeploymentStrategy {
  /*
   * Type is the name of a deployment strategy.
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * CustomParams are the input to the Custom deployment strategy.
   */
  @JsonProperty("customParams")
  public abstract io.fabric8.openshift.types.deploy.v1.CustomDeploymentStrategyParams getCustomParams();

  /*
   * RecreateParams are the input to the Recreate deployment strategy.
   */
  @JsonProperty("recreateParams")
  public abstract io.fabric8.openshift.types.deploy.v1.RecreateDeploymentStrategyParams getRecreateParams();

  /*
   * RollingParams are the input to the Rolling deployment strategy.
   */
  @JsonProperty("rollingParams")
  public abstract io.fabric8.openshift.types.deploy.v1.RollingDeploymentStrategyParams getRollingParams();

  /*
   * Resources contains resource requirements to execute the deployment and any hooks
   */
  @JsonProperty("resources")
  public abstract io.fabric8.kubernetes.types.api.v1.ResourceRequirements getResources();

  /*
   * Labels is a set of key, value pairs added to custom deployer and lifecycle pre/post hook pods.
   */
  @JsonProperty("labels")
  public abstract java.util.Map<String, String> getLabels();

  /*
   * Annotations is a set of key, value pairs added to custom deployer and lifecycle pre/post hook pods.
   */
  @JsonProperty("annotations")
  public abstract java.util.Map<String, String> getAnnotations();

}
