package io.fabric8.openshift.types.route.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Route encapsulates the inputs needed to connect an alias to endpoints.
 */
@Value.Immutable
abstract class AbstractRoute implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("Route", "v1");
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
   * Standard object's metadata.
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Spec is the desired state of the route
   */
  @JsonProperty("spec")
  public abstract io.fabric8.openshift.types.route.v1.RouteSpec getSpec();

  /*
   * Status is the current state of the route
   */
  @JsonProperty("status")
  public abstract io.fabric8.openshift.types.route.v1.RouteStatus getStatus();

}
