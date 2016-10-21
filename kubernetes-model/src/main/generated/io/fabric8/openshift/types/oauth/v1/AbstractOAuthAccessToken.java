package io.fabric8.openshift.types.oauth.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * OAuthAccessToken describes an OAuth access token
 */
@Value.Immutable
abstract class AbstractOAuthAccessToken implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("OAuthAccessToken", "v1");
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
   * ClientName references the client that created this token.
   */
  @JsonProperty("clientName")
  public abstract String getClientName();

  /*
   * ExpiresIn is the seconds from CreationTime before this token expires.
   */
  @JsonProperty("expiresIn")
  public abstract Long getExpiresIn();

  /*
   * Scopes is an array of the requested scopes.
   */
  @JsonProperty("scopes")
  public abstract java.util.List<String> getScopes();

  /*
   * RedirectURI is the redirection associated with the token.
   */
  @JsonProperty("redirectURI")
  public abstract String getRedirectURI();

  /*
   * UserName is the user name associated with this token
   */
  @JsonProperty("userName")
  public abstract String getUserName();

  /*
   * UserUID is the unique UID associated with this token
   */
  @JsonProperty("userUID")
  public abstract String getUserUID();

  /*
   * AuthorizeToken contains the token that authorized this token
   */
  @JsonProperty("authorizeToken")
  public abstract String getAuthorizeToken();

  /*
   * RefreshToken is the value by which this token can be renewed. Can be blank.
   */
  @JsonProperty("refreshToken")
  public abstract String getRefreshToken();

}
