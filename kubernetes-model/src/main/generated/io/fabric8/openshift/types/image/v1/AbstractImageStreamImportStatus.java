package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ImageStreamImportStatus contains information about the status of an image stream import.
 */
@Value.Immutable
abstract class AbstractImageStreamImportStatus {
  /*
   * Import is the image stream that was successfully updated or created when 'to' was set.
   */
  @JsonProperty("import")
  public abstract io.fabric8.openshift.types.image.v1.ImageStream getImport();

  /*
   * Repository is set if spec.repository was set to the outcome of the import
   */
  @JsonProperty("repository")
  public abstract io.fabric8.openshift.types.image.v1.RepositoryImportStatus getRepository();

  /*
   * Images is set with the result of importing spec.images
   */
  @JsonProperty("images")
  public abstract java.util.List<io.fabric8.openshift.types.image.v1.ImageImportStatus> getImages();

}
