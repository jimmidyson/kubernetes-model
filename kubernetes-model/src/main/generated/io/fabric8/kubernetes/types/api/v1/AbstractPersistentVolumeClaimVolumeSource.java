package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PersistentVolumeClaimVolumeSource references the user's PVC in the same namespace.
 * This volume finds the bound PV and mounts that volume for the pod. A
 * PersistentVolumeClaimVolumeSource is, essentially, a wrapper around another
 * type of volume that is owned by someone else (the system).
 */
@Value.Immutable
abstract class AbstractPersistentVolumeClaimVolumeSource {
  /*
   * ClaimName is the name of a PersistentVolumeClaim in the same namespace as the pod using this volume.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/persistent-volumes.md#persistentvolumeclaims
   */
  @JsonProperty("claimName")
  public abstract String getClaimName();

  /*
   * Will force the ReadOnly setting in VolumeMounts.
   * Default false.
   */
  @JsonProperty("readOnly")
  public abstract Boolean isReadOnly();

}
