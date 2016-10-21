package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ContainerState holds a possible state of container.
 * Only one of its members may be specified.
 * If none of them is specified, the default one is ContainerStateWaiting.
 */
@Value.Immutable
abstract class AbstractContainerState {
  /*
   * Details about a waiting container
   */
  @JsonProperty("waiting")
  public abstract io.fabric8.kubernetes.types.api.v1.ContainerStateWaiting getWaiting();

  /*
   * Details about a running container
   */
  @JsonProperty("running")
  public abstract io.fabric8.kubernetes.types.api.v1.ContainerStateRunning getRunning();

  /*
   * Details about a terminated container
   */
  @JsonProperty("terminated")
  public abstract io.fabric8.kubernetes.types.api.v1.ContainerStateTerminated getTerminated();

}
