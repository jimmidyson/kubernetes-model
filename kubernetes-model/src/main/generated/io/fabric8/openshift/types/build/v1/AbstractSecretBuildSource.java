package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SecretBuildSource describes a secret and its destination directory that will be
 * used only at the build time. The content of the secret referenced here will
 * be copied into the destination directory instead of mounting.
 */
@Value.Immutable
abstract class AbstractSecretBuildSource {
  /*
   * secret is a reference to an existing secret that you want to use in your
   * build.
   */
  @JsonProperty("secret")
  public abstract io.fabric8.kubernetes.types.api.v1.LocalObjectReference getSecret();

  /*
   * destinationDir is the directory where the files from the secret should be
   * available for the build time.
   * For the Source build strategy, these will be injected into a container
   * where the assemble script runs. Later, when the script finishes, all files
   * injected will be truncated to zero length.
   * For the Docker build strategy, these will be copied into the build
   * directory, where the Dockerfile is located, so users can ADD or COPY them
   * during docker build.
   */
  @JsonProperty("destinationDir")
  public abstract String getDestinationDir();

}
