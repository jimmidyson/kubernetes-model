package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * EventSource contains information for an event.
 */
@Value.Immutable
abstract class AbstractEventSource {
  /*
   * Component from which the event is generated.
   */
  @JsonProperty("component")
  public abstract String getComponent();

  /*
   * Host name on which the event is generated.
   */
  @JsonProperty("host")
  public abstract String getHost();

}
