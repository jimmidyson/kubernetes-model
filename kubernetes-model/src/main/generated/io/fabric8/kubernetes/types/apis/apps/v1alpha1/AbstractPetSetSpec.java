package io.fabric8.kubernetes.types.apis.apps.v1alpha1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * A PetSetSpec is the specification of a PetSet.
 */
@Value.Immutable
abstract class AbstractPetSetSpec {
  /*
   * Replicas is the desired number of replicas of the given Template.
   * These are replicas in the sense that they are instantiations of the
   * same Template, but individual replicas also have a consistent identity.
   * If unspecified, defaults to 1.
   * TODO: Consider a rename of this field.
   */
  @JsonProperty("replicas")
  public abstract Integer getReplicas();

  /*
   * Selector is a label query over pods that should match the replica count.
   * If empty, defaulted to labels on the pod template.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/labels.md#label-selectors
   */
  @JsonProperty("selector")
  public abstract io.fabric8.kubernetes.types.api.unversioned.LabelSelector getSelector();

  /*
   * Template is the object that describes the pod that will be created if
   * insufficient replicas are detected. Each pod stamped out by the PetSet
   * will fulfill this Template, but have a unique identity from the rest
   * of the PetSet.
   */
  @JsonProperty("template")
  public abstract io.fabric8.kubernetes.types.api.v1.PodTemplateSpec getTemplate();

  /*
   * VolumeClaimTemplates is a list of claims that pets are allowed to reference.
   * The PetSet controller is responsible for mapping network identities to
   * claims in a way that maintains the identity of a pet. Every claim in
   * this list must have at least one matching (by name) volumeMount in one
   * container in the template. A claim in this list takes precedence over
   * any volumes in the template, with the same name.
   * TODO: Define the behavior if a claim already exists with the same name.
   */
  @JsonProperty("volumeClaimTemplates")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.PersistentVolumeClaim> getVolumeClaimTemplates();

  /*
   * ServiceName is the name of the service that governs this PetSet.
   * This service must exist before the PetSet, and is responsible for
   * the network identity of the set. Pets get DNS/hostnames that follow the
   * pattern: pet-specific-string.serviceName.default.svc.cluster.local
   * where "pet-specific-string" is managed by the PetSet controller.
   */
  @JsonProperty("serviceName")
  public abstract String getServiceName();

}
