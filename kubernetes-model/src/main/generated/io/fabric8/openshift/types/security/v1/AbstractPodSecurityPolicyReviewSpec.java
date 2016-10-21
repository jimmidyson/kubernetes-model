package io.fabric8.openshift.types.security.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PodSecurityPolicyReviewSpec defines specification for PodSecurityPolicyReview
 */
@Value.Immutable
abstract class AbstractPodSecurityPolicyReviewSpec {
  /*
   * template is the PodTemplateSpec to check. The template.spec.serviceAccountName field is used
   * if serviceAccountNames is empty, unless the template.spec.serviceAccountName is empty,
   * in which case "default" is used.
   * If serviceAccountNames is specified, template.spec.serviceAccountName is ignored.
   */
  @JsonProperty("template")
  public abstract io.fabric8.kubernetes.types.api.v1.PodTemplateSpec getTemplate();

  /*
   * serviceAccountNames is an optional set of ServiceAccounts to run the check with.
   * If serviceAccountNames is empty, the template.spec.serviceAccountName is used,
   * unless it's empty, in which case "default" is used instead.
   * If serviceAccountNames is specified, template.spec.serviceAccountName is ignored.
   */
  @JsonProperty("serviceAccountNames")
  public abstract java.util.List<String> getServiceAccountNames();

}
