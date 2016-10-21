package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SupplementalGroupsStrategyOptions defines the strategy type and options used to create the strategy.
 */
@Value.Immutable
abstract class AbstractSupplementalGroupsStrategyOptions {
  /*
   * Rule is the strategy that will dictate what supplemental groups is used in the SecurityContext.
   */
  @JsonProperty("rule")
  public abstract String getRule();

  /*
   * Ranges are the allowed ranges of supplemental groups.  If you would like to force a single
   * supplemental group then supply a single range with the same start and end.
   */
  @JsonProperty("ranges")
  public abstract java.util.List<io.fabric8.kubernetes.types.apis.extensions.v1beta1.IDRange> getRanges();

}
