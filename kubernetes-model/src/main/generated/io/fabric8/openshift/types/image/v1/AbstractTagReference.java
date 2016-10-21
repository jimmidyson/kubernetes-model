package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * TagReference specifies optional annotations for images using this tag and an optional reference to an ImageStreamTag, ImageStreamImage, or DockerImage this tag should track.
 */
@Value.Immutable
abstract class AbstractTagReference {
  /*
   * Name of the tag
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * Annotations associated with images using this tag
   */
  @JsonProperty("annotations")
  public abstract java.util.Map<String, String> getAnnotations();

  /*
   * From is a reference to an image stream tag or image stream this tag should track
   */
  @JsonProperty("from")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getFrom();

  /*
   * Reference states if the tag will be imported. Default value is false, which means the tag will be imported.
   */
  @JsonProperty("reference")
  public abstract Boolean isReference();

  /*
   * Generation is the image stream generation that updated this tag - setting it to 0 is an indication that the generation must be updated.
   * Legacy clients will send this as nil, which means the client doesn't know or care.
   */
  @JsonProperty("generation")
  public abstract Long getGeneration();

  /*
   * Import is information that controls how images may be imported by the server.
   */
  @JsonProperty("importPolicy")
  public abstract io.fabric8.openshift.types.image.v1.TagImportPolicy getImportPolicy();

}
