package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * AttachedVolume describes a volume attached to a node
 */
@Value.Immutable
abstract class AbstractAttachedVolume {
  /*
   * Name of the attached volume
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * DevicePath represents the device path where the volume should be avilable
   */
  @JsonProperty("devicePath")
  public abstract String getDevicePath();

}
