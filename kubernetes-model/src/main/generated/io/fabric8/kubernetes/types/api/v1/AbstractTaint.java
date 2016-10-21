package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * The node this Taint is attached to has the effect "effect" on
 * any pod that that does not tolerate the Taint.
 */
@Value.Immutable
abstract class AbstractTaint {
  /*
   * Required. The taint key to be applied to a node.
   */
  @JsonProperty("key")
  public abstract String getKey();

  /*
   * Required. The taint value corresponding to the taint key.
   */
  @JsonProperty("value")
  public abstract String getValue();

  /*
   * Required. The effect of the taint on pods
   * that do not tolerate the taint.
   * Valid effects are NoSchedule and PreferNoSchedule.
   */
  @JsonProperty("effect")
  public abstract String getEffect();

}
