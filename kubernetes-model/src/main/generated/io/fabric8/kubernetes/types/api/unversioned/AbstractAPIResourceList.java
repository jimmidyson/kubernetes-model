package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * APIResourceList is a list of APIResource, it is used to expose the name of the
 * resources supported in a specific group and version, and if the resource
 * is namespaced.
 */
@Value.Immutable
abstract class AbstractAPIResourceList {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("APIResourceList", "unversioned");
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
   * groupVersion is the group and version this APIResourceList is for.
   */
  @JsonProperty("groupVersion")
  public abstract String getGroupVersion();

  /*
   * resources contains the name of the resources and if they are namespaced.
   */
  @JsonProperty("resources")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.unversioned.APIResource> getResources();

}
