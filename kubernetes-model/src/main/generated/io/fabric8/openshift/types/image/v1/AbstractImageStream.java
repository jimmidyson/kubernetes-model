package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ImageStream stores a mapping of tags to images, metadata overrides that are applied
 * when images are tagged in a stream, and an optional reference to a Docker image
 * repository on a registry.
 */
@Value.Immutable
abstract class AbstractImageStream implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ImageStream", "v1");
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
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Spec describes the desired state of this stream
   */
  @JsonProperty("spec")
  public abstract io.fabric8.openshift.types.image.v1.ImageStreamSpec getSpec();

  /*
   * Status describes the current state of this stream
   */
  @JsonProperty("status")
  public abstract io.fabric8.openshift.types.image.v1.ImageStreamStatus getStatus();

}
