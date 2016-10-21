package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PersistentVolumeStatus is the current status of a persistent volume.
 */
@Value.Immutable
abstract class AbstractPersistentVolumeStatus {
  /*
   * Phase indicates if a volume is available, bound to a claim, or released by a claim.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/persistent-volumes.md#phase
   */
  @JsonProperty("phase")
  public abstract String getPhase();

  /*
   * A human-readable message indicating details about why the volume is in this state.
   */
  @JsonProperty("message")
  public abstract String getMessage();

  /*
   * Reason is a brief CamelCase string that describes any failure and is meant
   * for machine parsing and tidy display in the CLI.
   */
  @JsonProperty("reason")
  public abstract String getReason();

}
