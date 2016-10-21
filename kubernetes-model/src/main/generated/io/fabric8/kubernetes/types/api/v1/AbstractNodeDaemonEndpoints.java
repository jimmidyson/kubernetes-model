package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * NodeDaemonEndpoints lists ports opened by daemons running on the Node.
 */
@Value.Immutable
abstract class AbstractNodeDaemonEndpoints {
  /*
   * Endpoint on which Kubelet is listening.
   */
  @JsonProperty("kubeletEndpoint")
  public abstract io.fabric8.kubernetes.types.api.v1.DaemonEndpoint getKubeletEndpoint();

}
