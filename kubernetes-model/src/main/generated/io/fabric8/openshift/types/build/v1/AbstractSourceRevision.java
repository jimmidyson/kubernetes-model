package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SourceRevision is the revision or commit information from the source for the build
 */
@Value.Immutable
abstract class AbstractSourceRevision {
  /*
   * type of the build source, may be one of 'Source', 'Dockerfile', 'Binary', or 'Images'
   * +genconversion=false
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * Git contains information about git-based build source
   */
  @JsonProperty("git")
  public abstract io.fabric8.openshift.types.build.v1.GitSourceRevision getGit();

}
