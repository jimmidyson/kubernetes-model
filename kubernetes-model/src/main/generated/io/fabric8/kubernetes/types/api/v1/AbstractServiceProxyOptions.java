package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ServiceProxyOptions is the query options to a Service's proxy call.
 */
@Value.Immutable
abstract class AbstractServiceProxyOptions {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ServiceProxyOptions", "v1");
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
   * Path is the part of URLs that include service endpoints, suffixes,
   * and parameters to use for the current proxy request to service.
   * For example, the whole request URL is
   * http://localhost/api/v1/namespaces/kube-system/services/elasticsearch-logging/_search?q=user:kimchy.
   * Path is _search?q=user:kimchy.
   */
  @JsonProperty("path")
  public abstract String getPath();

}
