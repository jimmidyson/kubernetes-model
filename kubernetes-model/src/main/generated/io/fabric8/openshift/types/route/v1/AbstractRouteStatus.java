package io.fabric8.openshift.types.route.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * RouteStatus provides relevant info about the status of a route, including which routers
 * acknowledge it.
 */
@Value.Immutable
abstract class AbstractRouteStatus {
  /*
   * Ingress describes the places where the route may be exposed. The list of
   * ingress points may contain duplicate Host or RouterName values. Routes
   * are considered live once they are `Ready`
   */
  @JsonProperty("ingress")
  public abstract java.util.List<io.fabric8.openshift.types.route.v1.RouteIngress> getIngress();

}
