package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * VolumeMount describes a mounting of a Volume within a container.
 */
@Value.Immutable
abstract class AbstractVolumeMount {
  /*
   * This must match the Name of a Volume.
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * Mounted read-only if true, read-write otherwise (false or unspecified).
   * Defaults to false.
   */
  @JsonProperty("readOnly")
  public abstract Boolean isReadOnly();

  /*
   * Path within the container at which the volume should be mounted.  Must
   * not contain ':'.
   */
  @JsonProperty("mountPath")
  public abstract String getMountPath();

  /*
   * Path within the volume from which the container's volume should be mounted.
   * Defaults to "" (volume's root).
   */
  @JsonProperty("subPath")
  public abstract String getSubPath();

}
