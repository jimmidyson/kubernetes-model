package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Represents a host path mapped into a pod.
 * Host path volumes do not support ownership management or SELinux relabeling.
 */
@Value.Immutable
abstract class AbstractHostPathVolumeSource {
  /*
   * Path of the directory on the host.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#hostpath
   */
  @JsonProperty("path")
  public abstract String getPath();

}
