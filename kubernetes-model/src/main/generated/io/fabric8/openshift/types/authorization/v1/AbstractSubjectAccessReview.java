package io.fabric8.openshift.types.authorization.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SubjectAccessReview is an object for requesting information about whether a user or group can perform an action
 */
@Value.Immutable
abstract class AbstractSubjectAccessReview {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("SubjectAccessReview", "v1");
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
   * Action describes the action being tested.
   */
  @JsonUnwrapped
  public abstract io.fabric8.openshift.types.authorization.v1.Action getAction();

  /*
   * User is optional. If both User and Groups are empty, the current authenticated user is used.
   */
  @JsonProperty("user")
  public abstract String getUser();

  /*
   * GroupsSlice is optional. Groups is the list of groups to which the User belongs.
   * +genconversion=false
   */
  @JsonProperty("groups")
  public abstract java.util.List<String> getGroups();

  /*
   * Scopes to use for the evaluation.  Empty means "use the unscoped (full) permissions of the user/groups".
   * Nil for a self-SAR, means "use the scopes on this request".
   * Nil for a regular SAR, means the same as empty.
   */
  @JsonProperty("scopes")
  public abstract java.util.List<String> getScopes();

}
