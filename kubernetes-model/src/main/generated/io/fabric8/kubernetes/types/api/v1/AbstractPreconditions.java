package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Preconditions must be fulfilled before an operation (update, delete, etc.) is carried out.
 */
@Value.Immutable
abstract class AbstractPreconditions {
  /*
   * Specifies the target UID.
   */
  @JsonProperty("uid")
  public abstract String getUid();

}
