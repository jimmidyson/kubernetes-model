package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SignatureCondition describes an image signature condition of particular kind at particular probe time.
 */
@Value.Immutable
abstract class AbstractSignatureCondition {
  /*
   * Type of signature condition, Complete or Failed.
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * Status of the condition, one of True, False, Unknown.
   */
  @JsonProperty("status")
  public abstract String getStatus();

  /*
   * Last time the condition was checked.
   */
  @JsonProperty("lastProbeTime")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getLastProbeTime();

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
