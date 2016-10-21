package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Timestamp is a struct that is equivalent to Time, but intended for
 * protobuf marshalling/unmarshalling. It is generated into a serialization
 * that matches Time. Do not use in Go structs.
 */
@Value.Immutable
abstract class AbstractTimestamp {
  /*
   * Represents seconds of UTC time since Unix epoch
   * 1970-01-01T00:00:00Z. Must be from from 0001-01-01T00:00:00Z to
   * 9999-12-31T23:59:59Z inclusive.
   */
  @JsonProperty("seconds")
  public abstract Long getSeconds();

  /*
   * Non-negative fractions of a second at nanosecond resolution. Negative
   * second values with fractions must still have non-negative nanos values
   * that count forward in time. Must be from 0 to 999,999,999
   * inclusive. This field may be limited in precision depending on context.
   */
  @JsonProperty("nanos")
  public abstract Integer getNanos();

}
