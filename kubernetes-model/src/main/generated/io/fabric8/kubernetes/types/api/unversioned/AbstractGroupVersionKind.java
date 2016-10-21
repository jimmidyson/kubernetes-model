package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * GroupVersionKind unambiguously identifies a kind.  It doesn't anonymously include GroupVersion
 * to avoid automatic coersion.  It doesn't use a GroupVersion to avoid custom marshalling
 * 
 * +protobuf.options.(gogoproto.goproto_stringer)=false
 */
@Value.Immutable
abstract class AbstractGroupVersionKind {

  @JsonProperty("Group")
  public abstract String getGroup();


  @JsonProperty("Version")
  public abstract String getVersion();


  @JsonProperty("Kind")
  public abstract String getKind();

}
