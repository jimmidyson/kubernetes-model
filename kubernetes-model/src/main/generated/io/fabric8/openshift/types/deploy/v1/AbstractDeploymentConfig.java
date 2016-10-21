package io.fabric8.openshift.types.deploy.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeploymentConfig represents a configuration for a single deployment (represented as a
 * ReplicationController). It also contains details about changes which resulted in the current
 * state of the DeploymentConfig. Each change to the DeploymentConfig which should result in
 * a new deployment results in an increment of LatestVersion.
 */
@Value.Immutable
abstract class AbstractDeploymentConfig implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("DeploymentConfig", "v1");
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
   * Spec represents a desired deployment state and how to deploy to it.
   */
  @JsonProperty("spec")
  public abstract io.fabric8.openshift.types.deploy.v1.DeploymentConfigSpec getSpec();

  /*
   * Status represents the current deployment state.
   */
  @JsonProperty("status")
  public abstract io.fabric8.openshift.types.deploy.v1.DeploymentConfigStatus getStatus();

}
