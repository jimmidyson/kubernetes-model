package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * TagImportPolicy describes the tag import policy
 */
@Value.Immutable
abstract class AbstractTagImportPolicy {
  /*
   * Insecure is true if the server may bypass certificate verification or connect directly over HTTP during image import.
   */
  @JsonProperty("insecure")
  public abstract Boolean isInsecure();

  /*
   * Scheduled indicates to the server that this tag should be periodically checked to ensure it is up to date, and imported
   */
  @JsonProperty("scheduled")
  public abstract Boolean isScheduled();

}
