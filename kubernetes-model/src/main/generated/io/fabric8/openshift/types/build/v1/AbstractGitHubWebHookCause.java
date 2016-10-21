package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * GitHubWebHookCause has information about a GitHub webhook that triggered a
 * build.
 */
@Value.Immutable
abstract class AbstractGitHubWebHookCause {
  /*
   * revision is the git revision information of the trigger.
   */
  @JsonProperty("revision")
  public abstract io.fabric8.openshift.types.build.v1.SourceRevision getRevision();

  /*
   * secret is the obfuscated webhook secret that triggered a build.
   */
  @JsonProperty("secret")
  public abstract String getSecret();

}
