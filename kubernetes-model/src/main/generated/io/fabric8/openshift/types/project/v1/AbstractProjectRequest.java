package io.fabric8.openshift.types.project.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ProjecRequest is the set of options necessary to fully qualify a project request
 */
@Value.Immutable
abstract class AbstractProjectRequest implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ProjectRequest", "v1");
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
   * DisplayName is the display name to apply to a project
   */
  @JsonProperty("displayName")
  public abstract String getDisplayName();

  /*
   * Description is the description to apply to a project
   */
  @JsonProperty("description")
  public abstract String getDescription();

}
