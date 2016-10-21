package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Represents a Glusterfs mount that lasts the lifetime of a pod.
 * Glusterfs volumes do not support ownership management or SELinux relabeling.
 */
@Value.Immutable
abstract class AbstractGlusterfsVolumeSource {
  /*
   * EndpointsName is the endpoint name that details Glusterfs topology.
   * More info: http://releases.k8s.io/release-1.3/examples/glusterfs/README.md#create-a-pod
   */
  @JsonProperty("endpoints")
  public abstract String getEndpoints();

  /*
   * Path is the Glusterfs volume path.
   * More info: http://releases.k8s.io/release-1.3/examples/glusterfs/README.md#create-a-pod
   */
  @JsonProperty("path")
  public abstract String getPath();

  /*
   * ReadOnly here will force the Glusterfs volume to be mounted with read-only permissions.
   * Defaults to false.
   * More info: http://releases.k8s.io/release-1.3/examples/glusterfs/README.md#create-a-pod
   */
  @JsonProperty("readOnly")
  public abstract Boolean isReadOnly();

}
