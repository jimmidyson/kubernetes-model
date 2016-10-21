package io.fabric8.openshift.types.authorization.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ResourceAccessReviewResponse describes who can perform the action
 */
@Value.Immutable
abstract class AbstractResourceAccessReviewResponse {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ResourceAccessReviewResponse", "v1");
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
   * UsersSlice is the list of users who can perform the action
   * +genconversion=false
   */
  @JsonProperty("users")
  public abstract java.util.List<String> getUsers();

  /*
   * GroupsSlice is the list of groups who can perform the action
   * +genconversion=false
   */
  @JsonProperty("groups")
  public abstract java.util.List<String> getGroups();

  /*
   * EvaluationError is an indication that some error occurred during resolution, but partial results can still be returned.
   * It is entirely possible to get an error and be able to continue determine authorization status in spite of it.  This is
   * most common when a bound role is missing, but enough roles are still present and bound to reason about the request.
   */
  @JsonProperty("evalutionError")
  public abstract String getEvalutionError();

}
