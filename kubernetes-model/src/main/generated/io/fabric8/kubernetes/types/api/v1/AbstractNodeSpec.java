package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * NodeSpec describes the attributes that a node is created with.
 */
@Value.Immutable
abstract class AbstractNodeSpec {
  /*
   * PodCIDR represents the pod IP range assigned to the node.
   */
  @JsonProperty("podCIDR")
  public abstract String getPodCIDR();

  /*
   * External ID of the node assigned by some machine database (e.g. a cloud provider).
   * Deprecated.
   */
  @JsonProperty("externalID")
  public abstract String getExternalID();

  /*
   * ID of the node assigned by the cloud provider in the format: <ProviderName>://<ProviderSpecificNodeID>
   */
  @JsonProperty("providerID")
  public abstract String getProviderID();

  /*
   * Unschedulable controls node schedulability of new pods. By default, node is schedulable.
   * More info: http://releases.k8s.io/release-1.3/docs/admin/node.md#manual-node-administration"`
   */
  @JsonProperty("unschedulable")
  public abstract Boolean isUnschedulable();

}
