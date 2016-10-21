package io.fabric8.openshift.types.authorization.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SubjectAccessReviewResponse describes whether or not a user or group can perform an action
 */
@Value.Immutable
abstract class AbstractSubjectAccessReviewResponse {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("SubjectAccessReviewResponse", "v1");
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
   * Namespace is the namespace used for the access review
   */
  @JsonProperty("namespace")
  public abstract String getNamespace();

  /*
   * Allowed is required.  True if the action would be allowed, false otherwise.
   */
  @JsonProperty("allowed")
  public abstract Boolean isAllowed();

  /*
   * Reason is optional.  It indicates why a request was allowed or denied.
   */
  @JsonProperty("reason")
  public abstract String getReason();

  /*
   * EvaluationError is an indication that some error occurred during the authorization check.
   * It is entirely possible to get an error and be able to continue determine authorization status in spite of it.  This is
   * most common when a bound role is missing, but enough roles are still present and bound to reason about the request.
   */
  @JsonProperty("evaluationError")
  public abstract String getEvaluationError();

}
