package io.fabric8.openshift.types.authorization.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * NamedClusterRoleBinding relates a name with a cluster role binding
 */
@Value.Immutable
abstract class AbstractNamedClusterRoleBinding {
  /*
   * Name is the name of the cluster role binding
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * RoleBinding is the cluster role binding being named
   */
  @JsonProperty("roleBinding")
  public abstract io.fabric8.openshift.types.authorization.v1.ClusterRoleBinding getRoleBinding();

}
