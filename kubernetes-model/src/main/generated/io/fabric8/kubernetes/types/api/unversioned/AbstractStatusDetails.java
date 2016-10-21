package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * StatusDetails is a set of additional properties that MAY be set by the
 * server to provide additional information about a response. The Reason
 * field of a Status object defines what attributes will be set. Clients
 * must ignore fields that do not match the defined type of each attribute,
 * and should assume that any attribute may be empty, invalid, or under
 * defined.
 */
@Value.Immutable
abstract class AbstractStatusDetails {
  /*
   * The name attribute of the resource associated with the status StatusReason
   * (when there is a single name which can be described).
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * The group attribute of the resource associated with the status StatusReason.
   */
  @JsonProperty("group")
  public abstract String getGroup();

  /*
   * The kind attribute of the resource associated with the status StatusReason.
   * On some operations may differ from the requested resource Kind.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  public abstract String getKind();

  /*
   * The Causes array includes more details associated with the StatusReason
   * failure. Not all StatusReasons may provide detailed causes.
   */
  @JsonProperty("causes")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.unversioned.StatusCause> getCauses();

  /*
   * If specified, the time in seconds before the operation should be retried.
   */
  @JsonProperty("retryAfterSeconds")
  public abstract Integer getRetryAfterSeconds();

}
