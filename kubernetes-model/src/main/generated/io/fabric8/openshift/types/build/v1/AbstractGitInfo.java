package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * GitInfo is the aggregated git information for a generic webhook post
 */
@Value.Immutable
abstract class AbstractGitInfo {

  @JsonUnwrapped
  public abstract io.fabric8.openshift.types.build.v1.GitBuildSource getGitBuildSource();


  @JsonUnwrapped
  public abstract io.fabric8.openshift.types.build.v1.GitSourceRevision getGitSourceRevision();

}
