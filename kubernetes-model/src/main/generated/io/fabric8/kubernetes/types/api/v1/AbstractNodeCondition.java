package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * NodeCondition contains condition infromation for a node.
 */
@Value.Immutable
abstract class AbstractNodeCondition {
  /*
   * Type of node condition.
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * Status of the condition, one of True, False, Unknown.
   */
  @JsonProperty("status")
  public abstract String getStatus();

  /*
   * Last time we got an update on a given condition.
   */
  @JsonProperty("lastHeartbeatTime")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getLastHeartbeatTime();

  /*
   * Last time the condition transit from one status to another.
   */
  @JsonProperty("lastTransitionTime")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getLastTransitionTime();

  /*
   * (brief) reason for the condition's last transition.
   */
  @JsonProperty("reason")
  public abstract String getReason();

  /*
   * Human readable message indicating details about last transition.
   */
  @JsonProperty("message")
  public abstract String getMessage();

}
