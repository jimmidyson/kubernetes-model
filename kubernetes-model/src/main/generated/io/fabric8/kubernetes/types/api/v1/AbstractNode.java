package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Node is a worker node in Kubernetes, formerly known as minion.
 * Each node will have a unique identifier in the cache (i.e. in etcd).
 */
@Value.Immutable
abstract class AbstractNode implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("Node", "v1");
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
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#metadata
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Spec defines the behavior of a node.
   * http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#spec-and-status
   */
  @JsonProperty("spec")
  public abstract io.fabric8.kubernetes.types.api.v1.NodeSpec getSpec();

  /*
   * Most recently observed status of the node.
   * Populated by the system.
   * Read-only.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#spec-and-status
   */
  @JsonProperty("status")
  public abstract io.fabric8.kubernetes.types.api.v1.NodeStatus getStatus();

}
