package io.fabric8.kubernetes.types.apis.apps.v1alpha1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PetSet represents a set of pods with consistent identities.
 * Identities are defined as:
 *  - Network: A single stable DNS and hostname.
 *  - Storage: As many VolumeClaims as requested.
 * The PetSet guarantees that a given network identity will always
 * map to the same storage identity. PetSet is currently in alpha
 * and subject to change without notice.
 */
@Value.Immutable
abstract class AbstractPetSet implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("PetSet", "apps/v1alpha1");
  }

  @Value.Derived
  public String getApiVersion() {
    return getTypeMeta().getApiVersion();
  }

  @Value.Derived
  public String getKind() {
    return getTypeMeta().getKind();
  }


  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Spec defines the desired identities of pets in this set.
   */
  @JsonProperty("spec")
  public abstract io.fabric8.kubernetes.types.apis.apps.v1alpha1.PetSetSpec getSpec();

  /*
   * Status is the current status of Pets in this PetSet. This data
   * may be out of date by some window of time.
   */
  @JsonProperty("status")
  public abstract io.fabric8.kubernetes.types.apis.apps.v1alpha1.PetSetStatus getStatus();

}
