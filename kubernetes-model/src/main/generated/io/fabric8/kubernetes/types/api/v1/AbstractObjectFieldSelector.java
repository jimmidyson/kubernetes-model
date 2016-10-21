package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ObjectFieldSelector selects an APIVersioned field of an object.
 */
@Value.Immutable
abstract class AbstractObjectFieldSelector {
  /*
   * Version of the schema the FieldPath is written in terms of, defaults to "v1".
   */
  @JsonProperty("apiVersion")
  public abstract String getApiVersion();

  /*
   * Path of the field to select in the specified API version.
   */
  @JsonProperty("fieldPath")
  public abstract String getFieldPath();

}
