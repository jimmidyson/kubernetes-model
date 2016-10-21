package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;


@Value.Immutable
abstract class AbstractCustomMetricCurrentStatusList {

  @JsonProperty("items")
  public abstract java.util.List<io.fabric8.kubernetes.types.apis.extensions.v1beta1.CustomMetricCurrentStatus> getItems();

}
