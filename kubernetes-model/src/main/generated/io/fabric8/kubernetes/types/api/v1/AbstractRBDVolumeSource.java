package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Represents a Rados Block Device mount that lasts the lifetime of a pod.
 * RBD volumes support ownership management and SELinux relabeling.
 */
@Value.Immutable
abstract class AbstractRBDVolumeSource {
  /*
   * A collection of Ceph monitors.
   * More info: http://releases.k8s.io/release-1.3/examples/rbd/README.md#how-to-use-it
   */
  @JsonProperty("monitors")
  public abstract java.util.List<String> getMonitors();

  /*
   * The rados image name.
   * More info: http://releases.k8s.io/release-1.3/examples/rbd/README.md#how-to-use-it
   */
  @JsonProperty("image")
  public abstract String getImage();

  /*
   * Filesystem type of the volume that you want to mount.
   * Tip: Ensure that the filesystem type is supported by the host operating system.
   * Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#rbd
   * TODO: how do we prevent errors in the filesystem from compromising the machine
   */
  @JsonProperty("fsType")
  public abstract String getFsType();

  /*
   * The rados pool name.
   * Default is rbd.
   * More info: http://releases.k8s.io/release-1.3/examples/rbd/README.md#how-to-use-it.
   */
  @JsonProperty("pool")
  public abstract String getPool();

  /*
   * The rados user name.
   * Default is admin.
   * More info: http://releases.k8s.io/release-1.3/examples/rbd/README.md#how-to-use-it
   */
  @JsonProperty("user")
  public abstract String getUser();

  /*
   * Keyring is the path to key ring for RBDUser.
   * Default is /etc/ceph/keyring.
   * More info: http://releases.k8s.io/release-1.3/examples/rbd/README.md#how-to-use-it
   */
  @JsonProperty("keyring")
  public abstract String getKeyring();

  /*
   * SecretRef is name of the authentication secret for RBDUser. If provided
   * overrides keyring.
   * Default is nil.
   * More info: http://releases.k8s.io/release-1.3/examples/rbd/README.md#how-to-use-it
   */
  @JsonProperty("secretRef")
  public abstract io.fabric8.kubernetes.types.api.v1.LocalObjectReference getSecretRef();

  /*
   * ReadOnly here will force the ReadOnly setting in VolumeMounts.
   * Defaults to false.
   * More info: http://releases.k8s.io/release-1.3/examples/rbd/README.md#how-to-use-it
   */
  @JsonProperty("readOnly")
  public abstract Boolean isReadOnly();

}
