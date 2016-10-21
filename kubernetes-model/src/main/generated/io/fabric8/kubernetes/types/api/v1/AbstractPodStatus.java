package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PodStatus represents information about the status of a pod. Status may trail the actual
 * state of a system.
 */
@Value.Immutable
abstract class AbstractPodStatus {
  /*
   * Current condition of the pod.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/pod-states.md#pod-phase
   */
  @JsonProperty("phase")
  public abstract String getPhase();

  /*
   * Current service state of pod.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/pod-states.md#pod-conditions
   */
  @JsonProperty("conditions")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.PodCondition> getConditions();

  /*
   * A human readable message indicating details about why the pod is in this condition.
   */
  @JsonProperty("message")
  public abstract String getMessage();

  /*
   * A brief CamelCase message indicating details about why the pod is in this state.
   * e.g. 'OutOfDisk'
   */
  @JsonProperty("reason")
  public abstract String getReason();

  /*
   * IP address of the host to which the pod is assigned. Empty if not yet scheduled.
   */
  @JsonProperty("hostIP")
  public abstract String getHostIP();

  /*
   * IP address allocated to the pod. Routable at least within the cluster.
   * Empty if not yet allocated.
   */
  @JsonProperty("podIP")
  public abstract String getPodIP();

  /*
   * RFC 3339 date and time at which the object was acknowledged by the Kubelet.
   * This is before the Kubelet pulled the container image(s) for the pod.
   */
  @JsonProperty("startTime")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getStartTime();

  /*
   * The list has one entry per container in the manifest. Each entry is currently the output
   * of `docker inspect`.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/pod-states.md#container-statuses
   */
  @JsonProperty("containerStatuses")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.ContainerStatus> getContainerStatuses();

}
