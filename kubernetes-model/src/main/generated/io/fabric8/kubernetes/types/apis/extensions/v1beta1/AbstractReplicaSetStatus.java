package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ReplicaSetStatus represents the current status of a ReplicaSet.
 */
@Value.Immutable
abstract class AbstractReplicaSetStatus {
  /*
   * Replicas is the most recently oberved number of replicas.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/replication-controller.md#what-is-a-replication-controller
   */
  @JsonProperty("replicas")
  public abstract Integer getReplicas();

  /*
   * The number of pods that have labels matching the labels of the pod template of the replicaset.
   */
  @JsonProperty("fullyLabeledReplicas")
  public abstract Integer getFullyLabeledReplicas();

  /*
   * ObservedGeneration reflects the generation of the most recently observed ReplicaSet.
   */
  @JsonProperty("observedGeneration")
  public abstract Long getObservedGeneration();

}
