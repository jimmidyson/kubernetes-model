package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PodTemplateSpec describes the data a pod should have when created from a template
 */
@Value.Immutable
abstract class AbstractPodTemplateSpec implements io.fabric8.kubernetes.types.api.HasMetadata {
  /*
   * Standard object's metadata.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#metadata
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Specification of the desired behavior of the pod.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#spec-and-status
   */
  @JsonProperty("spec")
  public abstract io.fabric8.kubernetes.types.api.v1.PodSpec getSpec();

}
