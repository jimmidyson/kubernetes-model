package io.fabric8.openshift.types.security.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ServiceAccountPodSecurityPolicyReviewStatus represents ServiceAccount name and related review status
 */
@Value.Immutable
abstract class AbstractServiceAccountPodSecurityPolicyReviewStatus {

  @JsonUnwrapped
  public abstract io.fabric8.openshift.types.security.v1.PodSecurityPolicySubjectReviewStatus getPodSecurityPolicySubjectReviewStatus();

  /*
   * name contains the allowed and the denied ServiceAccount name
   */
  @JsonProperty("name")
  public abstract String getName();

}
