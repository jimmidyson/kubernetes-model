package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * RepositoryImportSpec describes a request to import images from a Docker image repository.
 */
@Value.Immutable
abstract class AbstractRepositoryImportSpec {
  /*
   * From is the source for the image repository to import; only kind DockerImage and a name of a Docker image repository is allowed
   */
  @JsonProperty("from")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getFrom();

  /*
   * ImportPolicy is the policy controlling how the image is imported
   */
  @JsonProperty("importPolicy")
  public abstract io.fabric8.openshift.types.image.v1.TagImportPolicy getImportPolicy();

  /*
   * IncludeManifest determines if the manifest for each image is returned in the response
   */
  @JsonProperty("includeManifest")
  public abstract Boolean isIncludeManifest();

}
