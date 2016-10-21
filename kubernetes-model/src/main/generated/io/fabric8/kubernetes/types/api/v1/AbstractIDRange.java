package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * IDRange provides a min/max of an allowed range of IDs.
 * TODO: this could be reused for UIDs.
 */
@Value.Immutable
abstract class AbstractIDRange {
  /*
   * Min is the start of the range, inclusive.
   */
  @JsonProperty("min")
  public abstract Long getMin();

  /*
   * Max is the end of the range, inclusive.
   */
  @JsonProperty("max")
  public abstract Long getMax();

}
