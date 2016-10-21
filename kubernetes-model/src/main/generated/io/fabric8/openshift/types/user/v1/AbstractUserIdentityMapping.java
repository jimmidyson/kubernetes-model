package io.fabric8.openshift.types.user.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * UserIdentityMapping maps a user to an identity
 */
@Value.Immutable
abstract class AbstractUserIdentityMapping implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("UserIdentityMapping", "v1");
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
   * Identity is a reference to an identity
   */
  @JsonProperty("identity")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getIdentity();

  /*
   * User is a reference to a user
   */
  @JsonProperty("user")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getUser();

}
