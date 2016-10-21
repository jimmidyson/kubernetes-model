package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * The pod this Toleration is attached to tolerates any taint that matches
 * the triple <key,value,effect> using the matching operator <operator>.
 */
@Value.Immutable
abstract class AbstractToleration {
  /*
   * Required. Key is the taint key that the toleration applies to.
   */
  @JsonProperty("key")
  public abstract String getKey();

  /*
   * operator represents a key's relationship to the value.
   * Valid operators are Exists and Equal. Defaults to Equal.
   * Exists is equivalent to wildcard for value, so that a pod can
   * tolerate all taints of a particular category.
   */
  @JsonProperty("operator")
  public abstract String getOperator();

  /*
   * Value is the taint value the toleration matches to.
   * If the operator is Exists, the value should be empty, otherwise just a regular string.
   */
  @JsonProperty("value")
  public abstract String getValue();

  /*
   * Effect indicates the taint effect to match. Empty means match all taint effects.
   * When specified, allowed values are NoSchedule and PreferNoSchedule.
   */
  @JsonProperty("effect")
  public abstract String getEffect();

}
