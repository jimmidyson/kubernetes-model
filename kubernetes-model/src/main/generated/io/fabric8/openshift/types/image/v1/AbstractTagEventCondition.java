package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * TagEventCondition contains condition information for a tag event.
 */
@Value.Immutable
abstract class AbstractTagEventCondition {
  /*
   * Type of tag event condition, currently only ImportSuccess
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * Status of the condition, one of True, False, Unknown.
   */
  @JsonProperty("status")
  public abstract String getStatus();

  /*
   * LastTransitionTIme is the time the condition transitioned from one status to another.
   */
  @JsonProperty("lastTransitionTime")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getLastTransitionTime();

  /*
   * Reason is a brief machine readable explanation for the condition's last transition.
   */
  @JsonProperty("reason")
  public abstract String getReason();

  /*
   * Message is a human readable description of the details about last transition, complementing reason.
   */
  @JsonProperty("message")
  public abstract String getMessage();

  /*
   * Generation is the spec tag generation that this status corresponds to
   */
  @JsonProperty("generation")
  public abstract Long getGeneration();

}
