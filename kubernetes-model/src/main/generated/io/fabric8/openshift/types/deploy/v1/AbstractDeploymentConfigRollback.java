package io.fabric8.openshift.types.deploy.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeploymentConfigRollback provides the input to rollback generation.
 */
@Value.Immutable
abstract class AbstractDeploymentConfigRollback {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("DeploymentConfigRollback", "v1");
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
   * Name of the deployment config that will be rolled back.
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * UpdatedAnnotations is a set of new annotations that will be added in the deployment config.
   */
  @JsonProperty("updatedAnnotations")
  public abstract java.util.Map<String, String> getUpdatedAnnotations();

  /*
   * Spec defines the options to rollback generation.
   */
  @JsonProperty("spec")
  public abstract io.fabric8.openshift.types.deploy.v1.DeploymentConfigRollbackSpec getSpec();

}
