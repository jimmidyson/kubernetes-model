package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * IngressBackend describes all endpoints for a given service and port.
 */
@Value.Immutable
abstract class AbstractIngressBackend {
  /*
   * Specifies the name of the referenced service.
   */
  @JsonProperty("serviceName")
  public abstract String getServiceName();

  /*
   * Specifies the port of the referenced service.
   */
  @JsonProperty("servicePort")
  public abstract io.fabric8.kubernetes.types.util.intstr.IntOrString getServicePort();

}
