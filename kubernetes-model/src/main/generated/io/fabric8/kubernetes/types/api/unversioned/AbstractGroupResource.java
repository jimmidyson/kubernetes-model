package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * GroupResource specifies a Group and a Resource, but does not force a version.  This is useful for identifying
 * concepts during lookup stages without having partially valid types
 * 
 * +protobuf.options.(gogoproto.goproto_stringer)=false
 */
@Value.Immutable
abstract class AbstractGroupResource {

  @JsonProperty("Group")
  public abstract String getGroup();


  @JsonProperty("Resource")
  public abstract String getResource();

}
