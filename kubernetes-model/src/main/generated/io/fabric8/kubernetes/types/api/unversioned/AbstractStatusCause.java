package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * StatusCause provides more information about an api.Status failure, including
 * cases when multiple errors are encountered.
 */
@Value.Immutable
abstract class AbstractStatusCause {
  /*
   * A machine-readable description of the cause of the error. If this value is
   * empty there is no information available.
   */
  @JsonProperty("reason")
  public abstract String getReason();

  /*
   * A human-readable description of the cause of the error.  This field may be
   * presented as-is to a reader.
   */
  @JsonProperty("message")
  public abstract String getMessage();

  /*
   * The field of the resource that has caused this error, as named by its JSON
   * serialization. May include dot and postfix notation for nested attributes.
   * Arrays are zero-indexed.  Fields may appear more than once in an array of
   * causes due to fields having multiple errors.
   * Optional.
   * 
   * Examples:
   *   "name" - the field "name" on the current resource
   *   "items[0].name" - the field "name" on the first array entry in "items"
   */
  @JsonProperty("field")
  public abstract String getField();

}
