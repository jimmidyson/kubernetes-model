package io.fabric8.kubernetes.types.apis.batch.v2alpha1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ScheduledJobStatus represents the current state of a Job.
 */
@Value.Immutable
abstract class AbstractScheduledJobStatus {
  /*
   * Active holds pointers to currently running jobs.
   */
  @JsonProperty("active")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.ObjectReference> getActive();

  /*
   * LastScheduleTime keeps information of when was the last time the job was successfully scheduled.
   */
  @JsonProperty("lastScheduleTime")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getLastScheduleTime();

}
