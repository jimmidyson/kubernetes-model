package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ImageChangeCause contains information about the image that triggered a
 * build
 */
@Value.Immutable
abstract class AbstractImageChangeCause {
  /*
   * imageID is the ID of the image that triggered a a new build.
   */
  @JsonProperty("imageID")
  public abstract String getImageID();

  /*
   * fromRef contains detailed information about an image that triggered a
   * build.
   */
  @JsonProperty("fromRef")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getFromRef();

}
