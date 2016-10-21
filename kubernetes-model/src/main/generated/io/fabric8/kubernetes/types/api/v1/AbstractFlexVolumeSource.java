package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * FlexVolume represents a generic volume resource that is
 * provisioned/attached using a exec based plugin. This is an alpha feature and may change in future.
 */
@Value.Immutable
abstract class AbstractFlexVolumeSource {
  /*
   * Driver is the name of the driver to use for this volume.
   */
  @JsonProperty("driver")
  public abstract String getDriver();

  /*
   * Filesystem type to mount.
   * Must be a filesystem type supported by the host operating system.
   * Ex. "ext4", "xfs", "ntfs". The default filesystem depends on FlexVolume script.
   */
  @JsonProperty("fsType")
  public abstract String getFsType();

  /*
   * Optional: SecretRef is reference to the secret object containing
   * sensitive information to pass to the plugin scripts. This may be
   * empty if no secret object is specified. If the secret object
   * contains more than one secret, all secrets are passed to the plugin
   * scripts.
   */
  @JsonProperty("secretRef")
  public abstract io.fabric8.kubernetes.types.api.v1.LocalObjectReference getSecretRef();

  /*
   * Optional: Defaults to false (read/write). ReadOnly here will force
   * the ReadOnly setting in VolumeMounts.
   */
  @JsonProperty("readOnly")
  public abstract Boolean isReadOnly();

  /*
   * Optional: Extra command options if any.
   */
  @JsonProperty("options")
  public abstract java.util.Map<String, String> getOptions();

}
