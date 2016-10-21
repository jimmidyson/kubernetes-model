package io.fabric8.openshift.types.security.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PodSecurityPolicySelfSubjectReview checks whether this user/SA tuple can create the PodTemplateSpec
 */
@Value.Immutable
abstract class AbstractPodSecurityPolicySelfSubjectReview {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("PodSecurityPolicySelfSubjectReview", "v1");
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
   * spec defines specification the PodSecurityPolicySelfSubjectReview.
   */
  @JsonProperty("spec")
  public abstract io.fabric8.openshift.types.security.v1.PodSecurityPolicySelfSubjectReviewSpec getSpec();

  /*
   * status represents the current information/status for the PodSecurityPolicySelfSubjectReview.
   */
  @JsonProperty("status")
  public abstract io.fabric8.openshift.types.security.v1.PodSecurityPolicySubjectReviewStatus getStatus();

}
