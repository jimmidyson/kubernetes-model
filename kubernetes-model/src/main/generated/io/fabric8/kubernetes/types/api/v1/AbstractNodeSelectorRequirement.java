package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * A node selector requirement is a selector that contains values, a key, and an operator
 * that relates the key and values.
 */
@Value.Immutable
abstract class AbstractNodeSelectorRequirement {
  /*
   * The label key that the selector applies to.
   */
  @JsonProperty("key")
  public abstract String getKey();

  /*
   * Represents a key's relationship to a set of values.
   * Valid operators are In, NotIn, Exists, DoesNotExist. Gt, and Lt.
   */
  @JsonProperty("operator")
  public abstract String getOperator();

  /*
   * An array of string values. If the operator is In or NotIn,
   * the values array must be non-empty. If the operator is Exists or DoesNotExist,
   * the values array must be empty. If the operator is Gt or Lt, the values
   * array must have a single element, which will be interpreted as an integer.
   * This array is replaced during a strategic merge patch.
   */
  @JsonProperty("values")
  public abstract java.util.List<String> getValues();

}
