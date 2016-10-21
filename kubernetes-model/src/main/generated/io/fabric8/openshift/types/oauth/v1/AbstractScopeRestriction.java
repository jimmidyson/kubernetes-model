package io.fabric8.openshift.types.oauth.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ScopeRestriction describe one restriction on scopes.  Exactly one option must be non-nil.
 */
@Value.Immutable
abstract class AbstractScopeRestriction {
  /*
   * ExactValues means the scope has to match a particular set of strings exactly
   */
  @JsonProperty("literals")
  public abstract java.util.List<String> getLiterals();

  /*
   * ClusterRole describes a set of restrictions for cluster role scoping.
   */
  @JsonProperty("clusterRole")
  public abstract io.fabric8.openshift.types.oauth.v1.ClusterRoleScopeRestriction getClusterRole();

}
