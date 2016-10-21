package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PersistentVolumeClaimStatus is the current status of a persistent volume claim.
 */
@Value.Immutable
abstract class AbstractPersistentVolumeClaimStatus {
  /*
   * Phase represents the current phase of PersistentVolumeClaim.
   */
  @JsonProperty("phase")
  public abstract String getPhase();

  /*
   * AccessModes contains the actual access modes the volume backing the PVC has.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/persistent-volumes.md#access-modes-1
   */
  @JsonProperty("accessModes")
  public abstract java.util.List<String> getAccessModes();

  /*
   * Represents the actual resources of the underlying volume.
   */
  @JsonProperty("capacity")
  public abstract java.util.Map<String, io.fabric8.kubernetes.types.api.resource.Quantity> getCapacity();

}
