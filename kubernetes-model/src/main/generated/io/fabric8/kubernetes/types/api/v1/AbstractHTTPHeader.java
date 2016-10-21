package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * HTTPHeader describes a custom header to be used in HTTP probes
 */
@Value.Immutable
abstract class AbstractHTTPHeader {
  /*
   * The header field name
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * The header field value
   */
  @JsonProperty("value")
  public abstract String getValue();

}
