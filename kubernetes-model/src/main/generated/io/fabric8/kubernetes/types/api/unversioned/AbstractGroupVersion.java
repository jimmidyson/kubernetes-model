package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * GroupVersion contains the "group" and the "version", which uniquely identifies the API.
 * 
 * +protobuf.options.(gogoproto.goproto_stringer)=false
 */
@Value.Immutable
abstract class AbstractGroupVersion {

  @JsonProperty("Group")
  public abstract String getGroup();


  @JsonProperty("Version")
  public abstract String getVersion();

}
