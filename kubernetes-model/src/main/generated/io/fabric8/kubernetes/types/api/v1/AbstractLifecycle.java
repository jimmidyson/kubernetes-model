package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Lifecycle describes actions that the management system should take in response to container lifecycle
 * events. For the PostStart and PreStop lifecycle handlers, management of the container blocks
 * until the action is complete, unless the container process fails, in which case the handler is aborted.
 */
@Value.Immutable
abstract class AbstractLifecycle {
  /*
   * PostStart is called immediately after a container is created. If the handler fails,
   * the container is terminated and restarted according to its restart policy.
   * Other management of the container blocks until the hook completes.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/container-environment.md#hook-details
   */
  @JsonProperty("postStart")
  public abstract io.fabric8.kubernetes.types.api.v1.Handler getPostStart();

  /*
   * PreStop is called immediately before a container is terminated.
   * The container is terminated after the handler completes.
   * The reason for termination is passed to the handler.
   * Regardless of the outcome of the handler, the container is eventually terminated.
   * Other management of the container blocks until the hook completes.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/container-environment.md#hook-details
   */
  @JsonProperty("preStop")
  public abstract io.fabric8.kubernetes.types.api.v1.Handler getPreStop();

}
