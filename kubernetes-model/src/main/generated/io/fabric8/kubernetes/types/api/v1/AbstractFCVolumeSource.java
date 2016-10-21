package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Represents a Fibre Channel volume.
 * Fibre Channel volumes can only be mounted as read/write once.
 * Fibre Channel volumes support ownership management and SELinux relabeling.
 */
@Value.Immutable
abstract class AbstractFCVolumeSource {
  /*
   * Required: FC target world wide names (WWNs)
   */
  @JsonProperty("targetWWNs")
  public abstract java.util.List<String> getTargetWWNs();

  /*
   * Required: FC target lun number
   */
  @JsonProperty("lun")
  public abstract Integer getLun();

  /*
   * Filesystem type to mount.
   * Must be a filesystem type supported by the host operating system.
   * Ex. "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified.
   * TODO: how do we prevent errors in the filesystem from compromising the machine
   */
  @JsonProperty("fsType")
  public abstract String getFsType();

  /*
   * Optional: Defaults to false (read/write). ReadOnly here will force
   * the ReadOnly setting in VolumeMounts.
   */
  @JsonProperty("readOnly")
  public abstract Boolean isReadOnly();

}
