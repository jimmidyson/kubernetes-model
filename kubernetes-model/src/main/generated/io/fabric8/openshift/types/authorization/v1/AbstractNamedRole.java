package io.fabric8.openshift.types.authorization.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * NamedRole relates a Role with a name
 */
@Value.Immutable
abstract class AbstractNamedRole {
  /*
   * Name is the name of the role
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * Role is the role being named
   */
  @JsonProperty("role")
  public abstract io.fabric8.openshift.types.authorization.v1.Role getRole();

}
