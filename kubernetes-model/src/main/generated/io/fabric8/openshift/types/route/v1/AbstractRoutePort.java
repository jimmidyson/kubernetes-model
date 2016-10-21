package io.fabric8.openshift.types.route.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * RoutePort defines a port mapping from a router to an endpoint in the service endpoints.
 */
@Value.Immutable
abstract class AbstractRoutePort {
  /*
   * The target port on pods selected by the service this route points to.
   * If this is a string, it will be looked up as a named port in the target
   * endpoints port list. Required
   */
  @JsonProperty("targetPort")
  public abstract io.fabric8.kubernetes.types.util.intstr.IntOrString getTargetPort();

}
