package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * RunAsUserStrategyOptions defines the strategy type and any options used to create the strategy.
 */
@Value.Immutable
abstract class AbstractRunAsUserStrategyOptions {
  /*
   * Type is the strategy that will dictate what RunAsUser is used in the SecurityContext.
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * UID is the user id that containers must run as.  Required for the MustRunAs strategy if not using
   * namespace/service account allocated uids.
   */
  @JsonProperty("uid")
  public abstract Long getUid();

  /*
   * UIDRangeMin defines the min value for a strategy that allocates by range.
   */
  @JsonProperty("uidRangeMin")
  public abstract Long getUidRangeMin();

  /*
   * UIDRangeMax defines the max value for a strategy that allocates by range.
   */
  @JsonProperty("uidRangeMax")
  public abstract Long getUidRangeMax();

}
