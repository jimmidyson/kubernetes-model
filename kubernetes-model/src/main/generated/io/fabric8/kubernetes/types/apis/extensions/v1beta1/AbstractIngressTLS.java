package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * IngressTLS describes the transport layer security associated with an Ingress.
 */
@Value.Immutable
abstract class AbstractIngressTLS {
  /*
   * Hosts are a list of hosts included in the TLS certificate. The values in
   * this list must match the name/s used in the tlsSecret. Defaults to the
   * wildcard host setting for the loadbalancer controller fulfilling this
   * Ingress, if left unspecified.
   */
  @JsonProperty("hosts")
  public abstract java.util.List<String> getHosts();

  /*
   * SecretName is the name of the secret used to terminate SSL traffic on 443.
   * Field is left optional to allow SSL routing based on SNI hostname alone.
   * If the SNI host in a listener conflicts with the "Host" header field used
   * by an IngressRule, the SNI host is used for termination and value of the
   * Host header is used for routing.
   */
  @JsonProperty("secretName")
  public abstract String getSecretName();

}
