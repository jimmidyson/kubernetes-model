package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * list of horizontal pod autoscaler objects.
 */
@Value.Immutable
abstract class AbstractHorizontalPodAutoscalerList {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("HorizontalPodAutoscalerList", "extensions/v1beta1");
  }

  @Value.Derived
  public String getApiVersion() {
    return getTypeMeta().getApiVersion();
  }

  @Value.Derived
  public String getKind() {
    return getTypeMeta().getKind();
  }

  /*
   * Standard list metadata.
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.unversioned.ListMeta getMetadata();

  /*
   * list of horizontal pod autoscaler objects.
   */
  @JsonProperty("items")
  public abstract java.util.List<io.fabric8.kubernetes.types.apis.extensions.v1beta1.HorizontalPodAutoscaler> getItems();

}
