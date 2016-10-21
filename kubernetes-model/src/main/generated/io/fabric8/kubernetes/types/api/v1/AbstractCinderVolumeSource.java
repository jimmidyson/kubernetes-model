package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Represents a cinder volume resource in Openstack.
 * A Cinder volume must exist before mounting to a container.
 * The volume must also be in the same region as the kubelet.
 * Cinder volumes support ownership management and SELinux relabeling.
 */
@Value.Immutable
abstract class AbstractCinderVolumeSource {
  /*
   * volume id used to identify the volume in cinder
   * More info: http://releases.k8s.io/release-1.3/examples/mysql-cinder-pd/README.md
   */
  @JsonProperty("volumeID")
  public abstract String getVolumeID();

  /*
   * Filesystem type to mount.
   * Must be a filesystem type supported by the host operating system.
   * Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified.
   * More info: http://releases.k8s.io/release-1.3/examples/mysql-cinder-pd/README.md
   */
  @JsonProperty("fsType")
  public abstract String getFsType();

  /*
   * Optional: Defaults to false (read/write). ReadOnly here will force
   * the ReadOnly setting in VolumeMounts.
   * More info: http://releases.k8s.io/release-1.3/examples/mysql-cinder-pd/README.md
   */
  @JsonProperty("readOnly")
  public abstract Boolean isReadOnly();

}
