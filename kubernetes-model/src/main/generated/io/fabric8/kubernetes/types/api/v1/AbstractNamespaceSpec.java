package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * NamespaceSpec describes the attributes on a Namespace.
 */
@Value.Immutable
abstract class AbstractNamespaceSpec {
  /*
   * Finalizers is an opaque list of values that must be empty to permanently remove object from storage.
   * More info: http://releases.k8s.io/release-1.3/docs/design/namespaces.md#finalizers
   */
  @JsonProperty("finalizers")
  public abstract java.util.List<String> getFinalizers();

}
