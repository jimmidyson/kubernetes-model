package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * CustomBuildStrategy defines input parameters specific to Custom build.
 */
@Value.Immutable
abstract class AbstractCustomBuildStrategy {
  /*
   * from is reference to an DockerImage, ImageStreamTag, or ImageStreamImage from which
   * the docker image should be pulled
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
   * env contains additional environment variables you want to pass into a builder container
   */
  @JsonProperty("env")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.EnvVar> getEnv();

  /*
   * exposeDockerSocket will allow running Docker commands (and build Docker images) from
   * inside the Docker container.
   * TODO: Allow admins to enforce 'false' for this option
   */
  @JsonProperty("exposeDockerSocket")
  public abstract Boolean isExposeDockerSocket();

  /*
   * forcePull describes if the controller should configure the build pod to always pull the images
   * for the builder or only pull if it is not present locally
   */
  @JsonProperty("forcePull")
  public abstract Boolean isForcePull();

  /*
   * secrets is a list of additional secrets that will be included in the build pod
   */
  @JsonProperty("secrets")
  public abstract java.util.List<io.fabric8.openshift.types.build.v1.SecretSpec> getSecrets();

  /*
   * buildAPIVersion is the requested API version for the Build object serialized and passed to the custom builder
   */
  @JsonProperty("buildAPIVersion")
  public abstract String getBuildAPIVersion();

}
