package io.fabric8.openshift.types.security.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PodSecurityPolicyReview checks which service accounts (not users, since that would be cluster-wide) can create the `PodTemplateSpec` in question.
 */
@Value.Immutable
abstract class AbstractPodSecurityPolicyReview {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("PodSecurityPolicyReview", "v1");
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
   * spec is the PodSecurityPolicy to check.
   */
  @JsonProperty("spec")
  public abstract io.fabric8.openshift.types.security.v1.PodSecurityPolicyReviewSpec getSpec();

  /*
   * status represents the current information/status for the PodSecurityPolicyReview.
   */
  @JsonProperty("status")
  public abstract io.fabric8.openshift.types.security.v1.PodSecurityPolicyReviewStatus getStatus();

}
