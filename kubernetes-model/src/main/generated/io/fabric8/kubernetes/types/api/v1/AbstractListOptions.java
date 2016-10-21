package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ListOptions is the query options to a standard REST list call.
 */
@Value.Immutable
abstract class AbstractListOptions {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ListOptions", "v1");
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
   * A selector to restrict the list of returned objects by their labels.
   * Defaults to everything.
   */
  @JsonProperty("labelSelector")
  public abstract String getLabelSelector();

  /*
   * A selector to restrict the list of returned objects by their fields.
   * Defaults to everything.
   */
  @JsonProperty("fieldSelector")
  public abstract String getFieldSelector();

  /*
   * Watch for changes to the described resources and return them as a stream of
   * add, update, and remove notifications. Specify resourceVersion.
   */
  @JsonProperty("watch")
  public abstract Boolean isWatch();

  /*
   * When specified with a watch call, shows changes that occur after that particular version of a resource.
   * Defaults to changes from the beginning of history.
   */
  @JsonProperty("resourceVersion")
  public abstract String getResourceVersion();

  /*
   * Timeout for the list/watch call.
   */
  @JsonProperty("timeoutSeconds")
  public abstract Long getTimeoutSeconds();

}
