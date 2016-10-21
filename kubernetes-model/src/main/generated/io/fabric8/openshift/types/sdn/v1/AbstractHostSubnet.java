package io.fabric8.openshift.types.sdn.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * HostSubnet describes the container subnet network on a node. The HostSubnet object must have the
 * same name as the Node object it corresponds to.
 */
@Value.Immutable
abstract class AbstractHostSubnet implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("HostSubnet", "v1");
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
   * Host is the name of the node. (This is redundant with the object's name, and this
   * field is not actually used any more.)
   */
  @JsonProperty("host")
  public abstract String getHost();

  /*
   * HostIP is the IP address to be used as a VTEP by other nodes in the overlay network
   */
  @JsonProperty("hostIP")
  public abstract String getHostIP();

  /*
   * Subnet is the CIDR range of the overlay network assigned to the node for its pods
   */
  @JsonProperty("subnet")
  public abstract String getSubnet();

}
