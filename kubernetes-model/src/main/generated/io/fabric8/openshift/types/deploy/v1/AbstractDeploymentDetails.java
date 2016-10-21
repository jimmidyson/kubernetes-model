package io.fabric8.openshift.types.deploy.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeploymentDetails captures information about the causes of a deployment.
 */
@Value.Immutable
abstract class AbstractDeploymentDetails {
  /*
   * Message is the user specified change message, if this deployment was triggered manually by the user
   */
  @JsonProperty("message")
  public abstract String getMessage();

  /*
   * Causes are extended data associated with all the causes for creating a new deployment
   */
  @JsonProperty("causes")
  public abstract java.util.List<io.fabric8.openshift.types.deploy.v1.DeploymentCause> getCauses();

}
