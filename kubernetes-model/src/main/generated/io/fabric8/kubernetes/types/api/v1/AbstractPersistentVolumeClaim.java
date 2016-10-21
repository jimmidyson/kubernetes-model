package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PersistentVolumeClaim is a user's request for and claim to a persistent volume
 */
@Value.Immutable
abstract class AbstractPersistentVolumeClaim implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("PersistentVolumeClaim", "v1");
  }

  @Value.Derived
  public String getApiVersion() {
    return getTypeMeta().getApiVersion();
  }

  @Value.Derived
  public String getKind() {
    return getTypeMeta().getKind();
  }

  /*
   * Standard object's metadata.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#metadata
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Spec defines the desired characteristics of a volume requested by a pod author.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/persistent-volumes.md#persistentvolumeclaims
   */
  @JsonProperty("spec")
  public abstract io.fabric8.kubernetes.types.api.v1.PersistentVolumeClaimSpec getSpec();

  /*
   * Status represents the current information/status of a persistent volume claim.
   * Read-only.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/persistent-volumes.md#persistentvolumeclaims
   */
  @JsonProperty("status")
  public abstract io.fabric8.kubernetes.types.api.v1.PersistentVolumeClaimStatus getStatus();

}
