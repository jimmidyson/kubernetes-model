package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Information about the condition of a component.
 */
@Value.Immutable
abstract class AbstractComponentCondition {
  /*
   * Type of condition for a component.
   * Valid value: "Healthy"
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * Status of the condition for a component.
   * Valid values for "Healthy": "True", "False", or "Unknown".
   */
  @JsonProperty("status")
  public abstract String getStatus();

  /*
   * Message about the condition for a component.
   * For example, information about a health check.
   */
  @JsonProperty("message")
  public abstract String getMessage();

  /*
   * Condition error code for a component.
   * For example, a health check error code.
   */
  @JsonProperty("error")
  public abstract String getError();

}
