package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * LimitRangeItem defines a min/max usage limit for any resource that matches on kind.
 */
@Value.Immutable
abstract class AbstractLimitRangeItem {
  /*
   * Type of resource that this limit applies to.
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * Max usage constraints on this kind by resource name.
   */
  @JsonProperty("max")
  public abstract java.util.Map<String, io.fabric8.kubernetes.types.api.resource.Quantity> getMax();

  /*
   * Min usage constraints on this kind by resource name.
   */
  @JsonProperty("min")
  public abstract java.util.Map<String, io.fabric8.kubernetes.types.api.resource.Quantity> getMin();

  /*
   * Default resource requirement limit value by resource name if resource limit is omitted.
   */
  @JsonProperty("default")
  public abstract java.util.Map<String, io.fabric8.kubernetes.types.api.resource.Quantity> getDefault();

  /*
   * DefaultRequest is the default resource requirement request value by resource name if resource request is omitted.
   */
  @JsonProperty("defaultRequest")
  public abstract java.util.Map<String, io.fabric8.kubernetes.types.api.resource.Quantity> getDefaultRequest();

  /*
   * MaxLimitRequestRatio if specified, the named resource must have a request and limit that are both non-zero where limit divided by request is less than or equal to the enumerated value; this represents the max burst for the named resource.
   */
  @JsonProperty("maxLimitRequestRatio")
  public abstract java.util.Map<String, io.fabric8.kubernetes.types.api.resource.Quantity> getMaxLimitRequestRatio();

}
