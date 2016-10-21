package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PodCondition contains details for the current condition of this pod.
 */
@Value.Immutable
abstract class AbstractPodCondition {
  /*
   * Type is the type of the condition.
   * Currently only Ready.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/pod-states.md#pod-conditions
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * Status is the status of the condition.
   * Can be True, False, Unknown.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/pod-states.md#pod-conditions
   */
  @JsonProperty("status")
  public abstract String getStatus();

  /*
   * Last time we probed the condition.
   */
  @JsonProperty("lastProbeTime")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getLastProbeTime();

  /*
   * Last time the condition transitioned from one status to another.
   */
  @JsonProperty("lastTransitionTime")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getLastTransitionTime();

  /*
   * Unique, one-word, CamelCase reason for the condition's last transition.
   */
  @JsonProperty("reason")
  public abstract String getReason();

  /*
   * Human-readable message indicating details about last transition.
   */
  @JsonProperty("message")
  public abstract String getMessage();

}
