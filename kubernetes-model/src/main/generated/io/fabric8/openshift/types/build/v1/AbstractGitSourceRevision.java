package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * GitSourceRevision is the commit information from a git source for a build
 */
@Value.Immutable
abstract class AbstractGitSourceRevision {
  /*
   * commit is the commit hash identifying a specific commit
   */
  @JsonProperty("commit")
  public abstract String getCommit();

  /*
   * author is the author of a specific commit
   */
  @JsonProperty("author")
  public abstract io.fabric8.openshift.types.build.v1.SourceControlUser getAuthor();

  /*
   * committer is the committer of a specific commit
   */
  @JsonProperty("committer")
  public abstract io.fabric8.openshift.types.build.v1.SourceControlUser getCommitter();

  /*
   * message is the description of a specific commit
   */
  @JsonProperty("message")
  public abstract String getMessage();

}
