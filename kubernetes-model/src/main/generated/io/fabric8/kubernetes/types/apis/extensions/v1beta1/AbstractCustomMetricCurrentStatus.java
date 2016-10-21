package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;


@Value.Immutable
abstract class AbstractCustomMetricCurrentStatus {
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
