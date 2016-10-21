package io.fabric8.kubernetes.types.apis.authentication.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * UserInfo holds the information about the user needed to implement the
 * user.Info interface.
 */
@Value.Immutable
abstract class AbstractUserInfo {
  /*
   * The name that uniquely identifies this user among all active users.
   */
  @JsonProperty("username")
  public abstract String getUsername();

  /*
   * A unique value that identifies this user across time. If this user is
   * deleted and another user by the same name is added, they will have
   * different UIDs.
   */
  @JsonProperty("uid")
  public abstract String getUid();

  /*
   * The names of groups this user is a part of.
   */
  @JsonProperty("groups")
  public abstract java.util.List<String> getGroups();

  /*
   * Any additional information provided by the authenticator.
   */
  @JsonProperty("extra")
  public abstract java.util.Map<String, java.util.List<String>> getExtra();

}
