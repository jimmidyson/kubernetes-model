package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Duration is a wrapper around time.Duration which supports correct
 * marshaling to YAML and JSON. In particular, it marshals into strings, which
 * can be used as map keys in json.
 */
@Value.Immutable
abstract class AbstractDuration {

  @JsonProperty("Duration")
  public abstract Long getDuration();

}
