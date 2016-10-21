package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ContainerStateTerminated is a terminated state of a container.
 */
@Value.Immutable
abstract class AbstractContainerStateTerminated {
  /*
   * Exit status from the last termination of the container
   */
  @JsonProperty("exitCode")
  public abstract Integer getExitCode();

  /*
   * Signal from the last termination of the container
   */
  @JsonProperty("signal")
  public abstract Integer getSignal();

  /*
   * (brief) reason from the last termination of the container
   */
  @JsonProperty("reason")
  public abstract String getReason();

  /*
   * Message regarding the last termination of the container
   */
  @JsonProperty("message")
  public abstract String getMessage();

  /*
   * Time at which previous execution of the container started
   */
  @JsonProperty("startedAt")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getStartedAt();

  /*
   * Time at which the container last terminated
   */
  @JsonProperty("finishedAt")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getFinishedAt();

  /*
   * Container's ID in the format 'docker://<container_id>'
   */
  @JsonProperty("containerID")
  public abstract String getContainerID();

}
