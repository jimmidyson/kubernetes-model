package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * BuildConfigStatus contains current state of the build config object.
 */
@Value.Immutable
abstract class AbstractBuildConfigStatus {
  /*
   * lastVersion is used to inform about number of last triggered build.
   */
  @JsonProperty("lastVersion")
  public abstract Long getLastVersion();

}
