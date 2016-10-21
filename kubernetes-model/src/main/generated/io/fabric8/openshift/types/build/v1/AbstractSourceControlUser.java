package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SourceControlUser defines the identity of a user of source control
 */
@Value.Immutable
abstract class AbstractSourceControlUser {
  /*
   * name of the source control user
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * email of the source control user
   */
  @JsonProperty("email")
  public abstract String getEmail();

}
