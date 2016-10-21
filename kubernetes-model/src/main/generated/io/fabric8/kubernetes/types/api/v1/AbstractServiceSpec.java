package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ServiceSpec describes the attributes that a user creates on a service.
 */
@Value.Immutable
abstract class AbstractServiceSpec {
  /*
   * The list of ports that are exposed by this service.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/services.md#virtual-ips-and-service-proxies
   */
  @JsonProperty("ports")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.ServicePort> getPorts();

  /*
   * This service will route traffic to pods having labels matching this selector.
   * Label keys and values that must match in order to receive traffic for this service.
   * If empty, all pods are selected, if not specified, endpoints must be manually specified.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/services.md#overview
   */
  @JsonProperty("selector")
  public abstract java.util.Map<String, String> getSelector();

  /*
   * The IP Address of the service.
   * Deprecated: Use clusterIP instead.
   * +genconversion=false
   */
  @JsonProperty("portalIP")
  public abstract String getPortalIP();

  /*
   * ClusterIP is usually assigned by the master and is the IP address of the service.
   * If specified, it will be allocated to the service if it is unused
   * or else creation of the service will fail.
   * Valid values are None, empty string (""), or a valid IP address.
   * 'None' can be specified for a headless service when proxying is not required.
   * Cannot be updated.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/services.md#virtual-ips-and-service-proxies
   */
  @JsonProperty("clusterIP")
  public abstract String getClusterIP();

  /*
   * Type of exposed service. Must be ClusterIP, NodePort, or LoadBalancer.
   * Defaults to ClusterIP.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/services.md#external-services
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * externalIPs is a list of IP addresses for which nodes in the cluster
   * will also accept traffic for this service.  These IPs are not managed by
   * Kubernetes.  The user is responsible for ensuring that traffic arrives
   * at a node with this IP.  A common example is external load-balancers
   * that are not part of the Kubernetes system.  A previous form of this
   * functionality exists as the deprecatedPublicIPs field.  When using this
   * field, callers should also clear the deprecatedPublicIPs field.
   */
  @JsonProperty("externalIPs")
  public abstract java.util.List<String> getExternalIPs();

  /*
   * deprecatedPublicIPs is deprecated and replaced by the externalIPs field
   * with almost the exact same semantics.  This field is retained in the v1
   * API for compatibility until at least 8/20/2016.  It will be removed from
   * any new API revisions.  If both deprecatedPublicIPs *and* externalIPs are
   * set, deprecatedPublicIPs is used.
   * +genconversion=false
   */
  @JsonProperty("deprecatedPublicIPs")
  public abstract java.util.List<String> getDeprecatedPublicIPs();

  /*
   * Supports "ClientIP" and "None". Used to maintain session affinity.
   * Enable client IP based session affinity.
   * Must be ClientIP or None.
   * Defaults to None.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/services.md#virtual-ips-and-service-proxies
   */
  @JsonProperty("sessionAffinity")
  public abstract String getSessionAffinity();

  /*
   * Only applies to Service Type: LoadBalancer
   * LoadBalancer will get created with the IP specified in this field.
   * This feature depends on whether the underlying cloud-provider supports specifying
   * the loadBalancerIP when a load balancer is created.
   * This field will be ignored if the cloud-provider does not support the feature.
   */
  @JsonProperty("loadBalancerIP")
  public abstract String getLoadBalancerIP();

  /*
   * If specified and supported by the platform, this will restrict traffic through the cloud-provider
   * load-balancer will be restricted to the specified client IPs. This field will be ignored if the
   * cloud-provider does not support the feature."
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/services-firewalls.md
   */
  @JsonProperty("loadBalancerSourceRanges")
  public abstract java.util.List<String> getLoadBalancerSourceRanges();

}
