package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Run A sUser Strategy Options defines the strategy type and any options used to create the strategy.
 */
@Value.Immutable
abstract class AbstractRunAsUserStrategyOptions {
  /*
   * Rule is the strategy that will dictate the allowable RunAsUser values that may be set.
   */
  @JsonProperty("rule")
  public abstract String getRule();

  /*
   * Ranges are the allowed ranges of uids that may be used.
   */
  @JsonProperty("ranges")
  public abstract java.util.List<io.fabric8.kubernetes.types.apis.extensions.v1beta1.IDRange> getRanges();

}
