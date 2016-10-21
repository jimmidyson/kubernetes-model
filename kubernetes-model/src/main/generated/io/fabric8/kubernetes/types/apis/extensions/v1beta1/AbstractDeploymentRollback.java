package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeploymentRollback stores the information required to rollback a deployment.
 */
@Value.Immutable
abstract class AbstractDeploymentRollback {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("DeploymentRollback", "extensions/v1beta1");
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
   * Required: This must match the Name of a deployment.
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * The annotations to be updated to a deployment
   */
  @JsonProperty("updatedAnnotations")
  public abstract java.util.Map<String, String> getUpdatedAnnotations();

  /*
   * The config of this deployment rollback.
   */
  @JsonProperty("rollbackTo")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.RollbackConfig getRollbackTo();

}
