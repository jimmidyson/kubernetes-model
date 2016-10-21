package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * current status of a horizontal pod autoscaler
 */
@Value.Immutable
abstract class AbstractHorizontalPodAutoscalerStatus {
  /*
   * most recent generation observed by this autoscaler.
   */
  @JsonProperty("observedGeneration")
  public abstract Long getObservedGeneration();

  /*
   * last time the HorizontalPodAutoscaler scaled the number of pods;
   * used by the autoscaler to control how often the number of pods is changed.
   */
  @JsonProperty("lastScaleTime")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getLastScaleTime();

  /*
   * current number of replicas of pods managed by this autoscaler.
   */
  @JsonProperty("currentReplicas")
  public abstract Integer getCurrentReplicas();

  /*
   * desired number of replicas of pods managed by this autoscaler.
   */
  @JsonProperty("desiredReplicas")
  public abstract Integer getDesiredReplicas();

  /*
   * current average CPU utilization over all pods, represented as a percentage of requested CPU,
   * e.g. 70 means that an average pod is using now 70% of its requested CPU.
   */
  @JsonProperty("currentCPUUtilizationPercentage")
  public abstract Integer getCurrentCPUUtilizationPercentage();

}
