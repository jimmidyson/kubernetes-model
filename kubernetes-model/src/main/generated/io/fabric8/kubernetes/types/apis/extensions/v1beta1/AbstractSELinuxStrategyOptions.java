package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SELinux  Strategy Options defines the strategy type and any options used to create the strategy.
 */
@Value.Immutable
abstract class AbstractSELinuxStrategyOptions {
  /*
   * type is the strategy that will dictate the allowable labels that may be set.
   */
  @JsonProperty("rule")
  public abstract String getRule();

  /*
   * seLinuxOptions required to run as; required for MustRunAs
   * More info: http://releases.k8s.io/release-1.3/docs/design/security_context.md#security-context
   */
  @JsonProperty("seLinuxOptions")
  public abstract io.fabric8.kubernetes.types.api.v1.SELinuxOptions getSeLinuxOptions();

}
