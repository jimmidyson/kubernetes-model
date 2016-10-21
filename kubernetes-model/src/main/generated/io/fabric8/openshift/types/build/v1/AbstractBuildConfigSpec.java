package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * BuildConfigSpec describes when and how builds are created
 */
@Value.Immutable
abstract class AbstractBuildConfigSpec {
  /*
   * triggers determine how new Builds can be launched from a BuildConfig. If
   * no triggers are defined, a new build can only occur as a result of an
   * explicit client build creation.
   */
  @JsonProperty("triggers")
  public abstract java.util.List<io.fabric8.openshift.types.build.v1.BuildTriggerPolicy> getTriggers();

  /*
   * RunPolicy describes how the new build created from this build
   * configuration will be scheduled for execution.
   * This is optional, if not specified we default to "Serial".
   */
  @JsonProperty("runPolicy")
  public abstract String getRunPolicy();

  /*
   * CommonSpec is the desired build specification
   */
  @JsonUnwrapped
  public abstract io.fabric8.openshift.types.build.v1.CommonSpec getCommonSpec();

}
