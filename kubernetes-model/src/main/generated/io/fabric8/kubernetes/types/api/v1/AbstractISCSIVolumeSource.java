package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Represents an ISCSI disk.
 * ISCSI volumes can only be mounted as read/write once.
 * ISCSI volumes support ownership management and SELinux relabeling.
 */
@Value.Immutable
abstract class AbstractISCSIVolumeSource {
  /*
   * iSCSI target portal. The portal is either an IP or ip_addr:port if the port
   * is other than default (typically TCP ports 860 and 3260).
   */
  @JsonProperty("targetPortal")
  public abstract String getTargetPortal();

  /*
   * Target iSCSI Qualified Name.
   */
  @JsonProperty("iqn")
  public abstract String getIqn();

  /*
   * iSCSI target lun number.
   */
  @JsonProperty("lun")
  public abstract Integer getLun();

  /*
   * Optional: Defaults to 'default' (tcp). iSCSI interface name that uses an iSCSI transport.
   */
  @JsonProperty("iscsiInterface")
  public abstract String getIscsiInterface();

  /*
   * Filesystem type of the volume that you want to mount.
   * Tip: Ensure that the filesystem type is supported by the host operating system.
   * Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#iscsi
   * TODO: how do we prevent errors in the filesystem from compromising the machine
   */
  @JsonProperty("fsType")
  public abstract String getFsType();

  /*
   * ReadOnly here will force the ReadOnly setting in VolumeMounts.
   * Defaults to false.
   */
  @JsonProperty("readOnly")
  public abstract Boolean isReadOnly();

}
