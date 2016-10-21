package io.fabric8.openshift.types.security.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PodSecurityPolicyReviewStatus represents the status of PodSecurityPolicyReview.
 */
@Value.Immutable
abstract class AbstractPodSecurityPolicyReviewStatus {
  /*
   * allowedServiceAccounts returns the list of service accounts in *this* namespace that have the power to create the PodTemplateSpec.
   */
  @JsonProperty("allowedServiceAccounts")
  public abstract java.util.List<io.fabric8.openshift.types.security.v1.ServiceAccountPodSecurityPolicyReviewStatus> getAllowedServiceAccounts();

}
