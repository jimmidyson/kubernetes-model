package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * RepositoryImportStatus describes the result of an image repository import
 */
@Value.Immutable
abstract class AbstractRepositoryImportStatus {
  /*
   * Status reflects whether any failure occurred during import
   */
  @JsonProperty("status")
  public abstract io.fabric8.kubernetes.types.api.unversioned.Status getStatus();

  /*
   * Images is a list of images successfully retrieved by the import of the repository.
   */
  @JsonProperty("images")
  public abstract java.util.List<io.fabric8.openshift.types.image.v1.ImageImportStatus> getImages();

  /*
   * AdditionalTags are tags that exist in the repository but were not imported because
   * a maximum limit of automatic imports was applied.
   */
  @JsonProperty("additionalTags")
  public abstract java.util.List<String> getAdditionalTags();

}
