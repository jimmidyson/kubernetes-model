package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * HTTPIngressPath associates a path regex with a backend. Incoming urls matching
 * the path are forwarded to the backend.
 */
@Value.Immutable
abstract class AbstractHTTPIngressPath {
  /*
   * Path is a extended POSIX regex as defined by IEEE Std 1003.1,
   * (i.e this follows the egrep/unix syntax, not the perl syntax)
   * matched against the path of an incoming request. Currently it can
   * contain characters disallowed from the conventional "path"
   * part of a URL as defined by RFC 3986. Paths must begin with
   * a '/'. If unspecified, the path defaults to a catch all sending
   * traffic to the backend.
   */
  @JsonProperty("path")
  public abstract String getPath();

  /*
   * Backend defines the referenced service endpoint to which the traffic
   * will be forwarded to.
   */
  @JsonProperty("backend")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.IngressBackend getBackend();

}
