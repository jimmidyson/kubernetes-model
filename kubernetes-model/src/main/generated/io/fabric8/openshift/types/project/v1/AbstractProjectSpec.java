package io.fabric8.openshift.types.project.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ProjectSpec describes the attributes on a Project
 */
@Value.Immutable
abstract class AbstractProjectSpec {
  /*
   * Finalizers is an opaque list of values that must be empty to permanently remove object from storage
   */
  @JsonProperty("finalizers")
  public abstract java.util.List<String> getFinalizers();

}
