package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Defines a set of pods (namely those matching the labelSelector
 * relative to the given namespace(s)) that this pod should be
 * co-located (affinity) or not co-located (anti-affinity) with,
 * where co-located is defined as running on a node whose value of
 * the label with key <topologyKey> tches that of any node on which
 * a pod of the set of pods is running
 */
@Value.Immutable
abstract class AbstractPodAffinityTerm {
  /*
   * A label query over a set of resources, in this case pods.
   */
  @JsonProperty("labelSelector")
  public abstract io.fabric8.kubernetes.types.api.unversioned.LabelSelector getLabelSelector();

  /*
   * namespaces specifies which namespaces the labelSelector applies to (matches against);
   * nil list means "this pod's namespace," empty list means "all namespaces"
   * The json tag here is not "omitempty" since we need to distinguish nil and empty.
   * See https://golang.org/pkg/encoding/json/#Marshal for more details.
   */
  @JsonProperty("namespaces")
  public abstract java.util.List<String> getNamespaces();

  /*
   * This pod should be co-located (affinity) or not co-located (anti-affinity) with the pods matching
   * the labelSelector in the specified namespaces, where co-located is defined as running on a node
   * whose value of the label with key topologyKey matches that of any node on which any of the
   * selected pods is running.
   * For PreferredDuringScheduling pod anti-affinity, empty topologyKey is interpreted as "all topologies"
   * ("all topologies" here means all the topologyKeys indicated by scheduler command-line argument --failure-domains);
   * for affinity and for RequiredDuringScheduling pod anti-affinity, empty topologyKey is not allowed.
   */
  @JsonProperty("topologyKey")
  public abstract String getTopologyKey();

}
