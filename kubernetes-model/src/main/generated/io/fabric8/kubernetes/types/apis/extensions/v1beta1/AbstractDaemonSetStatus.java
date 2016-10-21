package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DaemonSetStatus represents the current status of a daemon set.
 */
@Value.Immutable
abstract class AbstractDaemonSetStatus {
  /*
   * CurrentNumberScheduled is the number of nodes that are running at least 1
   * daemon pod and are supposed to run the daemon pod.
   * More info: http://releases.k8s.io/release-1.3/docs/admin/daemons.md
   */
  @JsonProperty("currentNumberScheduled")
  public abstract Integer getCurrentNumberScheduled();

  /*
   * NumberMisscheduled is the number of nodes that are running the daemon pod, but are
   * not supposed to run the daemon pod.
   * More info: http://releases.k8s.io/release-1.3/docs/admin/daemons.md
   */
  @JsonProperty("numberMisscheduled")
  public abstract Integer getNumberMisscheduled();

  /*
   * DesiredNumberScheduled is the total number of nodes that should be running the daemon
   * pod (including nodes correctly running the daemon pod).
   * More info: http://releases.k8s.io/release-1.3/docs/admin/daemons.md
   */
  @JsonProperty("desiredNumberScheduled")
  public abstract Integer getDesiredNumberScheduled();

}
