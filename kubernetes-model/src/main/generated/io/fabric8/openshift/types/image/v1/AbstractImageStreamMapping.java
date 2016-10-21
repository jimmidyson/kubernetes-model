package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ImageStreamMapping represents a mapping from a single tag to a Docker image as
 * well as the reference to the Docker image stream the image came from.
 */
@Value.Immutable
abstract class AbstractImageStreamMapping implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ImageStreamMapping", "v1");
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
   * Image is a Docker image.
   */
  @JsonProperty("image")
  public abstract io.fabric8.openshift.types.image.v1.Image getImage();

  /*
   * Tag is a string value this image can be located with inside the stream.
   */
  @JsonProperty("tag")
  public abstract String getTag();

}
