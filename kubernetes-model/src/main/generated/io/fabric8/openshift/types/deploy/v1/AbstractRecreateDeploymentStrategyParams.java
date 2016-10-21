package io.fabric8.openshift.types.deploy.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * RecreateDeploymentStrategyParams are the input to the Recreate deployment
 * strategy.
 */
@Value.Immutable
abstract class AbstractRecreateDeploymentStrategyParams {
  /*
   * TimeoutSeconds is the time to wait for updates before giving up. If the
   * value is nil, a default will be used.
   */
  @JsonProperty("timeoutSeconds")
  public abstract Long getTimeoutSeconds();

  /*
   * Pre is a lifecycle hook which is executed before the strategy manipulates
   * the deployment. All LifecycleHookFailurePolicy values are supported.
   */
  @JsonProperty("pre")
  public abstract io.fabric8.openshift.types.deploy.v1.LifecycleHook getPre();

  /*
   * Mid is a lifecycle hook which is executed while the deployment is scaled down to zero before the first new
   * pod is created. All LifecycleHookFailurePolicy values are supported.
   */
  @JsonProperty("mid")
  public abstract io.fabric8.openshift.types.deploy.v1.LifecycleHook getMid();

  /*
   * Post is a lifecycle hook which is executed after the strategy has
   * finished all deployment logic. All LifecycleHookFailurePolicy values are supported.
   */
  @JsonProperty("post")
  public abstract io.fabric8.openshift.types.deploy.v1.LifecycleHook getPost();

}
