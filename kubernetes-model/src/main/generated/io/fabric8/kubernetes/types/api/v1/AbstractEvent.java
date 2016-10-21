package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Event is a report of an event somewhere in the cluster.
 * TODO: Decide whether to store these separately or with the object they apply to.
 */
@Value.Immutable
abstract class AbstractEvent implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("Event", "v1");
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
   * Standard object's metadata.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#metadata
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * The object that this event is about.
   */
  @JsonProperty("involvedObject")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getInvolvedObject();

  /*
   * This should be a short, machine understandable string that gives the reason
   * for the transition into the object's current status.
   * TODO: provide exact specification for format.
   */
  @JsonProperty("reason")
  public abstract String getReason();

  /*
   * A human-readable description of the status of this operation.
   * TODO: decide on maximum length.
   */
  @JsonProperty("message")
  public abstract String getMessage();

  /*
   * The component reporting this event. Should be a short machine understandable string.
   */
  @JsonProperty("source")
  public abstract io.fabric8.kubernetes.types.api.v1.EventSource getSource();

  /*
   * The time at which the event was first recorded. (Time of server receipt is in TypeMeta.)
   */
  @JsonProperty("firstTimestamp")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getFirstTimestamp();

  /*
   * The time at which the most recent occurrence of this event was recorded.
   */
  @JsonProperty("lastTimestamp")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getLastTimestamp();

  /*
   * The number of times this event has occurred.
   */
  @JsonProperty("count")
  public abstract Integer getCount();

  /*
   * Type of this event (Normal, Warning), new types could be added in the future
   */
  @JsonProperty("type")
  public abstract String getType();

}
