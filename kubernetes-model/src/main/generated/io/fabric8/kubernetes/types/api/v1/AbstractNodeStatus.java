package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * NodeStatus is information about the current status of a node.
 */
@Value.Immutable
abstract class AbstractNodeStatus {
  /*
   * Capacity represents the total resources of a node.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/persistent-volumes.md#capacity for more details.
   */
  @JsonProperty("capacity")
  public abstract java.util.Map<String, io.fabric8.kubernetes.types.api.resource.Quantity> getCapacity();

  /*
   * Allocatable represents the resources of a node that are available for scheduling.
   * Defaults to Capacity.
   */
  @JsonProperty("allocatable")
  public abstract java.util.Map<String, io.fabric8.kubernetes.types.api.resource.Quantity> getAllocatable();

  /*
   * NodePhase is the recently observed lifecycle phase of the node.
   * More info: http://releases.k8s.io/release-1.3/docs/admin/node.md#node-phase
   */
  @JsonProperty("phase")
  public abstract String getPhase();

  /*
   * Conditions is an array of current observed node conditions.
   * More info: http://releases.k8s.io/release-1.3/docs/admin/node.md#node-condition
   */
  @JsonProperty("conditions")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.NodeCondition> getConditions();

  /*
   * List of addresses reachable to the node.
   * Queried from cloud provider, if available.
   * More info: http://releases.k8s.io/release-1.3/docs/admin/node.md#node-addresses
   */
  @JsonProperty("addresses")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.NodeAddress> getAddresses();

  /*
   * Endpoints of daemons running on the Node.
   */
  @JsonProperty("daemonEndpoints")
  public abstract io.fabric8.kubernetes.types.api.v1.NodeDaemonEndpoints getDaemonEndpoints();

  /*
   * Set of ids/uuids to uniquely identify the node.
   * More info: http://releases.k8s.io/release-1.3/docs/admin/node.md#node-info
   */
  @JsonProperty("nodeInfo")
  public abstract io.fabric8.kubernetes.types.api.v1.NodeSystemInfo getNodeInfo();

  /*
   * List of container images on this node
   */
  @JsonProperty("images")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.ContainerImage> getImages();

  /*
   * List of attachable volumes in use (mounted) by the node.
   */
  @JsonProperty("volumesInUse")
  public abstract java.util.List<String> getVolumesInUse();

  /*
   * List of volumes that are attached to the node.
   */
  @JsonProperty("volumesAttached")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.AttachedVolume> getVolumesAttached();

}
