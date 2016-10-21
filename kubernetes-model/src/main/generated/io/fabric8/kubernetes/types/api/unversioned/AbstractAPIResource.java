package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * APIResource specifies the name of a resource and whether it is namespaced.
 */
@Value.Immutable
abstract class AbstractAPIResource {
  /*
   * name is the name of the resource.
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * namespaced indicates if a resource is namespaced or not.
   */
  @JsonProperty("namespaced")
  public abstract Boolean isNamespaced();

  /*
   * kind is the kind for the resource (e.g. 'Foo' is the kind for a resource 'foo')
   */
  @JsonProperty("kind")
  public abstract String getKind();

}
