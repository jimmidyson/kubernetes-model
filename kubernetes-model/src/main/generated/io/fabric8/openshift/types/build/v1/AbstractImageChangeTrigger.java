package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ImageChangeTrigger allows builds to be triggered when an ImageStream changes
 */
@Value.Immutable
abstract class AbstractImageChangeTrigger {
  /*
   * lastTriggeredImageID is used internally by the ImageChangeController to save last
   * used image ID for build
   */
  @JsonProperty("lastTriggeredImageID")
  public abstract String getLastTriggeredImageID();

  /*
   * from is a reference to an ImageStreamTag that will trigger a build when updated
   * It is optional. If no From is specified, the From image from the build strategy
   * will be used. Only one ImageChangeTrigger with an empty From reference is allowed in
   * a build configuration.
   */
  @JsonProperty("from")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getFrom();

}
