package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * BuildOutput is input to a build strategy and describes the Docker image that the strategy
 * should produce.
 */
@Value.Immutable
abstract class AbstractBuildOutput {
  /*
   * to defines an optional location to push the output of this build to.
   * Kind must be one of 'ImageStreamTag' or 'DockerImage'.
   * This value will be used to look up a Docker image repository to push to.
   * In the case of an ImageStreamTag, the ImageStreamTag will be looked for in the namespace of
   * the build unless Namespace is specified.
   */
  @JsonProperty("to")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getTo();

  /*
   * PushSecret is the name of a Secret that would be used for setting
   * up the authentication for executing the Docker push to authentication
   * enabled Docker Registry (or Docker Hub).
   */
  @JsonProperty("pushSecret")
  public abstract io.fabric8.kubernetes.types.api.v1.LocalObjectReference getPushSecret();

}
