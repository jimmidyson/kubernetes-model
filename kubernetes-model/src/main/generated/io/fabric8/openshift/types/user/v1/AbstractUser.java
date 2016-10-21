package io.fabric8.openshift.types.user.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * User describes someone that makes requests to the API
 */
@Value.Immutable
abstract class AbstractUser implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("User", "v1");
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
   * Standard object's metadata.
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * FullName is the full name of user
   */
  @JsonProperty("fullName")
  public abstract String getFullName();

  /*
   * Identities are the identities associated with this user
   */
  @JsonProperty("identities")
  public abstract java.util.List<String> getIdentities();

  /*
   * Groups are the groups that this user is a member of
   */
  @JsonProperty("groups")
  public abstract java.util.List<String> getGroups();

}
