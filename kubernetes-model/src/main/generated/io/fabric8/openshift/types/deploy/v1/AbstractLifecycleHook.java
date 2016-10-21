package io.fabric8.openshift.types.deploy.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * LifecycleHook defines a specific deployment lifecycle action. Only one type of action may be specified at any time.
 */
@Value.Immutable
abstract class AbstractLifecycleHook {
  /*
   * FailurePolicy specifies what action to take if the hook fails.
   */
  @JsonProperty("failurePolicy")
  public abstract String getFailurePolicy();

  /*
   * ExecNewPod specifies the options for a lifecycle hook backed by a pod.
   */
  @JsonProperty("execNewPod")
  public abstract io.fabric8.openshift.types.deploy.v1.ExecNewPodHook getExecNewPod();

  /*
   * TagImages instructs the deployer to tag the current image referenced under a container onto an image stream tag.
   */
  @JsonProperty("tagImages")
  public abstract java.util.List<io.fabric8.openshift.types.deploy.v1.TagImageHook> getTagImages();

}
