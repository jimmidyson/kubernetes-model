package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ContainerStatus contains details for the current status of this container.
 */
@Value.Immutable
abstract class AbstractContainerStatus {
  /*
   * This must be a DNS_LABEL. Each container in a pod must have a unique name.
   * Cannot be updated.
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * Details about the container's current condition.
   */
  @JsonProperty("state")
  public abstract io.fabric8.kubernetes.types.api.v1.ContainerState getState();

  /*
   * Details about the container's last termination condition.
   */
  @JsonProperty("lastState")
  public abstract io.fabric8.kubernetes.types.api.v1.ContainerState getLastState();

  /*
   * Specifies whether the container has passed its readiness probe.
   */
  @JsonProperty("ready")
  public abstract Boolean isReady();

  /*
   * The number of times the container has been restarted, currently based on
   * the number of dead containers that have not yet been removed.
   * Note that this is calculated from dead containers. But those containers are subject to
   * garbage collection. This value will get capped at 5 by GC.
   */
  @JsonProperty("restartCount")
  public abstract Integer getRestartCount();

  /*
   * The image the container is running.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/images.md
   * TODO(dchen1107): Which image the container is running with?
   */
  @JsonProperty("image")
  public abstract String getImage();

  /*
   * ImageID of the container's image.
   */
  @JsonProperty("imageID")
  public abstract String getImageID();

  /*
   * Container's ID in the format 'docker://<container_id>'.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/container-environment.md#container-information
   */
  @JsonProperty("containerID")
  public abstract String getContainerID();

}
