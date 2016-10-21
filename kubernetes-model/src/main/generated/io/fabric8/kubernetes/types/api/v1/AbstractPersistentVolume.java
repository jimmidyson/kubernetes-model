package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PersistentVolume (PV) is a storage resource provisioned by an administrator.
 * It is analogous to a node.
 * More info: http://releases.k8s.io/release-1.3/docs/user-guide/persistent-volumes.md
 */
@Value.Immutable
abstract class AbstractPersistentVolume implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("PersistentVolume", "v1");
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
   * Spec defines a specification of a persistent volume owned by the cluster.
   * Provisioned by an administrator.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/persistent-volumes.md#persistent-volumes
   */
  @JsonProperty("spec")
  public abstract io.fabric8.kubernetes.types.api.v1.PersistentVolumeSpec getSpec();

  /*
   * Status represents the current information/status for the persistent volume.
   * Populated by the system.
   * Read-only.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/persistent-volumes.md#persistent-volumes
   */
  @JsonProperty("status")
  public abstract io.fabric8.kubernetes.types.api.v1.PersistentVolumeStatus getStatus();

}
