package io.fabric8.openshift.types.oauth.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * OAuthClientAuthorizationList is a collection of OAuth client authorizations
 */
@Value.Immutable
abstract class AbstractOAuthClientAuthorizationList {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("OAuthClientAuthorizationList", "v1");
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
  public abstract io.fabric8.kubernetes.types.api.unversioned.ListMeta getMetadata();

  /*
   * Items is the list of OAuth client authorizations
   */
  @JsonProperty("items")
  public abstract java.util.List<io.fabric8.openshift.types.oauth.v1.OAuthClientAuthorization> getItems();

}
