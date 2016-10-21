package io.fabric8.openshift.types.project.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ProjectStatus is information about the current status of a Project
 */
@Value.Immutable
abstract class AbstractProjectStatus {
  /*
   * Phase is the current lifecycle phase of the project
   */
  @JsonProperty("phase")
  public abstract String getPhase();

}
