package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PersistentVolumeClaimSpec describes the common attributes of storage devices
 * and allows a Source for provider-specific attributes
 */
@Value.Immutable
abstract class AbstractPersistentVolumeClaimSpec {
  /*
   * AccessModes contains the desired access modes the volume should have.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/persistent-volumes.md#access-modes-1
   */
  @JsonProperty("accessModes")
  public abstract java.util.List<String> getAccessModes();

  /*
   * A label query over volumes to consider for binding.
   */
  @JsonProperty("selector")
  public abstract io.fabric8.kubernetes.types.api.unversioned.LabelSelector getSelector();

  /*
   * Resources represents the minimum resources the volume should have.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/persistent-volumes.md#resources
   */
  @JsonProperty("resources")
  public abstract io.fabric8.kubernetes.types.api.v1.ResourceRequirements getResources();

  /*
   * VolumeName is the binding reference to the PersistentVolume backing this claim.
   */
  @JsonProperty("volumeName")
  public abstract String getVolumeName();

}
