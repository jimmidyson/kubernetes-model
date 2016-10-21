package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * GroupKind specifies a Group and a Kind, but does not force a version.  This is useful for identifying
 * concepts during lookup stages without having partially valid types
 * 
 * +protobuf.options.(gogoproto.goproto_stringer)=false
 */
@Value.Immutable
abstract class AbstractGroupKind {

  @JsonProperty("Group")
  public abstract String getGroup();


  @JsonProperty("Kind")
  public abstract String getKind();

}
