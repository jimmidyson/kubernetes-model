package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * BuildSpec has the information to represent a build and also additional
 * information about a build
 */
@Value.Immutable
abstract class AbstractBuildSpec {
  /*
   * CommonSpec is the information that represents a build
   */
  @JsonUnwrapped
  public abstract io.fabric8.openshift.types.build.v1.CommonSpec getCommonSpec();

  /*
   * triggeredBy describes which triggers started the most recent update to the
   * build configuration and contains information about those triggers.
   */
  @JsonProperty("triggeredBy")
  public abstract java.util.List<io.fabric8.openshift.types.build.v1.BuildTriggerCause> getTriggeredBy();

}
