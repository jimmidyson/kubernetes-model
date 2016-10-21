package io.fabric8.openshift.types.authorization.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PolicyBinding is a object that holds all the RoleBindings for a particular namespace.  There is
 * one PolicyBinding document per referenced Policy namespace
 */
@Value.Immutable
abstract class AbstractPolicyBinding implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("PolicyBinding", "v1");
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
   * LastModified is the last time that any part of the PolicyBinding was created, updated, or deleted
   */
  @JsonProperty("lastModified")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getLastModified();

  /*
   * PolicyRef is a reference to the Policy that contains all the Roles that this PolicyBinding's RoleBindings may reference
   */
  @JsonProperty("policyRef")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getPolicyRef();

  /*
   * RoleBindings holds all the RoleBindings held by this PolicyBinding, mapped by RoleBinding.Name
   */
  @JsonProperty("roleBindings")
  public abstract java.util.List<io.fabric8.openshift.types.authorization.v1.NamedRoleBinding> getRoleBindings();

}
