package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * BuildStatus contains the status of a build
 */
@Value.Immutable
abstract class AbstractBuildStatus {
  /*
   * phase is the point in the build lifecycle.
   */
  @JsonProperty("phase")
  public abstract String getPhase();

  /*
   * cancelled describes if a cancel event was triggered for the build.
   */
  @JsonProperty("cancelled")
  public abstract Boolean isCancelled();

  /*
   * reason is a brief CamelCase string that describes any failure and is meant for machine parsing and tidy display in the CLI.
   */
  @JsonProperty("reason")
  public abstract String getReason();

  /*
   * message is a human-readable message indicating details about why the build has this status.
   */
  @JsonProperty("message")
  public abstract String getMessage();

  /*
   * startTimestamp is a timestamp representing the server time when this Build started
   * running in a Pod.
   * It is represented in RFC3339 form and is in UTC.
   */
  @JsonProperty("startTimestamp")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getStartTimestamp();

  /*
   * completionTimestamp is a timestamp representing the server time when this Build was
   * finished, whether that build failed or succeeded.  It reflects the time at which
   * the Pod running the Build terminated.
   * It is represented in RFC3339 form and is in UTC.
   */
  @JsonProperty("completionTimestamp")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getCompletionTimestamp();

  /*
   * duration contains time.Duration object describing build time.
   */
  @JsonProperty("duration")
  public abstract Long getDuration();

  /*
   * outputDockerImageReference contains a reference to the Docker image that
   * will be built by this build. Its value is computed from
   * Build.Spec.Output.To, and should include the registry address, so that
   * it can be used to push and pull the image.
   */
  @JsonProperty("outputDockerImageReference")
  public abstract String getOutputDockerImageReference();

  /*
   * config is an ObjectReference to the BuildConfig this Build is based on.
   */
  @JsonProperty("config")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getConfig();

}
