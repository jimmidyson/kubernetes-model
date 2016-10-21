package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * EndpointsList is a list of endpoints.
 */
@Value.Immutable
abstract class AbstractEndpointsList {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("EndpointsList", "v1");
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
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#types-kinds
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.unversioned.ListMeta getMetadata();

  /*
   * List of endpoints.
   */
  @JsonProperty("items")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.Endpoints> getItems();

}
