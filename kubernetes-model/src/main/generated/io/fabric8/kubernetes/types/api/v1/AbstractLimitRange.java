package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * LimitRange sets resource usage limits for each kind of resource in a Namespace.
 */
@Value.Immutable
abstract class AbstractLimitRange implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("LimitRange", "v1");
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
   * Spec defines the limits enforced.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#spec-and-status
   */
  @JsonProperty("spec")
  public abstract io.fabric8.kubernetes.types.api.v1.LimitRangeSpec getSpec();

}
