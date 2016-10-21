package io.fabric8.openshift.types.security.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PodSecurityPolicySubjectReviewStatus contains information/status for PodSecurityPolicySubjectReview.
 */
@Value.Immutable
abstract class AbstractPodSecurityPolicySubjectReviewStatus {
  /*
   * allowedBy is a reference to the rule that allows the PodTemplateSpec.
   * A rule can be a SecurityContextConstraint or a PodSecurityPolicy
   * A `nil`, indicates that it was denied.
   */
  @JsonProperty("allowedBy")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getAllowedBy();

  /*
   * A machine-readable description of why this operation is in the
   * "Failure" status. If this value is empty there
   * is no information available.
   */
  @JsonProperty("reason")
  public abstract String getReason();

  /*
   * template is the PodTemplateSpec after the defaulting is applied.
   */
  @JsonProperty("template")
  public abstract io.fabric8.kubernetes.types.api.v1.PodTemplateSpec getTemplate();

}
