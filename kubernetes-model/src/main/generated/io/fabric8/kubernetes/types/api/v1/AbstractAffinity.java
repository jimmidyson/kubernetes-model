package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Affinity is a group of affinity scheduling rules.
 */
@Value.Immutable
abstract class AbstractAffinity {
  /*
   * Describes node affinity scheduling rules for the pod.
   */
  @JsonProperty("nodeAffinity")
  public abstract io.fabric8.kubernetes.types.api.v1.NodeAffinity getNodeAffinity();

  /*
   * Describes pod affinity scheduling rules (e.g. co-locate this pod in the same node, zone, etc. as some other pod(s)).
   */
  @JsonProperty("podAffinity")
  public abstract io.fabric8.kubernetes.types.api.v1.PodAffinity getPodAffinity();

  /*
   * Describes pod anti-affinity scheduling rules (e.g. avoid putting this pod in the same node, zone, etc. as some other pod(s)).
   */
  @JsonProperty("podAntiAffinity")
  public abstract io.fabric8.kubernetes.types.api.v1.PodAntiAffinity getPodAntiAffinity();

}
