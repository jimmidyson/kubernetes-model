package io.fabric8.openshift.types.user.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Identity records a successful authentication of a user with an identity provider
 */
@Value.Immutable
abstract class AbstractIdentity implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("Identity", "v1");
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
   * ProviderName is the source of identity information
   */
  @JsonProperty("providerName")
  public abstract String getProviderName();

  /*
   * ProviderUserName uniquely represents this identity in the scope of the provider
   */
  @JsonProperty("providerUserName")
  public abstract String getProviderUserName();

  /*
   * User is a reference to the user this identity is associated with
   * Both Name and UID must be set
   */
  @JsonProperty("user")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getUser();

  /*
   * Extra holds extra information about this identity
   */
  @JsonProperty("extra")
  public abstract java.util.Map<String, String> getExtra();

}
