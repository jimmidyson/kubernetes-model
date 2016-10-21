package io.fabric8.openshift.types.deploy.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * TagImageHook is a request to tag the image in a particular container onto an ImageStreamTag.
 */
@Value.Immutable
abstract class AbstractTagImageHook {
  /*
   * ContainerName is the name of a container in the deployment config whose image value will be used as the source of the tag. If there is only a single
   * container this value will be defaulted to the name of that container.
   */
  @JsonProperty("containerName")
  public abstract String getContainerName();

  /*
   * To is the target ImageStreamTag to set the container's image onto.
   */
  @JsonProperty("to")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getTo();

}
