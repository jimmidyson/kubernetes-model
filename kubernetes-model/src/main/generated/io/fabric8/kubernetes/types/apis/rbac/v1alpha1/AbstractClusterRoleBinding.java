package io.fabric8.kubernetes.types.apis.rbac.v1alpha1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ClusterRoleBinding references a ClusterRole, but not contain it.  It can reference a ClusterRole in the global namespace,
 * and adds who information via Subject.
 */
@Value.Immutable
abstract class AbstractClusterRoleBinding implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ClusterRoleBinding", "rbac/v1alpha1");
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
   * RoleRef can only reference a ClusterRole in the global namespace.
   * If the RoleRef cannot be resolved, the Authorizer must return an error.
   */
  @JsonProperty("roleRef")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getRoleRef();

}
