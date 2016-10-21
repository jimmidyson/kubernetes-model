package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;


@Value.Immutable
abstract class AbstractNetworkPolicyPort {
  /*
   * Optional.  The protocol (TCP or UDP) which traffic must match.
   * If not specified, this field defaults to TCP.
   */
  @JsonProperty("protocol")
  public abstract String getProtocol();

  /*
   * If specified, the port on the given protocol.  This can
   * either be a numerical or named port on a pod.  If this field is not provided,
   * this matches all port names and numbers.
   * If present, only traffic on the specified protocol AND port
   * will be matched.
   */
  @JsonProperty("port")
  public abstract io.fabric8.kubernetes.types.util.intstr.IntOrString getPort();

}
