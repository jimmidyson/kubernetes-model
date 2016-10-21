package io.fabric8.kubernetes.types.apis.batch.v2alpha1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * JobTemplate describes a template for creating copies of a predefined pod.
 */
@Value.Immutable
abstract class AbstractJobTemplate implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("JobTemplate", "batch/v2alpha1");
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
   * Template defines jobs that will be created from this template
   * http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#spec-and-status
   */
  @JsonProperty("template")
  public abstract io.fabric8.kubernetes.types.apis.batch.v2alpha1.JobTemplateSpec getTemplate();

}
