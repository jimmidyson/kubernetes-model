package io.fabric8.openshift.types.authorization.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * NamedRoleBinding relates a role binding with a name
 */
@Value.Immutable
abstract class AbstractNamedRoleBinding {
  /*
   * Name is the name of the role binding
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * RoleBinding is the role binding being named
   */
  @JsonProperty("roleBinding")
  public abstract io.fabric8.openshift.types.authorization.v1.RoleBinding getRoleBinding();

}
