package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Host Port Range defines a range of host ports that will be enabled by a policy
 * for pods to use.  It requires both the start and end to be defined.
 */
@Value.Immutable
abstract class AbstractHostPortRange {
  /*
   * min is the start of the range, inclusive.
   */
  @JsonProperty("min")
  public abstract Integer getMin();

  /*
   * max is the end of the range, inclusive.
   */
  @JsonProperty("max")
  public abstract Integer getMax();

}
