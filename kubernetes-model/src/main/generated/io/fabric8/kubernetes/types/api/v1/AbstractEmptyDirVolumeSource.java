package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Represents an empty directory for a pod.
 * Empty directory volumes support ownership management and SELinux relabeling.
 */
@Value.Immutable
abstract class AbstractEmptyDirVolumeSource {
  /*
   * What type of storage medium should back this directory.
   * The default is "" which means to use the node's default medium.
   * Must be an empty string (default) or Memory.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md#emptydir
   */
  @JsonProperty("medium")
  public abstract String getMedium();

}
