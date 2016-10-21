package io.fabric8.openshift.types.authorization.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * NamedClusterRole relates a name with a cluster role
 */
@Value.Immutable
abstract class AbstractNamedClusterRole {
  /*
   * Name is the name of the cluster role
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * Role is the cluster role being named
   */
  @JsonProperty("role")
  public abstract io.fabric8.openshift.types.authorization.v1.ClusterRole getRole();

}
