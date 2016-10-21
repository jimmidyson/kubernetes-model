package io.fabric8.kubernetes.types.apis.rbac.v1alpha1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * RoleBinding references a role, but does not contain it.  It can reference a Role in the same namespace or a ClusterRole in the global namespace.
 * It adds who information via Subjects and namespace information by which namespace it exists in.  RoleBindings in a given
 * namespace only have effect in that namespace.
 */
@Value.Immutable
abstract class AbstractRoleBinding implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("RoleBinding", "rbac/v1alpha1");
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
   * Subjects holds references to the objects the role applies to.
   */
  @JsonProperty("subjects")
  public abstract java.util.List<io.fabric8.kubernetes.types.apis.rbac.v1alpha1.Subject> getSubjects();

  /*
   * RoleRef can reference a Role in the current namespace or a ClusterRole in the global namespace.
   * If the RoleRef cannot be resolved, the Authorizer must return an error.
   */
  @JsonProperty("roleRef")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getRoleRef();

}
