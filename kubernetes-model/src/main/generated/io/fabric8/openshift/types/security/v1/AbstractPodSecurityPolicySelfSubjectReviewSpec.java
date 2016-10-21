package io.fabric8.openshift.types.security.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PodSecurityPolicySelfSubjectReviewSpec contains specification for PodSecurityPolicySelfSubjectReview.
 */
@Value.Immutable
abstract class AbstractPodSecurityPolicySelfSubjectReviewSpec {
  /*
   * template is the PodTemplateSpec to check.
   */
  @JsonProperty("template")
  public abstract io.fabric8.kubernetes.types.api.v1.PodTemplateSpec getTemplate();

}
