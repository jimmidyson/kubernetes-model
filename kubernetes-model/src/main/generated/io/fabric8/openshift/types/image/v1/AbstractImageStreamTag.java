package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ImageStreamTag represents an Image that is retrieved by tag name from an ImageStream.
 */
@Value.Immutable
abstract class AbstractImageStreamTag implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ImageStreamTag", "v1");
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
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Tag is the spec tag associated with this image stream tag, and it may be null
   * if only pushes have occurred to this image stream.
   */
  @JsonProperty("tag")
  public abstract io.fabric8.openshift.types.image.v1.TagReference getTag();

  /*
   * Generation is the current generation of the tagged image - if tag is provided
   * and this value is not equal to the tag generation, a user has requested an
   * import that has not completed, or Conditions will be filled out indicating any
   * error.
   */
  @JsonProperty("generation")
  public abstract Long getGeneration();

  /*
   * Conditions is an array of conditions that apply to the image stream tag.
   */
  @JsonProperty("conditions")
  public abstract java.util.List<io.fabric8.openshift.types.image.v1.TagEventCondition> getConditions();

  /*
   * Image associated with the ImageStream and tag.
   */
  @JsonProperty("image")
  public abstract io.fabric8.openshift.types.image.v1.Image getImage();

}
