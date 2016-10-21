package io.fabric8.kubernetes.types.apis.authentication.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * TokenReviewSpec is a description of the token authentication request.
 */
@Value.Immutable
abstract class AbstractTokenReviewSpec {
  /*
   * Token is the opaque bearer token.
   */
  @JsonProperty("token")
  public abstract String getToken();

}
