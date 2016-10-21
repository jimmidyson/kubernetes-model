package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * BuildTriggerCause holds information about a triggered build. It is used for
 * displaying build trigger data for each build and build configuration in oc
 * describe. It is also used to describe which triggers led to the most recent
 * update in the build configuration.
 */
@Value.Immutable
abstract class AbstractBuildTriggerCause {
  /*
   * message is used to store a human readable message for why the build was
   * triggered. E.g.: "Manually triggered by user", "Configuration change",etc.
   */
  @JsonProperty("message")
  public abstract String getMessage();

  /*
   * genericWebHook holds data about a builds generic webhook trigger.
   */
  @JsonProperty("genericWebHook")
  public abstract io.fabric8.openshift.types.build.v1.GenericWebHookCause getGenericWebHook();

  /*
   * gitHubWebHook represents data for a GitHub webhook that fired a
   * specific build.
   */
  @JsonProperty("githubWebHook")
  public abstract io.fabric8.openshift.types.build.v1.GitHubWebHookCause getGithubWebHook();

  /*
   * imageChangeBuild stores information about an imagechange event
   * that triggered a new build.
   */
  @JsonProperty("imageChangeBuild")
  public abstract io.fabric8.openshift.types.build.v1.ImageChangeCause getImageChangeBuild();

}
