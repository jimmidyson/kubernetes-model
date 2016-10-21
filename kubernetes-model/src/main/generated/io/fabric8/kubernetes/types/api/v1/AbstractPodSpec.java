package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PodSpec is a description of a pod.
 */
@Value.Immutable
abstract class AbstractPodSpec {
  /*
   * List of volumes that can be mounted by containers belonging to the pod.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/volumes.md
   */
  @JsonProperty("volumes")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.Volume> getVolumes();

  /*
   * List of containers belonging to the pod.
   * Containers cannot currently be added or removed.
   * There must be at least one container in a Pod.
   * Cannot be updated.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/containers.md
   */
  @JsonProperty("containers")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.Container> getContainers();

  /*
   * Restart policy for all containers within the pod.
   * One of Always, OnFailure, Never.
   * Default to Always.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/pod-states.md#restartpolicy
   */
  @JsonProperty("restartPolicy")
  public abstract String getRestartPolicy();

  /*
   * Optional duration in seconds the pod needs to terminate gracefully. May be decreased in delete request.
   * Value must be non-negative integer. The value zero indicates delete immediately.
   * If this value is nil, the default grace period will be used instead.
   * The grace period is the duration in seconds after the processes running in the pod are sent
   * a termination signal and the time when the processes are forcibly halted with a kill signal.
   * Set this value longer than the expected cleanup time for your process.
   * Defaults to 30 seconds.
   */
  @JsonProperty("terminationGracePeriodSeconds")
  public abstract Long getTerminationGracePeriodSeconds();

  /*
   * Optional duration in seconds the pod may be active on the node relative to
   * StartTime before the system will actively try to mark it failed and kill associated containers.
   * Value must be a positive integer.
   */
  @JsonProperty("activeDeadlineSeconds")
  public abstract Long getActiveDeadlineSeconds();

  /*
   * Set DNS policy for containers within the pod.
   * One of 'ClusterFirst' or 'Default'.
   * Defaults to "ClusterFirst".
   */
  @JsonProperty("dnsPolicy")
  public abstract String getDnsPolicy();

  /*
   * NodeSelector is a selector which must be true for the pod to fit on a node.
   * Selector which must match a node's labels for the pod to be scheduled on that node.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/node-selection/README.md
   */
  @JsonProperty("nodeSelector")
  public abstract java.util.Map<String, String> getNodeSelector();

  /*
   * A request to schedule this pod onto a specific node
   * Deprecated: Use nodeName instead.
   */
  @JsonProperty("host")
  public abstract String getHost();

  /*
   * ServiceAccountName is the name of the ServiceAccount to use to run this pod.
   * More info: http://releases.k8s.io/release-1.3/docs/design/service_accounts.md
   */
  @JsonProperty("serviceAccountName")
  public abstract String getServiceAccountName();

  /*
   * DeprecatedServiceAccount is a depreciated alias for ServiceAccountName.
   * Deprecated: Use serviceAccountName instead.
   */
  @JsonProperty("serviceAccount")
  public abstract String getServiceAccount();

  /*
   * NodeName is a request to schedule this pod onto a specific node. If it is non-empty,
   * the scheduler simply schedules this pod onto that node, assuming that it fits resource
   * requirements.
   */
  @JsonProperty("nodeName")
  public abstract String getNodeName();

  /*
   * Host networking requested for this pod. Use the host's network namespace.
   * If this option is set, the ports that will be used must be specified.
   * Default to false.
   */
  @JsonProperty("hostNetwork")
  public abstract Boolean isHostNetwork();

  /*
   * Use the host's pid namespace.
   * Optional: Default to false.
   */
  @JsonProperty("hostPID")
  public abstract Boolean isHostPID();

  /*
   * Use the host's ipc namespace.
   * Optional: Default to false.
   */
  @JsonProperty("hostIPC")
  public abstract Boolean isHostIPC();

  /*
   * SecurityContext holds pod-level security attributes and common container settings.
   * Optional: Defaults to empty.  See type description for default values of each field.
   */
  @JsonProperty("securityContext")
  public abstract io.fabric8.kubernetes.types.api.v1.PodSecurityContext getSecurityContext();

  /*
   * ImagePullSecrets is an optional list of references to secrets in the same namespace to use for pulling any of the images used by this PodSpec.
   * If specified, these secrets will be passed to individual puller implementations for them to use. For example,
   * in the case of docker, only DockerConfig type secrets are honored.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/images.md#specifying-imagepullsecrets-on-a-pod
   */
  @JsonProperty("imagePullSecrets")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.LocalObjectReference> getImagePullSecrets();

  /*
   * Specifies the hostname of the Pod
   * If not specified, the pod's hostname will be set to a system-defined value.
   */
  @JsonProperty("hostname")
  public abstract String getHostname();

  /*
   * If specified, the fully qualified Pod hostname will be "<hostname>.<subdomain>.<pod namespace>.svc.<cluster domain>".
   * If not specified, the pod will not have a domainname at all.
   */
  @JsonProperty("subdomain")
  public abstract String getSubdomain();

}
