package io.fabric8.kubernetes.types.apis.batch.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * JobSpec describes how the job execution will look like.
 */
@Value.Immutable
abstract class AbstractJobSpec {
  /*
   * Parallelism specifies the maximum desired number of pods the job should
   * run at any given time. The actual number of pods running in steady state will
   * be less than this number when ((.spec.completions - .status.successful) < .spec.parallelism),
   * i.e. when the work left to do is less than max parallelism.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/jobs.md
   */
  @JsonProperty("parallelism")
  public abstract Integer getParallelism();

  /*
   * Completions specifies the desired number of successfully finished pods the
   * job should be run with.  Setting to nil means that the success of any
   * pod signals the success of all pods, and allows parallelism to have any positive
   * value.  Setting to 1 means that parallelism is limited to 1 and the success of that
   * pod signals the success of the job.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/jobs.md
   */
  @JsonProperty("completions")
  public abstract Integer getCompletions();

  /*
   * Optional duration in seconds relative to the startTime that the job may be active
   * before the system tries to terminate it; value must be positive integer
   */
  @JsonProperty("activeDeadlineSeconds")
  public abstract Long getActiveDeadlineSeconds();

  /*
   * Selector is a label query over pods that should match the pod count.
   * Normally, the system sets this field for you.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/labels.md#label-selectors
   */
  @JsonProperty("selector")
  public abstract io.fabric8.kubernetes.types.apis.batch.v1.LabelSelector getSelector();

  /*
   * ManualSelector controls generation of pod labels and pod selectors.
   * Leave `manualSelector` unset unless you are certain what you are doing.
   * When false or unset, the system pick labels unique to this job
   * and appends those labels to the pod template.  When true,
   * the user is responsible for picking unique labels and specifying
   * the selector.  Failure to pick a unique label may cause this
   * and other jobs to not function correctly.  However, You may see
   * `manualSelector=true` in jobs that were created with the old `extensions/v1beta1`
   * API.
   * More info: http://releases.k8s.io/release-1.3/docs/design/selector-generation.md
   */
  @JsonProperty("manualSelector")
  public abstract Boolean isManualSelector();

  /*
   * Template is the object that describes the pod that will be created when
   * executing a job.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/jobs.md
   */
  @JsonProperty("template")
  public abstract io.fabric8.kubernetes.types.api.v1.PodTemplateSpec getTemplate();

}
