package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ImageStreamSpec represents options for ImageStreams.
 */
@Value.Immutable
abstract class AbstractImageStreamSpec {
  /*
   * DockerImageRepository is optional, if specified this stream is backed by a Docker repository on this server
   */
  @JsonProperty("dockerImageRepository")
  public abstract String getDockerImageRepository();

  /*
   * Tags map arbitrary string values to specific image locators
   */
  @JsonProperty("tags")
  public abstract java.util.List<io.fabric8.openshift.types.image.v1.TagReference> getTags();

}
