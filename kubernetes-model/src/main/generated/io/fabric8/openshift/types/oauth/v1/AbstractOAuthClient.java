package io.fabric8.openshift.types.oauth.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * OAuthClient describes an OAuth client
 */
@Value.Immutable
abstract class AbstractOAuthClient implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("OAuthClient", "v1");
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
   * Secret is the unique secret associated with a client
   */
  @JsonProperty("secret")
  public abstract String getSecret();

  /*
   * AdditionalSecrets holds other secrets that may be used to identify the client.  This is useful for rotation
   * and for service account token validation
   */
  @JsonProperty("additionalSecrets")
  public abstract java.util.List<String> getAdditionalSecrets();

  /*
   * RespondWithChallenges indicates whether the client wants authentication needed responses made in the form of challenges instead of redirects
   */
  @JsonProperty("respondWithChallenges")
  public abstract Boolean isRespondWithChallenges();

  /*
   * RedirectURIs is the valid redirection URIs associated with a client
   */
  @JsonProperty("redirectURIs")
  public abstract java.util.List<String> getRedirectURIs();

  /*
   * GrantMethod determines how to handle grants for this client. If no method is provided, the
   * cluster default grant handling method will be used. Valid grant handling methods are:
   *  - auto:   always approves grant requests, useful for trusted clients
   *  - prompt: prompts the end user for approval of grant requests, useful for third-party clients
   *  - deny:   always denies grant requests, useful for black-listed clients
   */
  @JsonProperty("grantMethod")
  public abstract String getGrantMethod();

  /*
   * ScopeRestrictions describes which scopes this client can request.  Each requested scope
   * is checked against each restriction.  If any restriction matches, then the scope is allowed.
   * If no restriction matches, then the scope is denied.
   */
  @JsonProperty("scopeRestrictions")
  public abstract java.util.List<io.fabric8.openshift.types.oauth.v1.ScopeRestriction> getScopeRestrictions();

}
