package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PodExecOptions is the query options to a Pod's remote exec call.
 * ---
 * TODO: This is largely identical to PodAttachOptions above, make sure they stay in sync and see about merging
 * and also when we cut V2, we should export a "StreamOptions" or somesuch that contains Stdin, Stdout, Stder and TTY
 */
@Value.Immutable
abstract class AbstractPodExecOptions {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("PodExecOptions", "v1");
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
   * Redirect the standard input stream of the pod for this call.
   * Defaults to false.
   */
  @JsonProperty("stdin")
  public abstract Boolean isStdin();

  /*
   * Redirect the standard output stream of the pod for this call.
   * Defaults to true.
   */
  @JsonProperty("stdout")
  public abstract Boolean isStdout();

  /*
   * Redirect the standard error stream of the pod for this call.
   * Defaults to true.
   */
  @JsonProperty("stderr")
  public abstract Boolean isStderr();

  /*
   * TTY if true indicates that a tty will be allocated for the exec call.
   * Defaults to false.
   */
  @JsonProperty("tty")
  public abstract Boolean isTty();

  /*
   * Container in which to execute the command.
   * Defaults to only container if there is only one container in the pod.
   */
  @JsonProperty("container")
  public abstract String getContainer();

  /*
   * Command is the remote command to execute. argv array. Not executed within a shell.
   */
  @JsonProperty("command")
  public abstract java.util.List<String> getCommand();

}
