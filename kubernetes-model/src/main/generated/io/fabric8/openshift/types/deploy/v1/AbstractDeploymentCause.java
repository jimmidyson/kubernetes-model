package io.fabric8.openshift.types.deploy.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeploymentCause captures information about a particular cause of a deployment.
 */
@Value.Immutable
abstract class AbstractDeploymentCause {
  /*
   * Type of the trigger that resulted in the creation of a new deployment
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * ImageTrigger contains the image trigger details, if this trigger was fired based on an image change
   */
  @JsonProperty("imageTrigger")
  public abstract io.fabric8.openshift.types.deploy.v1.DeploymentCauseImageTrigger getImageTrigger();

}
