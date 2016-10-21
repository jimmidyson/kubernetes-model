package io.fabric8.kubernetes.types.apis.batch.v2alpha1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ScheduledJobSpec describes how the job execution will look like and when it will actually run.
 */
@Value.Immutable
abstract class AbstractScheduledJobSpec {
  /*
   * Schedule contains the schedule in Cron format, see https://en.wikipedia.org/wiki/Cron.
   */
  @JsonProperty("schedule")
  public abstract String getSchedule();

  /*
   * Optional deadline in seconds for starting the job if it misses scheduled
   * time for any reason.  Missed jobs executions will be counted as failed ones.
   */
  @JsonProperty("startingDeadlineSeconds")
  public abstract Long getStartingDeadlineSeconds();

  /*
   * ConcurrencyPolicy specifies how to treat concurrent executions of a Job.
   */
  @JsonProperty("concurrencyPolicy")
  public abstract String getConcurrencyPolicy();

  /*
   * Suspend flag tells the controller to suspend subsequent executions, it does
   * not apply to already started executions.  Defaults to false.
   */
  @JsonProperty("suspend")
  public abstract Boolean isSuspend();

  /*
   * JobTemplate is the object that describes the job that will be created when
   * executing a ScheduledJob.
   */
  @JsonProperty("jobTemplate")
  public abstract io.fabric8.kubernetes.types.apis.batch.v2alpha1.JobTemplateSpec getJobTemplate();

}
