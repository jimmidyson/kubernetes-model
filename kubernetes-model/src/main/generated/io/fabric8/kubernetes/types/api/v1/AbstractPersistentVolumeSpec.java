package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PersistentVolumeSpec is the specification of a persistent volume.
 */
@Value.Immutable
abstract class AbstractPersistentVolumeSpec {
  /*
   * A description of the persistent volume's resources and capacity.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/persistent-volumes.md#capacity
   */
  @JsonProperty("capacity")
  public abstract java.util.Map<String, io.fabric8.kubernetes.types.api.resource.Quantity> getCapacity();

  /*
   * The actual volume backing the persistent volume.
   */
  @JsonUnwrapped
  public abstract io.fabric8.kubernetes.types.api.v1.PersistentVolumeSource getPersistentVolumeSource();

  /*
   * AccessModes contains all ways the volume can be mounted.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/persistent-volumes.md#access-modes
   */
  @JsonProperty("accessModes")
  public abstract java.util.List<String> getAccessModes();

  /*
   * ClaimRef is part of a bi-directional binding between PersistentVolume and PersistentVolumeClaim.
   * Expected to be non-nil when bound.
   * claim.VolumeName is the authoritative bind between PV and PVC.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/persistent-volumes.md#binding
   */
  @JsonProperty("claimRef")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getClaimRef();

  /*
   * What happens to a persistent volume when released from its claim.
   * Valid options are Retain (default) and Recycle.
   * Recyling must be supported by the volume plugin underlying this persistent volume.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/persistent-volumes.md#recycling-policy
   */
  @JsonProperty("persistentVolumeReclaimPolicy")
  public abstract String getPersistentVolumeReclaimPolicy();

}
