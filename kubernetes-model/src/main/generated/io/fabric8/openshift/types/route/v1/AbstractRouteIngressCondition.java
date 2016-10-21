package io.fabric8.openshift.types.route.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * RouteIngressCondition contains details for the current condition of this pod.
 * TODO: add LastTransitionTime, Reason, Message to match NodeCondition api.
 */
@Value.Immutable
abstract class AbstractRouteIngressCondition {
  /*
   * Type is the type of the condition.
   * Currently only Ready.
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * Status is the status of the condition.
   * Can be True, False, Unknown.
   */
  @JsonProperty("status")
  public abstract String getStatus();

  /*
   * (brief) reason for the condition's last transition, and is usually a machine and human
   * readable constant
   */
  @JsonProperty("reason")
  public abstract String getReason();

  /*
   * Human readable message indicating details about last transition.
   */
  @JsonProperty("message")
  public abstract String getMessage();

  /*
   * RFC 3339 date and time when this condition last transitioned
   */
  @JsonProperty("lastTransitionTime")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getLastTransitionTime();

}
