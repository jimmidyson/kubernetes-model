package io.fabric8.kubernetes.types.apis.autoscaling.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * CrossVersionObjectReference contains enough information to let you identify the referred resource.
 */
@Value.Immutable
abstract class AbstractCrossVersionObjectReference {
  /*
   * Kind of the referent; More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#types-kinds"
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

}
