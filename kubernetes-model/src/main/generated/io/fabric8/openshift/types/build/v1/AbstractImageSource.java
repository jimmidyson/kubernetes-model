package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ImageSource describes an image that is used as source for the build
 */
@Value.Immutable
abstract class AbstractImageSource {
  /*
   * from is a reference to an ImageStreamTag, ImageStreamImage, or DockerImage to
   * copy source from.
   */
  @JsonProperty("from")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getFrom();

  /*
   * paths is a list of source and destination paths to copy from the image.
   */
  @JsonProperty("paths")
  public abstract java.util.List<io.fabric8.openshift.types.build.v1.ImageSourcePath> getPaths();

  /*
   * pullSecret is a reference to a secret to be used to pull the image from a registry
   * If the image is pulled from the OpenShift registry, this field does not need to be set.
   */
  @JsonProperty("pullSecret")
  public abstract io.fabric8.kubernetes.types.api.v1.LocalObjectReference getPullSecret();

}
