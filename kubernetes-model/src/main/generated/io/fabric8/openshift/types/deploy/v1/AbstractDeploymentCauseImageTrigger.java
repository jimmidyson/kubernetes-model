package io.fabric8.openshift.types.deploy.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeploymentCauseImageTrigger represents details about the cause of a deployment originating
 * from an image change trigger
 */
@Value.Immutable
abstract class AbstractDeploymentCauseImageTrigger {
  /*
   * From is a reference to the changed object which triggered a deployment. The field may have
   * the kinds DockerImage, ImageStreamTag, or ImageStreamImage.
   */
  @JsonProperty("from")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getFrom();

}
