package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Volume represents a named volume in a pod that may be accessed by any container in the pod.
 */
@Value.Immutable
abstract class AbstractVolume {
  /*
   * Volume's name.
   * Must be a DNS_LABEL and unique within the pod.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/identifiers.md#names
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * VolumeSource represents the location and type of the mounted volume.
   * If not specified, the Volume is implied to be an EmptyDir.
   * This implied behavior is deprecated and will be removed in a future version.
   */
  @JsonUnwrapped
  public abstract io.fabric8.kubernetes.types.api.v1.VolumeSource getVolumeSource();

}
