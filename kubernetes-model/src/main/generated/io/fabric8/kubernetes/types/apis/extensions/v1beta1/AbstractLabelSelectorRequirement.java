package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * A label selector requirement is a selector that contains values, a key, and an operator that
 * relates the key and values.
 */
@Value.Immutable
abstract class AbstractLabelSelectorRequirement {
  /*
   * key is the label key that the selector applies to.
   */
  @JsonProperty("key")
  public abstract String getKey();

  /*
   * operator represents a key's relationship to a set of values.
   * Valid operators ard In, NotIn, Exists and DoesNotExist.
   */
  @JsonProperty("operator")
  public abstract String getOperator();

  /*
   * values is an array of string values. If the operator is In or NotIn,
   * the values array must be non-empty. If the operator is Exists or DoesNotExist,
   * the values array must be empty. This array is replaced during a strategic
   * merge patch.
   */
  @JsonProperty("values")
  public abstract java.util.List<String> getValues();

}
