package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ImageSourcePath describes a path to be copied from a source image and its destination within the build directory.
 */
@Value.Immutable
abstract class AbstractImageSourcePath {
  /*
   * sourcePath is the absolute path of the file or directory inside the image to
   * copy to the build directory.
   */
  @JsonProperty("sourcePath")
  public abstract String getSourcePath();

  /*
   * destinationDir is the relative directory within the build directory
   * where files copied from the image are placed.
   */
  @JsonProperty("destinationDir")
  public abstract String getDestinationDir();

}
