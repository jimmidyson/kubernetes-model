package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ReplicationController represents the configuration of a replication controller.
 */
@Value.Immutable
abstract class AbstractReplicationController implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ReplicationController", "v1");
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
   * If the Labels of a ReplicationController are empty, they are defaulted to
   * be the same as the Pod(s) that the replication controller manages.
   * Standard object's metadata. More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#metadata
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Spec defines the specification of the desired behavior of the replication controller.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#spec-and-status
   */
  @JsonProperty("spec")
  public abstract io.fabric8.kubernetes.types.api.v1.ReplicationControllerSpec getSpec();

  /*
   * Status is the most recently observed status of the replication controller.
   * This data may be out of date by some window of time.
   * Populated by the system.
   * Read-only.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#spec-and-status
   */
  @JsonProperty("status")
  public abstract io.fabric8.kubernetes.types.api.v1.ReplicationControllerStatus getStatus();

}
