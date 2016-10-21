package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Alpha-level support for Custom Metrics in HPA (as annotations).
 */
@Value.Immutable
abstract class AbstractCustomMetricTarget {
  /*
   * Custom Metric name.
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * Custom Metric value (average).
   */
  @JsonProperty("value")
  public abstract io.fabric8.kubernetes.types.api.resource.Quantity getValue();

}
