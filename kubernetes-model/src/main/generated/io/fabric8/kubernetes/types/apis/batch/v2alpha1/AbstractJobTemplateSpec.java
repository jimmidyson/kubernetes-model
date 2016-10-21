package io.fabric8.kubernetes.types.apis.batch.v2alpha1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * JobTemplateSpec describes the data a Job should have when created from a template
 */
@Value.Immutable
abstract class AbstractJobTemplateSpec implements io.fabric8.kubernetes.types.api.HasMetadata {
  /*
   * Standard object's metadata of the jobs created from this template.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#metadata
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Specification of the desired behavior of the job.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#spec-and-status
   */
  @JsonProperty("spec")
  public abstract io.fabric8.kubernetes.types.apis.batch.v2alpha1.JobSpec getSpec();

}
