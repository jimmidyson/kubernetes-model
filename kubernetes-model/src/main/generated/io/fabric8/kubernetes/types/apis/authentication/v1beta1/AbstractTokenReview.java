package io.fabric8.kubernetes.types.apis.authentication.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * TokenReview attempts to authenticate a token to a known user.
 * Note: TokenReview requests may be cached by the webhook token authenticator
 * plugin in the kube-apiserver.
 */
@Value.Immutable
abstract class AbstractTokenReview implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("TokenReview", "authentication/v1beta1");
  }

  @Value.Derived
  public String getApiVersion() {
    return getTypeMeta().getApiVersion();
  }

  @Value.Derived
  public String getKind() {
    return getTypeMeta().getKind();
  }


  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Spec holds information about the request being evaluated
   */
  @JsonProperty("spec")
  public abstract io.fabric8.kubernetes.types.apis.authentication.v1beta1.TokenReviewSpec getSpec();

  /*
   * Status is filled in by the server and indicates whether the request can be authenticated.
   */
  @JsonProperty("status")
  public abstract io.fabric8.kubernetes.types.apis.authentication.v1beta1.TokenReviewStatus getStatus();

}
