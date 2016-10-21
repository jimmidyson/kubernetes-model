package io.fabric8.openshift.types.route.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * RouteSpec describes the route the user wishes to exist.
 */
@Value.Immutable
abstract class AbstractRouteSpec {
  /*
   * Host is an alias/DNS that points to the service. Optional
   * Must follow DNS952 subdomain conventions.
   */
  @JsonProperty("host")
  public abstract String getHost();

  /*
   * Path that the router watches for, to route traffic for to the service. Optional
   */
  @JsonProperty("path")
  public abstract String getPath();

  /*
   * To is an object the route points to. Only the Service kind is allowed, and it will
   * be defaulted to Service.
   */
  @JsonProperty("to")
  public abstract io.fabric8.openshift.types.route.v1.RouteTargetReference getTo();

  /*
   * AlternateBackends is an extension of the 'to' field. If more than one service needs to be
   * pointed to, then use this field. Use the weight field in RouteTargetReference object
   * to specify relative preference
   */
  @JsonProperty("alternateBackends")
  public abstract java.util.List<io.fabric8.openshift.types.route.v1.RouteTargetReference> getAlternateBackends();

  /*
   * If specified, the port to be used by the router. Most routers will use all
   * endpoints exposed by the service by default - set this value to instruct routers
   * which port to use.
   */
  @JsonProperty("port")
  public abstract io.fabric8.openshift.types.route.v1.RoutePort getPort();

  /*
   * TLS provides the ability to configure certificates and termination for the route
   */
  @JsonProperty("tls")
  public abstract io.fabric8.openshift.types.route.v1.TLSConfig getTls();

}
