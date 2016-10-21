package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * CommonSpec encapsulates all the inputs necessary to represent a build.
 */
@Value.Immutable
abstract class AbstractCommonSpec {
  /*
   * serviceAccount is the name of the ServiceAccount to use to run the pod
   * created by this build.
   * The pod will be allowed to use secrets referenced by the ServiceAccount
   */
  @JsonProperty("serviceAccount")
  public abstract String getServiceAccount();

  /*
   * source describes the SCM in use.
   */
  @JsonProperty("source")
  public abstract io.fabric8.openshift.types.build.v1.BuildSource getSource();

  /*
   * revision is the information from the source for a specific repo snapshot.
   * This is optional.
   */
  @JsonProperty("revision")
  public abstract io.fabric8.openshift.types.build.v1.SourceRevision getRevision();

  /*
   * strategy defines how to perform a build.
   */
  @JsonProperty("strategy")
  public abstract io.fabric8.openshift.types.build.v1.BuildStrategy getStrategy();

  /*
   * output describes the Docker image the Strategy should produce.
   */
  @JsonProperty("output")
  public abstract io.fabric8.openshift.types.build.v1.BuildOutput getOutput();

  /*
   * resources computes resource requirements to execute the build.
   */
  @JsonProperty("resources")
  public abstract io.fabric8.kubernetes.types.api.v1.ResourceRequirements getResources();

  /*
   * postCommit is a build hook executed after the build output image is
   * committed, before it is pushed to a registry.
   */
  @JsonProperty("postCommit")
  public abstract io.fabric8.openshift.types.build.v1.BuildPostCommitSpec getPostCommit();

  /*
   * completionDeadlineSeconds is an optional duration in seconds, counted from
   * the time when a build pod gets scheduled in the system, that the build may
   * be active on a node before the system actively tries to terminate the
   * build; value must be positive integer
   */
  @JsonProperty("completionDeadlineSeconds")
  public abstract Long getCompletionDeadlineSeconds();

}
