package io.fabric8.openshift.types.sdn.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ClusterNetwork describes the cluster network. There is normally only one object of this type,
 * named "default", which is created by the SDN network plugin based on the master configuration
 * when the cluster is brought up for the first time.
 */
@Value.Immutable
abstract class AbstractClusterNetwork implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ClusterNetwork", "v1");
  }

  @Value.Derived
  public String getApiVersion() {
    return getTypeMeta().getApiVersion();
  }

  @Value.Derived
  public String getKind() {
    return getTypeMeta().getKind();
  }

  /*
   * Standard object's metadata.
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Network is a CIDR string specifying the global overlay network's L3 space
   */
  @JsonProperty("network")
  public abstract String getNetwork();

  /*
   * HostSubnetLength is the number of bits of network to allocate to each node. eg, 8 would mean that each node would have a /24 slice of the overlay network for its pods
   */
  @JsonProperty("hostsubnetlength")
  public abstract Integer getHostsubnetlength();

  /*
   * ServiceNetwork is the CIDR range that Service IP addresses are allocated from
   */
  @JsonProperty("serviceNetwork")
  public abstract String getServiceNetwork();

  /*
   * PluginName is the name of the network plugin being used
   */
  @JsonProperty("pluginName")
  public abstract String getPluginName();

}
