package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ImageImportSpec describes a request to import a specific image.
 */
@Value.Immutable
abstract class AbstractImageImportSpec {
  /*
   * From is the source of an image to import; only kind DockerImage is allowed
   */
  @JsonProperty("from")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getFrom();

  /*
   * To is a tag in the current image stream to assign the imported image to, if name is not specified the default tag from from.name will be used
   */
  @JsonProperty("to")
  public abstract io.fabric8.kubernetes.types.api.v1.LocalObjectReference getTo();

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
