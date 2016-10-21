package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Represents a Ceph Filesystem mount that lasts the lifetime of a pod
 * Cephfs volumes do not support ownership management or SELinux relabeling.
 */
@Value.Immutable
abstract class AbstractCephFSVolumeSource {
  /*
   * Required: Monitors is a collection of Ceph monitors
   * More info: http://releases.k8s.io/release-1.3/examples/cephfs/README.md#how-to-use-it
   */
  @JsonProperty("monitors")
  public abstract java.util.List<String> getMonitors();

  /*
   * Optional: Used as the mounted root, rather than the full Ceph tree, default is /
   */
  @JsonProperty("path")
  public abstract String getPath();

  /*
   * Optional: User is the rados user name, default is admin
   * More info: http://releases.k8s.io/release-1.3/examples/cephfs/README.md#how-to-use-it
   */
  @JsonProperty("user")
  public abstract String getUser();

  /*
   * Optional: SecretFile is the path to key ring for User, default is /etc/ceph/user.secret
   * More info: http://releases.k8s.io/release-1.3/examples/cephfs/README.md#how-to-use-it
   */
  @JsonProperty("secretFile")
  public abstract String getSecretFile();

  /*
   * Optional: SecretRef is reference to the authentication secret for User, default is empty.
   * More info: http://releases.k8s.io/release-1.3/examples/cephfs/README.md#how-to-use-it
   */
  @JsonProperty("secretRef")
  public abstract io.fabric8.kubernetes.types.api.v1.LocalObjectReference getSecretRef();

  /*
   * Optional: Defaults to false (read/write). ReadOnly here will force
   * the ReadOnly setting in VolumeMounts.
   * More info: http://releases.k8s.io/release-1.3/examples/cephfs/README.md#how-to-use-it
   */
  @JsonProperty("readOnly")
  public abstract Boolean isReadOnly();

}
