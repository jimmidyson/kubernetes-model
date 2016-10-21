package io.fabric8.kubernetes.types.apis.rbac.v1alpha1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Subject contains a reference to the object or user identities a role binding applies to.  This can either hold a direct API object reference,
 * or a value for non-objects such as user and group names.
 */
@Value.Immutable
abstract class AbstractSubject {
  /*
   * Kind of object being referenced. Values defined by this API group are "User", "Group", and "ServiceAccount".
   * If the Authorizer does not recognized the kind value, the Authorizer should report an error.
   */
  @JsonProperty("kind")
  public abstract String getKind();

  /*
   * APIVersion holds the API group and version of the referenced object.
   */
  @JsonProperty("apiVersion")
  public abstract String getApiVersion();

  /*
   * Name of the object being referenced.
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * Namespace of the referenced object.  If the object kind is non-namespace, such as "User" or "Group", and this value is not empty
   * the Authorizer should report an error.
   */
  @JsonProperty("namespace")
  public abstract String getNamespace();

}
