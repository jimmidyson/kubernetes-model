package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * PodAttachOptions is the query options to a Pod's remote attach call.
 * ---
 * TODO: merge w/ PodExecOptions below for stdin, stdout, etc
 * and also when we cut V2, we should export a "StreamOptions" or somesuch that contains Stdin, Stdout, Stder and TTY
 */
@Value.Immutable
abstract class AbstractPodAttachOptions {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("PodAttachOptions", "v1");
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
   * Stdin if true, redirects the standard input stream of the pod for this call.
   * Defaults to false.
   */
  @JsonProperty("stdin")
  public abstract Boolean isStdin();

  /*
   * Stdout if true indicates that stdout is to be redirected for the attach call.
   * Defaults to true.
   */
  @JsonProperty("stdout")
  public abstract Boolean isStdout();

  /*
   * Stderr if true indicates that stderr is to be redirected for the attach call.
   * Defaults to true.
   */
  @JsonProperty("stderr")
  public abstract Boolean isStderr();

  /*
   * TTY if true indicates that a tty will be allocated for the attach call.
   * This is passed through the container runtime so the tty
   * is allocated on the worker node by the container runtime.
   * Defaults to false.
   */
  @JsonProperty("tty")
  public abstract Boolean isTty();

  /*
   * The container in which to execute the command.
   * Defaults to only container if there is only one container in the pod.
   */
  @JsonProperty("container")
  public abstract String getContainer();

}
