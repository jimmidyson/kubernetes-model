package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * NamespaceStatus is information about the current status of a Namespace.
 */
@Value.Immutable
abstract class AbstractNamespaceStatus {
  /*
   * Phase is the current lifecycle phase of the namespace.
   * More info: http://releases.k8s.io/release-1.3/docs/design/namespaces.md#phases
   */
  @JsonProperty("phase")
  public abstract String getPhase();

}
