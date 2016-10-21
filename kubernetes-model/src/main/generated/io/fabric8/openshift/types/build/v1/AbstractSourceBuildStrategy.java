package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SourceBuildStrategy defines input parameters specific to an Source build.
 */
@Value.Immutable
abstract class AbstractSourceBuildStrategy {
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
   * scripts is the location of Source scripts
   */
  @JsonProperty("scripts")
  public abstract String getScripts();

  /*
   * incremental flag forces the Source build to do incremental builds if true.
   */
  @JsonProperty("incremental")
  public abstract Boolean isIncremental();

  /*
   * forcePull describes if the builder should pull the images from registry prior to building.
   */
  @JsonProperty("forcePull")
  public abstract Boolean isForcePull();

  /*
   * runtimeImage is an optional image that is used to run an application
   * without unneeded dependencies installed. The building of the application
   * is still done in the builder image but, post build, you can copy the
   * needed artifacts in the runtime image for use.
   * This field and the feature it enables are in tech preview.
   */
  @JsonProperty("runtimeImage")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getRuntimeImage();

  /*
   * runtimeArtifacts specifies a list of source/destination pairs that will be
   * copied from the builder to the runtime image. sourcePath can be a file or
   * directory. destinationDir must be a directory. destinationDir can also be
   * empty or equal to ".", in this case it just refers to the root of WORKDIR.
   * This field and the feature it enables are in tech preview.
   */
  @JsonProperty("runtimeArtifacts")
  public abstract java.util.List<io.fabric8.openshift.types.build.v1.ImageSourcePath> getRuntimeArtifacts();

}
