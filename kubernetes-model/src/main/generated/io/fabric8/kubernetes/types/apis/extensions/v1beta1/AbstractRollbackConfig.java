package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;


@Value.Immutable
abstract class AbstractRollbackConfig {
  /*
   * The revision to rollback to. If set to 0, rollbck to the last revision.
   */
  @JsonProperty("revision")
  public abstract Long getRevision();

}
