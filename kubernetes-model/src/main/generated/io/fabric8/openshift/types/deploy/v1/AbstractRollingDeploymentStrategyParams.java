package io.fabric8.openshift.types.deploy.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * RollingDeploymentStrategyParams are the input to the Rolling deployment
 * strategy.
 */
@Value.Immutable
abstract class AbstractRollingDeploymentStrategyParams {
  /*
   * UpdatePeriodSeconds is the time to wait between individual pod updates.
   * If the value is nil, a default will be used.
   */
  @JsonProperty("updatePeriodSeconds")
  public abstract Long getUpdatePeriodSeconds();

  /*
   * IntervalSeconds is the time to wait between polling deployment status
   * after update. If the value is nil, a default will be used.
   */
  @JsonProperty("intervalSeconds")
  public abstract Long getIntervalSeconds();

  /*
   * TimeoutSeconds is the time to wait for updates before giving up. If the
   * value is nil, a default will be used.
   */
  @JsonProperty("timeoutSeconds")
  public abstract Long getTimeoutSeconds();

  /*
   * MaxUnavailable is the maximum number of pods that can be unavailable
   * during the update. Value can be an absolute number (ex: 5) or a
   * percentage of total pods at the start of update (ex: 10%). Absolute
   * number is calculated from percentage by rounding up.
   * 
   * This cannot be 0 if MaxSurge is 0. By default, 25% is used.
   * 
   * Example: when this is set to 30%, the old RC can be scaled down by 30%
   * immediately when the rolling update starts. Once new pods are ready, old
   * RC can be scaled down further, followed by scaling up the new RC,
   * ensuring that at least 70% of original number of pods are available at
   * all times during the update.
   */
  @JsonProperty("maxUnavailable")
  public abstract io.fabric8.kubernetes.types.util.intstr.IntOrString getMaxUnavailable();

  /*
   * MaxSurge is the maximum number of pods that can be scheduled above the
   * original number of pods. Value can be an absolute number (ex: 5) or a
   * percentage of total pods at the start of the update (ex: 10%). Absolute
   * number is calculated from percentage by rounding up.
   * 
   * This cannot be 0 if MaxUnavailable is 0. By default, 25% is used.
   * 
   * Example: when this is set to 30%, the new RC can be scaled up by 30%
   * immediately when the rolling update starts. Once old pods have been
   * killed, new RC can be scaled up further, ensuring that total number of
   * pods running at any time during the update is atmost 130% of original
   * pods.
   */
  @JsonProperty("maxSurge")
  public abstract io.fabric8.kubernetes.types.util.intstr.IntOrString getMaxSurge();

  /*
   * UpdatePercent is the percentage of replicas to scale up or down each
   * interval. If nil, one replica will be scaled up and down each interval.
   * If negative, the scale order will be down/up instead of up/down.
   * DEPRECATED: Use MaxUnavailable/MaxSurge instead.
   */
  @JsonProperty("updatePercent")
  public abstract Integer getUpdatePercent();

  /*
   * Pre is a lifecycle hook which is executed before the deployment process
   * begins. All LifecycleHookFailurePolicy values are supported.
   */
  @JsonProperty("pre")
  public abstract io.fabric8.openshift.types.deploy.v1.LifecycleHook getPre();

  /*
   * Post is a lifecycle hook which is executed after the strategy has
   * finished all deployment logic. The LifecycleHookFailurePolicyAbort policy
   * is NOT supported.
   */
  @JsonProperty("post")
  public abstract io.fabric8.openshift.types.deploy.v1.LifecycleHook getPost();

}
