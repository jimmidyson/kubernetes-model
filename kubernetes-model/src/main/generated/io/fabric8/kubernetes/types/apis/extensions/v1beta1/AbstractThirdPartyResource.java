package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * A ThirdPartyResource is a generic representation of a resource, it is used by add-ons and plugins to add new resource
 * types to the API.  It consists of one or more Versions of the api.
 */
@Value.Immutable
abstract class AbstractThirdPartyResource implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ThirdPartyResource", "extensions/v1beta1");
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
   * Standard object metadata
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Description is the description of this object.
   */
  @JsonProperty("description")
  public abstract String getDescription();

  /*
   * Versions are versions for this third party object
   */
  @JsonProperty("versions")
  public abstract java.util.List<io.fabric8.kubernetes.types.apis.extensions.v1beta1.APIVersion> getVersions();

}
