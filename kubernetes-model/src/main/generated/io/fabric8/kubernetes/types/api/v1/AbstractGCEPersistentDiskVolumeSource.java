package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Represents a Persistent Disk resource in Google Compute Engine.
 * 
 * A GCE PD must exist before mounting to a container. The disk must
 * also be in the same GCE project and zone as the kubelet. A GCE PD
 * can only be mounted as read/write once or read-only many times. GCE
 * PDs support ownership management and SELinux relabeling.
 */
@Value.Immutable
abstract class AbstractGCEPersistentDiskVolumeSource {
  /*
   * Unique name of the PD resource in GCE. Used to identify the disk in GCE.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#gcepersistentdisk
   */
  @JsonProperty("pdName")
  public abstract String getPdName();

  /*
   * Filesystem type of the volume that you want to mount.
   * Tip: Ensure that the filesystem type is supported by the host operating system.
   * Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#gcepersistentdisk
   * TODO: how do we prevent errors in the filesystem from compromising the machine
   */
  @JsonProperty("fsType")
  public abstract String getFsType();

  /*
   * The partition in the volume that you want to mount.
   * If omitted, the default is to mount by volume name.
   * Examples: For volume /dev/sda1, you specify the partition as "1".
   * Similarly, the volume partition for /dev/sda is "0" (or you can leave the property empty).
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#gcepersistentdisk
   */
  @JsonProperty("partition")
  public abstract Integer getPartition();

  /*
   * ReadOnly here will force the ReadOnly setting in VolumeMounts.
   * Defaults to false.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#gcepersistentdisk
   */
  @JsonProperty("readOnly")
  public abstract Boolean isReadOnly();

}
