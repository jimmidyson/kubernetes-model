package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ImageImportStatus describes the result of an image import.
 */
@Value.Immutable
abstract class AbstractImageImportStatus {
  /*
   * Status is the status of the image import, including errors encountered while retrieving the image
   */
  @JsonProperty("status")
  public abstract io.fabric8.kubernetes.types.api.unversioned.Status getStatus();

  /*
   * Image is the metadata of that image, if the image was located
   */
  @JsonProperty("image")
  public abstract io.fabric8.openshift.types.image.v1.Image getImage();

  /*
   * Tag is the tag this image was located under, if any
   */
  @JsonProperty("tag")
  public abstract String getTag();

}
