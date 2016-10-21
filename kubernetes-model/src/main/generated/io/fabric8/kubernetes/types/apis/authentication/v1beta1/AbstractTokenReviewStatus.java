package io.fabric8.kubernetes.types.apis.authentication.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * TokenReviewStatus is the result of the token authentication request.
 */
@Value.Immutable
abstract class AbstractTokenReviewStatus {
  /*
   * Authenticated indicates that the token was associated with a known user.
   */
  @JsonProperty("authenticated")
  public abstract Boolean isAuthenticated();

  /*
   * User is the UserInfo associated with the provided token.
   */
  @JsonProperty("user")
  public abstract io.fabric8.kubernetes.types.apis.authentication.v1beta1.UserInfo getUser();

  /*
   * Error indicates that the token couldn't be checked
   */
  @JsonProperty("error")
  public abstract String getError();

}
