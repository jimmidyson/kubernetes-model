package io.fabric8.kubernetes.types.apis.batch.v2alpha1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Job represents the configuration of a single job.
 */
@Value.Immutable
abstract class AbstractJob implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("Job", "batch/v2alpha1");
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
   * Spec is a structure defining the expected behavior of a job.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#spec-and-status
   */
  @JsonProperty("spec")
  public abstract io.fabric8.kubernetes.types.apis.batch.v2alpha1.JobSpec getSpec();

  /*
   * Status is a structure describing current status of a job.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#spec-and-status
   */
  @JsonProperty("status")
  public abstract io.fabric8.kubernetes.types.apis.batch.v2alpha1.JobStatus getStatus();

}
