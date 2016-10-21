package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SubresourceReference contains enough information to let you inspect or modify the referred subresource.
 */
@Value.Immutable
abstract class AbstractSubresourceReference {
  /*
   * Kind of the referent; More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  public abstract String getKind();

  /*
   * Name of the referent; More info: http://releases.k8s.io/release-1.3/docs/user-guide/identifiers.md#names
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * API version of the referent
   */
  @JsonProperty("apiVersion")
  public abstract String getApiVersion();

  /*
   * Subresource name of the referent
   */
  @JsonProperty("subresource")
  public abstract String getSubresource();

}
