package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ListMeta describes metadata that synthetic resources must have, including lists and
 * various status objects. A resource may have only one of {ObjectMeta, ListMeta}.
 */
@Value.Immutable
abstract class AbstractListMeta {
  /*
   * SelfLink is a URL representing this object.
   * Populated by the system.
   * Read-only.
   */
  @JsonProperty("selfLink")
  public abstract String getSelfLink();

  /*
   * String that identifies the server's internal version of this object that
   * can be used by clients to determine when objects have changed.
   * Value must be treated as opaque by clients and passed unmodified back to the server.
   * Populated by the system.
   * Read-only.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#concurrency-control-and-consistency
   */
  @JsonProperty("resourceVersion")
  public abstract String getResourceVersion();

}
