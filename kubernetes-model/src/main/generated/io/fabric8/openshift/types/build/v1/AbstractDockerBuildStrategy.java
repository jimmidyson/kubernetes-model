package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DockerBuildStrategy defines input parameters specific to Docker build.
 */
@Value.Immutable
abstract class AbstractDockerBuildStrategy {
  /*
   * from is reference to an DockerImage, ImageStreamTag, or ImageStreamImage from which
   * the docker image should be pulled
   * the resulting image will be used in the FROM line of the Dockerfile for this build.
   */
  @JsonProperty("from")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getFrom();

  /*
   * pullSecret is the name of a Secret that would be used for setting up
   * the authentication for pulling the Docker images from the private Docker
   * registries
   */
  @JsonProperty("pullSecret")
  public abstract io.fabric8.kubernetes.types.api.v1.LocalObjectReference getPullSecret();

  /*
   * noCache if set to true indicates that the docker build must be executed with the
   * --no-cache=true flag
   */
  @JsonProperty("noCache")
  public abstract Boolean isNoCache();

  /*
   * env contains additional environment variables you want to pass into a builder container
   */
  @JsonProperty("env")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.EnvVar> getEnv();

  /*
   * forcePull describes if the builder should pull the images from registry prior to building.
   */
  @JsonProperty("forcePull")
  public abstract Boolean isForcePull();

  /*
   * dockerfilePath is the path of the Dockerfile that will be used to build the Docker image,
   * relative to the root of the context (contextDir).
   */
  @JsonProperty("dockerfilePath")
  public abstract String getDockerfilePath();

}
