package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * A single application container that you want to run within a pod.
 */
@Value.Immutable
abstract class AbstractContainer {
  /*
   * Name of the container specified as a DNS_LABEL.
   * Each container in a pod must have a unique name (DNS_LABEL).
   * Cannot be updated.
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * Docker image name.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/images.md
   */
  @JsonProperty("image")
  public abstract String getImage();

  /*
   * Entrypoint array. Not executed within a shell.
   * The docker image's ENTRYPOINT is used if this is not provided.
   * Variable references $(VAR_NAME) are expanded using the container's environment. If a variable
   * cannot be resolved, the reference in the input string will be unchanged. The $(VAR_NAME) syntax
   * can be escaped with a double $$, ie: $$(VAR_NAME). Escaped references will never be expanded,
   * regardless of whether the variable exists or not.
   * Cannot be updated.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/containers.md#containers-and-commands
   */
  @JsonProperty("command")
  public abstract java.util.List<String> getCommand();

  /*
   * Arguments to the entrypoint.
   * The docker image's CMD is used if this is not provided.
   * Variable references $(VAR_NAME) are expanded using the container's environment. If a variable
   * cannot be resolved, the reference in the input string will be unchanged. The $(VAR_NAME) syntax
   * can be escaped with a double $$, ie: $$(VAR_NAME). Escaped references will never be expanded,
   * regardless of whether the variable exists or not.
   * Cannot be updated.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/containers.md#containers-and-commands
   */
  @JsonProperty("args")
  public abstract java.util.List<String> getArgs();

  /*
   * Container's working directory.
   * If not specified, the container runtime's default will be used, which
   * might be configured in the container image.
   * Cannot be updated.
   */
  @JsonProperty("workingDir")
  public abstract String getWorkingDir();

  /*
   * List of ports to expose from the container. Exposing a port here gives
   * the system additional information about the network connections a
   * container uses, but is primarily informational. Not specifying a port here
   * DOES NOT prevent that port from being exposed. Any port which is
   * listening on the default "0.0.0.0" address inside a container will be
   * accessible from the network.
   * Cannot be updated.
   */
  @JsonProperty("ports")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.ContainerPort> getPorts();

  /*
   * List of environment variables to set in the container.
   * Cannot be updated.
   */
  @JsonProperty("env")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.EnvVar> getEnv();

  /*
   * Compute Resources required by this container.
   * Cannot be updated.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/persistent-volumes.md#resources
   */
  @JsonProperty("resources")
  public abstract io.fabric8.kubernetes.types.api.v1.ResourceRequirements getResources();

  /*
   * Pod volumes to mount into the container's filesystem.
   * Cannot be updated.
   */
  @JsonProperty("volumeMounts")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.VolumeMount> getVolumeMounts();

  /*
   * Periodic probe of container liveness.
   * Container will be restarted if the probe fails.
   * Cannot be updated.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/pod-states.md#container-probes
   */
  @JsonProperty("livenessProbe")
  public abstract io.fabric8.kubernetes.types.api.v1.Probe getLivenessProbe();

  /*
   * Periodic probe of container service readiness.
   * Container will be removed from service endpoints if the probe fails.
   * Cannot be updated.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/pod-states.md#container-probes
   */
  @JsonProperty("readinessProbe")
  public abstract io.fabric8.kubernetes.types.api.v1.Probe getReadinessProbe();

  /*
   * Actions that the management system should take in response to container lifecycle events.
   * Cannot be updated.
   */
  @JsonProperty("lifecycle")
  public abstract io.fabric8.kubernetes.types.api.v1.Lifecycle getLifecycle();

  /*
   * Optional: Path at which the file to which the container's termination message
   * will be written is mounted into the container's filesystem.
   * Message written is intended to be brief final status, such as an assertion failure message.
   * Defaults to /dev/termination-log.
   * Cannot be updated.
   */
  @JsonProperty("terminationMessagePath")
  public abstract String getTerminationMessagePath();

  /*
   * Image pull policy.
   * One of Always, Never, IfNotPresent.
   * Defaults to Always if :latest tag is specified, or IfNotPresent otherwise.
   * Cannot be updated.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/images.md#updating-images
   */
  @JsonProperty("imagePullPolicy")
  public abstract String getImagePullPolicy();

  /*
   * Security options the pod should run with.
   * More info: http://releases.k8s.io/release-1.3/docs/design/security_context.md
   */
  @JsonProperty("securityContext")
  public abstract io.fabric8.kubernetes.types.api.v1.SecurityContext getSecurityContext();

  /*
   * Whether this container should allocate a buffer for stdin in the container runtime. If this
   * is not set, reads from stdin in the container will always result in EOF.
   * Default is false.
   */
  @JsonProperty("stdin")
  public abstract Boolean isStdin();

  /*
   * Whether the container runtime should close the stdin channel after it has been opened by
   * a single attach. When stdin is true the stdin stream will remain open across multiple attach
   * sessions. If stdinOnce is set to true, stdin is opened on container start, is empty until the
   * first client attaches to stdin, and then remains open and accepts data until the client disconnects,
   * at which time stdin is closed and remains closed until the container is restarted. If this
   * flag is false, a container processes that reads from stdin will never receive an EOF.
   * Default is false
   */
  @JsonProperty("stdinOnce")
  public abstract Boolean isStdinOnce();

  /*
   * Whether this container should allocate a TTY for itself, also requires 'stdin' to be true.
   * Default is false.
   */
  @JsonProperty("tty")
  public abstract Boolean isTty();

}
