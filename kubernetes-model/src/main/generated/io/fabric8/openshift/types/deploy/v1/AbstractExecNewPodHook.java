package io.fabric8.openshift.types.deploy.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ExecNewPodHook is a hook implementation which runs a command in a new pod
 * based on the specified container which is assumed to be part of the
 * deployment template.
 */
@Value.Immutable
abstract class AbstractExecNewPodHook {
  /*
   * Command is the action command and its arguments.
   */
  @JsonProperty("command")
  public abstract java.util.List<String> getCommand();

  /*
   * Env is a set of environment variables to supply to the hook pod's container.
   */
  @JsonProperty("env")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.EnvVar> getEnv();

  /*
   * ContainerName is the name of a container in the deployment pod template
   * whose Docker image will be used for the hook pod's container.
   */
  @JsonProperty("containerName")
  public abstract String getContainerName();

  /*
   * Volumes is a list of named volumes from the pod template which should be
   * copied to the hook pod. Volumes names not found in pod spec are ignored.
   * An empty list means no volumes will be copied.
   */
  @JsonProperty("volumes")
  public abstract java.util.List<String> getVolumes();

}
