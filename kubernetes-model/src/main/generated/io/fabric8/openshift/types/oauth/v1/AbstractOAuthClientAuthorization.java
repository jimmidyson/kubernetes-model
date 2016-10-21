package io.fabric8.openshift.types.oauth.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * OAuthClientAuthorization describes an authorization created by an OAuth client
 */
@Value.Immutable
abstract class AbstractOAuthClientAuthorization implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("OAuthClientAuthorization", "v1");
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
   * ClientName references the client that created this authorization
   */
  @JsonProperty("clientName")
  public abstract String getClientName();

  /*
   * UserName is the user name that authorized this client
   */
  @JsonProperty("userName")
  public abstract String getUserName();

  /*
   * UserUID is the unique UID associated with this authorization. UserUID and UserName
   * must both match for this authorization to be valid.
   */
  @JsonProperty("userUID")
  public abstract String getUserUID();

  /*
   * Scopes is an array of the granted scopes.
   */
  @JsonProperty("scopes")
  public abstract java.util.List<String> getScopes();

}
