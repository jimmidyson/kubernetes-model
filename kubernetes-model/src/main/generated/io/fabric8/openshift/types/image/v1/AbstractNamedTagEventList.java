package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * NamedTagEventList relates a tag to its image history.
 */
@Value.Immutable
abstract class AbstractNamedTagEventList {
  /*
   * Tag is the tag for which the history is recorded
   */
  @JsonProperty("tag")
  public abstract String getTag();

  /*
   * Standard object's metadata.
   */
  @JsonProperty("items")
  public abstract java.util.List<io.fabric8.openshift.types.image.v1.TagEvent> getItems();

  /*
   * Conditions is an array of conditions that apply to the tag event list.
   */
  @JsonProperty("conditions")
  public abstract java.util.List<io.fabric8.openshift.types.image.v1.TagEventCondition> getConditions();

}
