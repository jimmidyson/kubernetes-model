package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ServiceAccount binds together:
 * * a name, understood by users, and perhaps by peripheral systems, for an identity
 * * a principal that can be authenticated and authorized
 * * a set of secrets
 */
@Value.Immutable
abstract class AbstractServiceAccount implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ServiceAccount", "v1");
  }

  @Value.Derived
  public String getApiVersion() {
    return getTypeMeta().getApiVersion();
  }

  @Value.Derived
  public String getKind() {
    return getTypeMeta().getKind();
  }

  /*
   * Standard object's metadata.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#metadata
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Secrets is the list of secrets allowed to be used by pods running using this ServiceAccount.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/secrets.md
   */
  @JsonProperty("secrets")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.ObjectReference> getSecrets();

  /*
   * ImagePullSecrets is a list of references to secrets in the same namespace to use for pulling any images
   * in pods that reference this ServiceAccount. ImagePullSecrets are distinct from Secrets because Secrets
   * can be mounted in the pod, but ImagePullSecrets are only accessed by the kubelet.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/secrets.md#manually-specifying-an-imagepullsecret
   */
  @JsonProperty("imagePullSecrets")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.LocalObjectReference> getImagePullSecrets();

}
