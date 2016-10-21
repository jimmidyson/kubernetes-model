package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ImageStreamImportSpec defines what images should be imported.
 */
@Value.Immutable
abstract class AbstractImageStreamImportSpec {
  /*
   * Import indicates whether to perform an import - if so, the specified tags are set on the spec
   * and status of the image stream defined by the type meta.
   */
  @JsonProperty("import")
  public abstract Boolean isImport();

  /*
   * Repository is an optional import of an entire Docker image repository. A maximum limit on the
   * number of tags imported this way is imposed by the server.
   */
  @JsonProperty("repository")
  public abstract io.fabric8.openshift.types.image.v1.RepositoryImportSpec getRepository();

  /*
   * Images are a list of individual images to import.
   */
  @JsonProperty("images")
  public abstract java.util.List<io.fabric8.openshift.types.image.v1.ImageImportSpec> getImages();

}
