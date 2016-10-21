package io.fabric8.openshift.types.oauth.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ClusterRoleScopeRestriction describes restrictions on cluster role scopes
 */
@Value.Immutable
abstract class AbstractClusterRoleScopeRestriction {
  /*
   * RoleNames is the list of cluster roles that can referenced.  * means anything
   */
  @JsonProperty("roleNames")
  public abstract java.util.List<String> getRoleNames();

  /*
   * Namespaces is the list of namespaces that can be referenced.  * means any of them (including *)
   */
  @JsonProperty("namespaces")
  public abstract java.util.List<String> getNamespaces();

  /*
   * AllowEscalation indicates whether you can request roles and their escalating resources
   */
  @JsonProperty("allowEscalation")
  public abstract Boolean isAllowEscalation();

}
