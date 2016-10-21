package io.fabric8.openshift.types.deploy.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeploymentTriggerPolicy describes a policy for a single trigger that results in a new deployment.
 */
@Value.Immutable
abstract class AbstractDeploymentTriggerPolicy {
  /*
   * Type of the trigger
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * ImageChangeParams represents the parameters for the ImageChange trigger.
   */
  @JsonProperty("imageChangeParams")
  public abstract io.fabric8.openshift.types.deploy.v1.DeploymentTriggerImageChangeParams getImageChangeParams();

}
