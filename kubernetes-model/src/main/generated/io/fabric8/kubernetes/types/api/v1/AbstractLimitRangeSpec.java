package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * LimitRangeSpec defines a min/max usage limit for resources that match on kind.
 */
@Value.Immutable
abstract class AbstractLimitRangeSpec {
  /*
   * Limits is the list of LimitRangeItem objects that are enforced.
   */
  @JsonProperty("limits")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.LimitRangeItem> getLimits();

}
