package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Describe a container image
 */
@Value.Immutable
abstract class AbstractContainerImage {
  /*
   * Names by which this image is known.
   * e.g. ["gcr.io/google_containers/hyperkube:v1.0.7", "dockerhub.io/google_containers/hyperkube:v1.0.7"]
   */
  @JsonProperty("names")
  public abstract java.util.List<String> getNames();

  /*
   * The size of the image in bytes.
   */
  @JsonProperty("sizeBytes")
  public abstract Long getSizeBytes();

}
