package io.fabric8.openshift.types.deploy.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * CustomDeploymentStrategyParams are the input to the Custom deployment strategy.
 */
@Value.Immutable
abstract class AbstractCustomDeploymentStrategyParams {
  /*
   * Image specifies a Docker image which can carry out a deployment.
   */
  @JsonProperty("image")
  public abstract String getImage();

  /*
   * Environment holds the environment which will be given to the container for Image.
   */
  @JsonProperty("environment")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.EnvVar> getEnvironment();

  /*
   * Command is optional and overrides CMD in the container Image.
   */
  @JsonProperty("command")
  public abstract java.util.List<String> getCommand();

}
