package io.fabric8.kubernetes.types.apis.autoscaling.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Scale represents a scaling request for a resource.
 */
@Value.Immutable
abstract class AbstractScale implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("Scale", "autoscaling/v1");
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
   * Standard object metadata; More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#metadata.
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * defines the behavior of the scale. More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#spec-and-status.
   */
  @JsonProperty("spec")
  public abstract io.fabric8.kubernetes.types.apis.autoscaling.v1.ScaleSpec getSpec();

  /*
   * current status of the scale. More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#spec-and-status. Read-only.
   */
  @JsonProperty("status")
  public abstract io.fabric8.kubernetes.types.apis.autoscaling.v1.ScaleStatus getStatus();

}
