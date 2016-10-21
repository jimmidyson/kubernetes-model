package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * BinaryBuildSource describes a binary file to be used for the Docker and Source build strategies,
 * where the file will be extracted and used as the build source.
 */
@Value.Immutable
abstract class AbstractBinaryBuildSource {
  /*
   * asFile indicates that the provided binary input should be considered a single file
   * within the build input. For example, specifying "webapp.war" would place the provided
   * binary as `/webapp.war` for the builder. If left empty, the Docker and Source build
   * strategies assume this file is a zip, tar, or tar.gz file and extract it as the source.
   * The custom strategy receives this binary as standard input. This filename may not
   * contain slashes or be '..' or '.'.
   */
  @JsonProperty("asFile")
  public abstract String getAsFile();

}
