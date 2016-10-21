package io.fabric8.kubernetes.types.apis.apps.v1alpha1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PetSetList is a collection of PetSets.
 */
@Value.Immutable
abstract class AbstractPetSetList {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("PetSetList", "apps/v1alpha1");
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
  public abstract io.fabric8.kubernetes.types.api.unversioned.ListMeta getMetadata();


  @JsonProperty("items")
  public abstract java.util.List<io.fabric8.kubernetes.types.apis.apps.v1alpha1.PetSet> getItems();

}
