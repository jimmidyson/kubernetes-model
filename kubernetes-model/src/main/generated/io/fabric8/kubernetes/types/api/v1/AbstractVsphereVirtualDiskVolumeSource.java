package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Represents a vSphere volume resource.
 */
@Value.Immutable
abstract class AbstractVsphereVirtualDiskVolumeSource {
  /*
   * Path that identifies vSphere volume vmdk
   */
  @JsonProperty("volumePath")
  public abstract String getVolumePath();

  /*
   * Filesystem type to mount.
   * Must be a filesystem type supported by the host operating system.
   * Ex. "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified.
   */
  @JsonProperty("fsType")
  public abstract String getFsType();

}
