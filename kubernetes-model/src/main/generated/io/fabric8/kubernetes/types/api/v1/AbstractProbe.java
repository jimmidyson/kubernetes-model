package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Probe describes a health check to be performed against a container to determine whether it is
 * alive or ready to receive traffic.
 */
@Value.Immutable
abstract class AbstractProbe {
  /*
   * The action taken to determine the health of a container
   */
  @JsonUnwrapped
  public abstract io.fabric8.kubernetes.types.api.v1.Handler getHandler();

  /*
   * Number of seconds after the container has started before liveness probes are initiated.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/pod-states.md#container-probes
   */
  @JsonProperty("initialDelaySeconds")
  public abstract Integer getInitialDelaySeconds();

  /*
   * Number of seconds after which the probe times out.
   * Defaults to 1 second. Minimum value is 1.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/pod-states.md#container-probes
   */
  @JsonProperty("timeoutSeconds")
  public abstract Integer getTimeoutSeconds();

  /*
   * How often (in seconds) to perform the probe.
   * Default to 10 seconds. Minimum value is 1.
   */
  @JsonProperty("periodSeconds")
  public abstract Integer getPeriodSeconds();

  /*
   * Minimum consecutive successes for the probe to be considered successful after having failed.
   * Defaults to 1. Must be 1 for liveness. Minimum value is 1.
   */
  @JsonProperty("successThreshold")
  public abstract Integer getSuccessThreshold();

  /*
   * Minimum consecutive failures for the probe to be considered failed after having succeeded.
   * Defaults to 3. Minimum value is 1.
   */
  @JsonProperty("failureThreshold")
  public abstract Integer getFailureThreshold();

}
