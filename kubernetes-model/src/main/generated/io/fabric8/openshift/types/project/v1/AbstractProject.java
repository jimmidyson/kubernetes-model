package io.fabric8.openshift.types.project.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Project is a logical top-level container for a set of origin resources
 */
@Value.Immutable
abstract class AbstractProject implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("Project", "v1");
  }

  @Value.Derived
  public String getApiVersion() {
    return getTypeMeta().getApiVersion();
  }

  @Value.Derived
  public String getKind() {
    return getTypeMeta().getKind();
  }

  /*
   * Standard object's metadata.
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Spec defines the behavior of the Namespace.
   */
  @JsonProperty("spec")
  public abstract io.fabric8.openshift.types.project.v1.ProjectSpec getSpec();

  /*
   * Status describes the current status of a Namespace
   */
  @JsonProperty("status")
  public abstract io.fabric8.openshift.types.project.v1.ProjectStatus getStatus();

}
