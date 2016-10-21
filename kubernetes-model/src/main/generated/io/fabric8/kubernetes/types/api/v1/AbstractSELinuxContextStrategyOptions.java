package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SELinuxContextStrategyOptions defines the strategy type and any options used to create the strategy.
 */
@Value.Immutable
abstract class AbstractSELinuxContextStrategyOptions {
  /*
   * Type is the strategy that will dictate what SELinux context is used in the SecurityContext.
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * seLinuxOptions required to run as; required for MustRunAs
   */
  @JsonProperty("seLinuxOptions")
  public abstract io.fabric8.kubernetes.types.api.v1.SELinuxOptions getSeLinuxOptions();

}
