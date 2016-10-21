package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Status is a return value for calls that don't return other objects.
 */
@Value.Immutable
abstract class AbstractStatus {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("Status", "unversioned");
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
   * Standard list metadata.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#types-kinds
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.unversioned.ListMeta getMetadata();

  /*
   * Status of the operation.
   * One of: "Success" or "Failure".
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#spec-and-status
   */
  @JsonProperty("status")
  public abstract String getStatus();

  /*
   * A human-readable description of the status of this operation.
   */
  @JsonProperty("message")
  public abstract String getMessage();

  /*
   * A machine-readable description of why this operation is in the
   * "Failure" status. If this value is empty there
   * is no information available. A Reason clarifies an HTTP status
   * code but does not override it.
   */
  @JsonProperty("reason")
  public abstract String getReason();

  /*
   * Extended data associated with the reason.  Each reason may define its
   * own extended details. This field is optional and the data returned
   * is not guaranteed to conform to any schema except that defined by
   * the reason type.
   */
  @JsonProperty("details")
  public abstract io.fabric8.kubernetes.types.api.unversioned.StatusDetails getDetails();

  /*
   * Suggested HTTP return code for this status, 0 if not set.
   */
  @JsonProperty("code")
  public abstract Integer getCode();

}
