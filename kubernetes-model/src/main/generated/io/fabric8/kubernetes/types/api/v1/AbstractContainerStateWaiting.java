package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ContainerStateWaiting is a waiting state of a container.
 */
@Value.Immutable
abstract class AbstractContainerStateWaiting {
  /*
   * (brief) reason the container is not yet running.
   */
  @JsonProperty("reason")
  public abstract String getReason();

  /*
   * Message regarding why the container is not yet running.
   */
  @JsonProperty("message")
  public abstract String getMessage();

}
