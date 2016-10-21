package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeprecatedDownwardAPIVolumeFile represents information to create the file containing the pod field
 * This type is deprecated and should be replaced by use of the downwardAPI volume source.
 */
@Value.Immutable
abstract class AbstractDeprecatedDownwardAPIVolumeFile {
  /*
   * Required: Name is the relative path name of the file to be created. Must not be absolute or contain the '..' path. Must be utf-8 encoded. The first item of the relative path must not start with '..'
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * Required: Selects a field of the pod: only annotations, labels, name and namespace are supported.
   */
  @JsonProperty("fieldRef")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectFieldSelector getFieldRef();

  /*
   * Selects a resource of the container: only resources limits and requests
   * (limits.cpu, limits.memory, requests.cpu and requests.memory) are currently supported.
   */
  @JsonProperty("resourceFieldRef")
  public abstract io.fabric8.kubernetes.types.api.v1.ResourceFieldSelector getResourceFieldRef();

}
