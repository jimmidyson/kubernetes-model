package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * BuildTriggerPolicy describes a policy for a single trigger that results in a new Build.
 */
@Value.Immutable
abstract class AbstractBuildTriggerPolicy {
  /*
   * type is the type of build trigger
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * github contains the parameters for a GitHub webhook type of trigger
   */
  @JsonProperty("github")
  public abstract io.fabric8.openshift.types.build.v1.WebHookTrigger getGithub();

  /*
   * generic contains the parameters for a Generic webhook type of trigger
   */
  @JsonProperty("generic")
  public abstract io.fabric8.openshift.types.build.v1.WebHookTrigger getGeneric();

  /*
   * imageChange contains parameters for an ImageChange type of trigger
   */
  @JsonProperty("imageChange")
  public abstract io.fabric8.openshift.types.build.v1.ImageChangeTrigger getImageChange();

}
