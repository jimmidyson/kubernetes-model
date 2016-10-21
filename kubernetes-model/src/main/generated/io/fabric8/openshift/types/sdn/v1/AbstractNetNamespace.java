package io.fabric8.openshift.types.sdn.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * NetNamespace describes a single isolated network. When using the redhat/openshift-ovs-multitenant
 * plugin, every Namespace will have a corresponding NetNamespace object with the same name.
 * (When using redhat/openshift-ovs-subnet, NetNamespaces are not used.)
 */
@Value.Immutable
abstract class AbstractNetNamespace implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("NetNamespace", "v1");
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
   * NetName is the name of the network namespace. (This is the same as the object's name, but both fields must be set.)
   */
  @JsonProperty("netname")
  public abstract String getNetname();

  /*
   * NetID is the network identifier of the network namespace assigned to each overlay network packet. This can be manipulated with the "oadm pod-network" commands.
   */
  @JsonProperty("netid")
  public abstract Integer getNetid();

}
