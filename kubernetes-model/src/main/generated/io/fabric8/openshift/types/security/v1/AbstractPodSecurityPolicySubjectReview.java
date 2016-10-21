package io.fabric8.openshift.types.security.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PodSecurityPolicySubjectReview checks whether a particular user/SA tuple can create the PodTemplateSpec.
 */
@Value.Immutable
abstract class AbstractPodSecurityPolicySubjectReview {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("PodSecurityPolicySubjectReview", "v1");
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
   * spec defines specification for the PodSecurityPolicySubjectReview.
   */
  @JsonProperty("spec")
  public abstract io.fabric8.openshift.types.security.v1.PodSecurityPolicySubjectReviewSpec getSpec();

  /*
   * status represents the current information/status for the PodSecurityPolicySubjectReview.
   */
  @JsonProperty("status")
  public abstract io.fabric8.openshift.types.security.v1.PodSecurityPolicySubjectReviewStatus getStatus();

}
