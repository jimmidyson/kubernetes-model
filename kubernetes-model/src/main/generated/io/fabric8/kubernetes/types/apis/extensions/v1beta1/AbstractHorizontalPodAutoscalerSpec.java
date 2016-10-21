package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * specification of a horizontal pod autoscaler.
 */
@Value.Immutable
abstract class AbstractHorizontalPodAutoscalerSpec {
  /*
   * reference to Scale subresource; horizontal pod autoscaler will learn the current resource consumption from its status,
   * and will set the desired number of pods by modifying its spec.
   */
  @JsonProperty("scaleRef")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.SubresourceReference getScaleRef();

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
   * if not specified it defaults to the target CPU utilization at 80% of the requested resources.
   */
  @JsonProperty("cpuUtilization")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.CPUTargetUtilization getCpuUtilization();

}
