package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Deployment enables declarative updates for Pods and ReplicaSets.
 */
@Value.Immutable
abstract class AbstractDeployment implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("Deployment", "extensions/v1beta1");
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
   * Standard object metadata.
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Specification of the desired behavior of the Deployment.
   */
  @JsonProperty("spec")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.DeploymentSpec getSpec();

  /*
   * Most recently observed status of the Deployment.
   */
  @JsonProperty("status")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.DeploymentStatus getStatus();

}
