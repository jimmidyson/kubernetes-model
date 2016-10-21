package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * OwnerReference contains enough information to let you identify an owning
 * object. Currently, an owning object must be in the same namespace, so there
 * is no namespace field.
 */
@Value.Immutable
abstract class AbstractOwnerReference {
  /*
   * API version of the referent.
   */
  @JsonProperty("apiVersion")
  public abstract String getApiVersion();

  /*
   * Kind of the referent.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  public abstract String getKind();

  /*
   * Name of the referent.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/identifiers.md#names
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * UID of the referent.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/identifiers.md#uids
   */
  @JsonProperty("uid")
  public abstract String getUid();

  /*
   * If true, this reference points to the managing controller.
   */
  @JsonProperty("controller")
  public abstract Boolean isController();

}
