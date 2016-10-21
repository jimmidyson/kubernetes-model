package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SELinuxOptions are the labels to be applied to the container
 */
@Value.Immutable
abstract class AbstractSELinuxOptions {
  /*
   * User is a SELinux user label that applies to the container.
   */
  @JsonProperty("user")
  public abstract String getUser();

  /*
   * Role is a SELinux role label that applies to the container.
   */
  @JsonProperty("role")
  public abstract String getRole();

  /*
   * Type is a SELinux type label that applies to the container.
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * Level is SELinux level label that applies to the container.
   */
  @JsonProperty("level")
  public abstract String getLevel();

}
