package io.fabric8.openshift.types.security.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PodSecurityPolicySubjectReviewSpec defines specification for PodSecurityPolicySubjectReview
 */
@Value.Immutable
abstract class AbstractPodSecurityPolicySubjectReviewSpec {
  /*
   * template is the PodTemplateSpec to check. If template.spec.serviceAccountName is empty it will not be defaulted.
   * If its non-empty, it will be checked.
   */
  @JsonProperty("template")
  public abstract io.fabric8.kubernetes.types.api.v1.PodTemplateSpec getTemplate();

  /*
   * user is the user you're testing for.
   * If you specify "user" but not "group", then is it interpreted as "What if user were not a member of any groups.
   * If user and groups are empty, then the check is performed using *only* the serviceAccountName in the template.
   */
  @JsonProperty("user")
  public abstract String getUser();

  /*
   * groups is the groups you're testing for.
   */
  @JsonProperty("groups")
  public abstract java.util.List<String> getGroups();

}
