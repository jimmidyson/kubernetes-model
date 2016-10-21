package io.fabric8.openshift.types.route.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * RouteTargetReference specifies the target that resolve into endpoints. Only the 'Service'
 * kind is allowed. Use 'weight' field to emphasize one over others.
 */
@Value.Immutable
abstract class AbstractRouteTargetReference {
  /*
   * The kind of target that the route is referring to. Currently, only 'Service' is allowed
   */
  @JsonProperty("kind")
  public abstract String getKind();

  /*
   * Name of the service/target that is being referred to. e.g. name of the service
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * Weight as an integer between 1 and 256 that specifies the target's relative weight
   * against other target reference objects
   */
  @JsonProperty("weight")
  public abstract Integer getWeight();

}
