package io.fabric8.openshift.types.route.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * TLSConfig defines config used to secure a route and provide termination
 */
@Value.Immutable
abstract class AbstractTLSConfig {
  /*
   * Termination indicates termination type.
   */
  @JsonProperty("termination")
  public abstract String getTermination();

  /*
   * Certificate provides certificate contents
   */
  @JsonProperty("certificate")
  public abstract String getCertificate();

  /*
   * Key provides key file contents
   */
  @JsonProperty("key")
  public abstract String getKey();

  /*
   * CACertificate provides the cert authority certificate contents
   */
  @JsonProperty("caCertificate")
  public abstract String getCaCertificate();

  /*
   * DestinationCACertificate provides the contents of the ca certificate of the final destination.  When using reencrypt
   * termination this file should be provided in order to have routers use it for health checks on the secure connection
   */
  @JsonProperty("destinationCACertificate")
  public abstract String getDestinationCACertificate();

  /*
   * InsecureEdgeTerminationPolicy indicates the desired behavior for
   * insecure connections to an edge-terminated route:
   *   disable, allow or redirect
   */
  @JsonProperty("insecureEdgeTerminationPolicy")
  public abstract String getInsecureEdgeTerminationPolicy();

}
