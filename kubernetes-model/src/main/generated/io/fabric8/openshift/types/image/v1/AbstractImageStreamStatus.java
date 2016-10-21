package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ImageStreamStatus contains information about the state of this image stream.
 */
@Value.Immutable
abstract class AbstractImageStreamStatus {
  /*
   * DockerImageRepository represents the effective location this stream may be accessed at.
   * May be empty until the server determines where the repository is located
   */
  @JsonProperty("dockerImageRepository")
  public abstract String getDockerImageRepository();

  /*
   * Tags are a historical record of images associated with each tag. The first entry in the
   * TagEvent array is the currently tagged image.
   */
  @JsonProperty("tags")
  public abstract java.util.List<io.fabric8.openshift.types.image.v1.NamedTagEventList> getTags();

}
