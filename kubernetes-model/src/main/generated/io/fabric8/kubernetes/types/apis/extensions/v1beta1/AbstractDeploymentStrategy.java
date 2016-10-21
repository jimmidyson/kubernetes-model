package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeploymentStrategy describes how to replace existing pods with new ones.
 */
@Value.Immutable
abstract class AbstractDeploymentStrategy {
  /*
   * Type of deployment. Can be "Recreate" or "RollingUpdate". Default is RollingUpdate.
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * Rolling update config params. Present only if DeploymentStrategyType =
   * RollingUpdate.
   * ---
   * TODO: Update this to follow our convention for oneOf, whatever we decide it
   * to be.
   */
  @JsonProperty("rollingUpdate")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.RollingUpdateDeployment getRollingUpdate();

}
