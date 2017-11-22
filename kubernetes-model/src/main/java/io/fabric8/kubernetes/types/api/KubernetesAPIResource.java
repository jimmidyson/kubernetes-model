package io.fabric8.kubernetes.types.api;

import io.fabric8.kubernetes.types.apis.meta.v1.TypeMeta;

public interface KubernetesAPIResource {

  TypeMeta getTypeMeta();

}
