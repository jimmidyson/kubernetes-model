package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * BuildLogOptions is the REST options for a build log
 */
@Value.Immutable
abstract class AbstractBuildLogOptions {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("BuildLogOptions", "v1");
  }

  @Value.Derived
  public String getApiVersion() {
    return getTypeMeta().getApiVersion();
  }

  @Value.Derived
  public String getKind() {
    return getTypeMeta().getKind();
  }

  /*
   * cointainer for which to stream logs. Defaults to only container if there is one container in the pod.
   */
  @JsonProperty("container")
  public abstract String getContainer();

  /*
   * follow if true indicates that the build log should be streamed until
   * the build terminates.
   */
  @JsonProperty("follow")
  public abstract Boolean isFollow();

  /*
   * previous returns previous build logs. Defaults to false.
   */
  @JsonProperty("previous")
  public abstract Boolean isPrevious();

  /*
   * sinceSeconds is a relative time in seconds before the current time from which to show logs. If this value
   * precedes the time a pod was started, only logs since the pod start will be returned.
   * If this value is in the future, no logs will be returned.
   * Only one of sinceSeconds or sinceTime may be specified.
   */
  @JsonProperty("sinceSeconds")
  public abstract Long getSinceSeconds();

  /*
   * sinceTime is an RFC3339 timestamp from which to show logs. If this value
   * precedes the time a pod was started, only logs since the pod start will be returned.
   * If this value is in the future, no logs will be returned.
   * Only one of sinceSeconds or sinceTime may be specified.
   */
  @JsonProperty("sinceTime")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getSinceTime();

  /*
   * timestamps, If true, add an RFC3339 or RFC3339Nano timestamp at the beginning of every line
   * of log output. Defaults to false.
   */
  @JsonProperty("timestamps")
  public abstract Boolean isTimestamps();

  /*
   * tailLines, If set, is the number of lines from the end of the logs to show. If not specified,
   * logs are shown from the creation of the container or sinceSeconds or sinceTime
   */
  @JsonProperty("tailLines")
  public abstract Long getTailLines();

  /*
   * limitBytes, If set, is the number of bytes to read from the server before terminating the
   * log output. This may not display a complete final line of logging, and may return
   * slightly more or slightly less than the specified limit.
   */
  @JsonProperty("limitBytes")
  public abstract Long getLimitBytes();

  /*
   * noWait if true causes the call to return immediately even if the build
   * is not available yet. Otherwise the server will wait until the build has started.
   * TODO: Fix the tag to 'noWait' in v2
   */
  @JsonProperty("nowait")
  public abstract Boolean isNowait();

  /*
   * version of the build for which to view logs.
   */
  @JsonProperty("version")
  public abstract Long getVersion();

}
