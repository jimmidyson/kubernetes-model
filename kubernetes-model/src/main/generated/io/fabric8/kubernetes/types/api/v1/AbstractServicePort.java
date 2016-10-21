package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ServicePort contains information on service's port.
 */
@Value.Immutable
abstract class AbstractServicePort {
  /*
   * The name of this port within the service. This must be a DNS_LABEL.
   * All ports within a ServiceSpec must have unique names. This maps to
   * the 'Name' field in EndpointPort objects.
   * Optional if only one ServicePort is defined on this service.
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * The IP protocol for this port. Supports "TCP" and "UDP".
   * Default is TCP.
   */
  @JsonProperty("protocol")
  public abstract String getProtocol();

  /*
   * The port that will be exposed by this service.
   */
  @JsonProperty("port")
  public abstract Integer getPort();

  /*
   * Number or name of the port to access on the pods targeted by the service.
   * Number must be in the range 1 to 65535. Name must be an IANA_SVC_NAME.
   * If this is a string, it will be looked up as a named port in the
   * target Pod's container ports. If this is not specified, the value
   * of the 'port' field is used (an identity map).
   * This field is ignored for services with clusterIP=None, and should be
   * omitted or set equal to the 'port' field.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/services.md#defining-a-service
   */
  @JsonProperty("targetPort")
  public abstract io.fabric8.kubernetes.types.util.intstr.IntOrString getTargetPort();

  /*
   * The port on each node on which this service is exposed when type=NodePort or LoadBalancer.
   * Usually assigned by the system. If specified, it will be allocated to the service
   * if unused or else creation of the service will fail.
   * Default is to auto-allocate a port if the ServiceType of this Service requires one.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/services.md#type--nodeport
   */
  @JsonProperty("nodePort")
  public abstract Integer getNodePort();

}
