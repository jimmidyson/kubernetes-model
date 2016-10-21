package io.fabric8.openshift.types.deploy.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeploymentConfigRollbackSpec represents the options for rollback generation.
 */
@Value.Immutable
abstract class AbstractDeploymentConfigRollbackSpec {
  /*
   * From points to a ReplicationController which is a deployment.
   */
  @JsonProperty("from")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getFrom();

  /*
   * Revision to rollback to. If set to 0, rollback to the last revision.
   */
  @JsonProperty("revision")
  public abstract Long getRevision();

  /*
   * IncludeTriggers specifies whether to include config Triggers.
   */
  @JsonProperty("includeTriggers")
  public abstract Boolean isIncludeTriggers();

  /*
   * IncludeTemplate specifies whether to include the PodTemplateSpec.
   */
  @JsonProperty("includeTemplate")
  public abstract Boolean isIncludeTemplate();

  /*
   * IncludeReplicationMeta specifies whether to include the replica count and selector.
   */
  @JsonProperty("includeReplicationMeta")
  public abstract Boolean isIncludeReplicationMeta();

  /*
   * IncludeStrategy specifies whether to include the deployment Strategy.
   */
  @JsonProperty("includeStrategy")
  public abstract Boolean isIncludeStrategy();

}
