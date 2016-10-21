package io.fabric8.openshift.types.authorization.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * RoleBinding references a Role, but not contain it.  It can reference any Role in the same namespace or in the global namespace.
 * It adds who information via Users and Groups and namespace information by which namespace it exists in.  RoleBindings in a given
 * namespace only have effect in that namespace (excepting the master namespace which has power in all namespaces).
 */
@Value.Immutable
abstract class AbstractRoleBinding implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("RoleBinding", "v1");
  }

  @Value.Derived
  public String getApiVersion() {
    return getTypeMeta().getApiVersion();
  }

  @Value.Derived
  public String getKind() {
    return getTypeMeta().getKind();
  }

  /*
   * Standard object's metadata.
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * UserNames holds all the usernames directly bound to the role
   * +genconversion=false
   */
  @JsonProperty("userNames")
  public abstract java.util.List<String> getUserNames();

  /*
   * GroupNames holds all the groups directly bound to the role
   * +genconversion=false
   */
  @JsonProperty("groupNames")
  public abstract java.util.List<String> getGroupNames();

  /*
   * Subjects hold object references to authorize with this rule
   */
  @JsonProperty("subjects")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.ObjectReference> getSubjects();

  /*
   * RoleRef can only reference the current namespace and the global namespace
   * If the RoleRef cannot be resolved, the Authorizer must return an error.
   * Since Policy is a singleton, this is sufficient knowledge to locate a role
   */
  @JsonProperty("roleRef")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getRoleRef();

}
