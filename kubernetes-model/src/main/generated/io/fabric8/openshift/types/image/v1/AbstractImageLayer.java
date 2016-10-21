package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ImageLayer represents a single layer of the image. Some images may have multiple layers. Some may have none.
 */
@Value.Immutable
abstract class AbstractImageLayer {
  /*
   * Name of the layer as defined by the underlying store.
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * Size of the layer in bytes as defined by the underlying store.
   */
  @JsonProperty("size")
  public abstract Long getSize();

  /*
   * MediaType of the referenced object.
   */
  @JsonProperty("mediaType")
  public abstract String getMediaType();

}
