package io.fabric8.openshift.types.deploy.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeploymentTriggerImageChangeParams represents the parameters to the ImageChange trigger.
 */
@Value.Immutable
abstract class AbstractDeploymentTriggerImageChangeParams {
  /*
   * Automatic means that the detection of a new tag value should result in an image update
   * inside the pod template. Deployment configs that haven't been deployed yet will always
   * have their images updated. Deployment configs that have been deployed at least once, will
   * have their images updated only if this is set to true.
   */
  @JsonProperty("automatic")
  public abstract Boolean isAutomatic();

  /*
   * ContainerNames is used to restrict tag updates to the specified set of container names in a pod.
   */
  @JsonProperty("containerNames")
  public abstract java.util.List<String> getContainerNames();

  /*
   * From is a reference to an image stream tag to watch for changes. From.Name is the only
   * required subfield - if From.Namespace is blank, the namespace of the current deployment
   * trigger will be used.
   */
  @JsonProperty("from")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getFrom();

  /*
   * LastTriggeredImage is the last image to be triggered.
   */
  @JsonProperty("lastTriggeredImage")
  public abstract String getLastTriggeredImage();

}
