package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * JobStatus represents the current state of a Job.
 */
@Value.Immutable
abstract class AbstractJobStatus {
  /*
   * Conditions represent the latest available observations of an object's current state.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/jobs.md
   */
  @JsonProperty("conditions")
  public abstract java.util.List<io.fabric8.kubernetes.types.apis.extensions.v1beta1.JobCondition> getConditions();

  /*
   * StartTime represents time when the job was acknowledged by the Job Manager.
   * It is not guaranteed to be set in happens-before order across separate operations.
   * It is represented in RFC3339 form and is in UTC.
   */
  @JsonProperty("startTime")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getStartTime();

  /*
   * CompletionTime represents time when the job was completed. It is not guaranteed to
   * be set in happens-before order across separate operations.
   * It is represented in RFC3339 form and is in UTC.
   */
  @JsonProperty("completionTime")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getCompletionTime();

  /*
   * Active is the number of actively running pods.
   */
  @JsonProperty("active")
  public abstract Integer getActive();

  /*
   * Succeeded is the number of pods which reached Phase Succeeded.
   */
  @JsonProperty("succeeded")
  public abstract Integer getSucceeded();

  /*
   * Failed is the number of pods which reached Phase Failed.
   */
  @JsonProperty("failed")
  public abstract Integer getFailed();

}
