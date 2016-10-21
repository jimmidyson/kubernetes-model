package io.fabric8.kubernetes.types.apis.autoscaling.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * specification of a horizontal pod autoscaler.
 */
@Value.Immutable
abstract class AbstractHorizontalPodAutoscalerSpec {
  /*
   * reference to scaled resource; horizontal pod autoscaler will learn the current resource consumption
   * and will set the desired number of pods by using its Scale subresource.
   */
  @JsonProperty("scaleTargetRef")
  public abstract io.fabric8.kubernetes.types.apis.autoscaling.v1.CrossVersionObjectReference getScaleTargetRef();

  /*
   * lower limit for the number of pods that can be set by the autoscaler, default 1.
   */
  @JsonProperty("minReplicas")
  public abstract Integer getMinReplicas();

  /*
   * upper limit for the number of pods that can be set by the autoscaler; cannot be smaller than MinReplicas.
   */
  @JsonProperty("maxReplicas")
  public abstract Integer getMaxReplicas();

  /*
   * target average CPU utilization (represented as a percentage of requested CPU) over all the pods;
   * if not specified the default autoscaling policy will be used.
   */
  @JsonProperty("targetCPUUtilizationPercentage")
  public abstract Integer getTargetCPUUtilizationPercentage();

}
