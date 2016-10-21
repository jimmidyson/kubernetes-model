package io.fabric8.kubernetes.types.apis.batch.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * A label selector is a label query over a set of resources. The result of matchLabels and
 * matchExpressions are ANDed. An empty label selector matches all objects. A null
 * label selector matches no objects.
 */
@Value.Immutable
abstract class AbstractLabelSelector {
  /*
   * matchLabels is a map of {key,value} pairs. A single {key,value} in the matchLabels
   * map is equivalent to an element of matchExpressions, whose key field is "key", the
   * operator is "In", and the values array contains only "value". The requirements are ANDed.
   */
  @JsonProperty("matchLabels")
  public abstract java.util.Map<String, String> getMatchLabels();

  /*
   * matchExpressions is a list of label selector requirements. The requirements are ANDed.
   */
  @JsonProperty("matchExpressions")
  public abstract java.util.List<io.fabric8.kubernetes.types.apis.batch.v1.LabelSelectorRequirement> getMatchExpressions();

}
