package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Spec to control the desired behavior of rolling update.
 */
@Value.Immutable
abstract class AbstractRollingUpdateDeployment {
  /*
   * The maximum number of pods that can be unavailable during the update.
   * Value can be an absolute number (ex: 5) or a percentage of desired pods (ex: 10%).
   * Absolute number is calculated from percentage by rounding up.
   * This can not be 0 if MaxSurge is 0.
   * By default, a fixed value of 1 is used.
   * Example: when this is set to 30%, the old RC can be scaled down to 70% of desired pods
   * immediately when the rolling update starts. Once new pods are ready, old RC
   * can be scaled down further, followed by scaling up the new RC, ensuring
   * that the total number of pods available at all times during the update is at
   * least 70% of desired pods.
   */
  @JsonProperty("maxUnavailable")
  public abstract io.fabric8.kubernetes.types.util.intstr.IntOrString getMaxUnavailable();

  /*
   * The maximum number of pods that can be scheduled above the desired number of
   * pods.
   * Value can be an absolute number (ex: 5) or a percentage of desired pods (ex: 10%).
   * This can not be 0 if MaxUnavailable is 0.
   * Absolute number is calculated from percentage by rounding up.
   * By default, a value of 1 is used.
   * Example: when this is set to 30%, the new RC can be scaled up immediately when
   * the rolling update starts, such that the total number of old and new pods do not exceed
   * 130% of desired pods. Once old pods have been killed,
   * new RC can be scaled up further, ensuring that total number of pods running
   * at any time during the update is atmost 130% of desired pods.
   */
  @JsonProperty("maxSurge")
  public abstract io.fabric8.kubernetes.types.util.intstr.IntOrString getMaxSurge();

}
