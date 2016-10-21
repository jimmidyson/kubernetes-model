package io.fabric8.openshift.types.route.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * RouteIngress holds information about the places where a route is exposed
 */
@Value.Immutable
abstract class AbstractRouteIngress {
  /*
   * Host is the host string under which the route is exposed; this value is required
   */
  @JsonProperty("host")
  public abstract String getHost();

  /*
   * Name is a name chosen by the router to identify itself; this value is required
   */
  @JsonProperty("routerName")
  public abstract String getRouterName();

  /*
   * Conditions is the state of the route, may be empty.
   */
  @JsonProperty("conditions")
  public abstract java.util.List<io.fabric8.openshift.types.route.v1.RouteIngressCondition> getConditions();

}
