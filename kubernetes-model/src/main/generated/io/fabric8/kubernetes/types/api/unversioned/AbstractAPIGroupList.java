package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * APIGroupList is a list of APIGroup, to allow clients to discover the API at
 * /apis.
 */
@Value.Immutable
abstract class AbstractAPIGroupList {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("APIGroupList", "unversioned");
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
   * groups is a list of APIGroup.
   */
  @JsonProperty("groups")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.unversioned.APIGroup> getGroups();

}
