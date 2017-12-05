package io.fabric8.kubernetes.types.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.fabric8.kubernetes.types.apis.meta.v1.TypeMeta;

public interface KubernetesAPIResource {

  TypeMeta getTypeMeta();

  @JsonIgnore
  default String getApiVersion() {
    return getTypeMeta().getApiVersion().orElse("{{apiVersion $loaderPackage $goPackage}}");
  }

  @JsonIgnore
  default String getKind() {
    return getTypeMeta().getKind().orElse("{{$className}}");
  }

}
