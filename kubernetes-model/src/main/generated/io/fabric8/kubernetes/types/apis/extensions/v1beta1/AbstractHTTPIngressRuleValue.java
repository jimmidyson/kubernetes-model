package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * HTTPIngressRuleValue is a list of http selectors pointing to backends.
 * In the example: http://<host>/<path>?<searchpart> -> backend where
 * where parts of the url correspond to RFC 3986, this resource will be used
 * to match against everything after the last '/' and before the first '?'
 * or '#'.
 */
@Value.Immutable
abstract class AbstractHTTPIngressRuleValue {
  /*
   * A collection of paths that map requests to backends.
   */
  @JsonProperty("paths")
  public abstract java.util.List<io.fabric8.kubernetes.types.apis.extensions.v1beta1.HTTPIngressPath> getPaths();

}
