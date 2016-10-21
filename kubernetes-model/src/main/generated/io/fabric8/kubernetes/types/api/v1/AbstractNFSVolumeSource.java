package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Represents an NFS mount that lasts the lifetime of a pod.
 * NFS volumes do not support ownership management or SELinux relabeling.
 */
@Value.Immutable
abstract class AbstractNFSVolumeSource {
  /*
   * Server is the hostname or IP address of the NFS server.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#nfs
   */
  @JsonProperty("server")
  public abstract String getServer();

  /*
   * Path that is exported by the NFS server.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#nfs
   */
  @JsonProperty("path")
  public abstract String getPath();

  /*
   * ReadOnly here will force
   * the NFS export to be mounted with read-only permissions.
   * Defaults to false.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#nfs
   */
  @JsonProperty("readOnly")
  public abstract Boolean isReadOnly();

}
