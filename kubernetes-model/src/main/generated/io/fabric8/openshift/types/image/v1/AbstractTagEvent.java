package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * TagEvent is used by ImageStreamStatus to keep a historical record of images associated with a tag.
 */
@Value.Immutable
abstract class AbstractTagEvent {
  /*
   * Created holds the time the TagEvent was created
   */
  @JsonProperty("created")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getCreated();

  /*
   * DockerImageReference is the string that can be used to pull this image
   */
  @JsonProperty("dockerImageReference")
  public abstract String getDockerImageReference();

  /*
   * Image is the image
   */
  @JsonProperty("image")
  public abstract String getImage();

  /*
   * Generation is the spec tag generation that resulted in this tag being updated
   */
  @JsonProperty("generation")
  public abstract Long getGeneration();

}
