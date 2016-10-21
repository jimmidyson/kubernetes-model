package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Image is an immutable representation of a Docker image and metadata at a point in time.
 */
@Value.Immutable
abstract class AbstractImage implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("Image", "v1");
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
   * DockerImageReference is the string that can be used to pull this image.
   */
  @JsonProperty("dockerImageReference")
  public abstract String getDockerImageReference();

  /*
   * DockerImageMetadata contains metadata about this image
   */
  @JsonProperty("dockerImageMetadata")
  public abstract io.fabric8.kubernetes.types.api.HasMetadata getDockerImageMetadata();

  /*
   * DockerImageMetadataVersion conveys the version of the object, which if empty defaults to "1.0"
   */
  @JsonProperty("dockerImageMetadataVersion")
  public abstract String getDockerImageMetadataVersion();

  /*
   * DockerImageManifest is the raw JSON of the manifest
   */
  @JsonProperty("dockerImageManifest")
  public abstract String getDockerImageManifest();

  /*
   * DockerImageLayers represents the layers in the image. May not be set if the image does not define that data.
   */
  @JsonProperty("dockerImageLayers")
  public abstract java.util.List<io.fabric8.openshift.types.image.v1.ImageLayer> getDockerImageLayers();

  /*
   * Signatures holds all signatures of the image.
   */
  @JsonProperty("signatures")
  public abstract java.util.List<io.fabric8.openshift.types.image.v1.ImageSignature> getSignatures();

  /*
   * DockerImageSignatures provides the signatures as opaque blobs. This is a part of manifest schema v1.
   */
  @JsonProperty("dockerImageSignatures")
  public abstract java.util.List<java.util.List<Integer>> getDockerImageSignatures();

  /*
   * DockerImageManifestMediaType specifies the mediaType of manifest. This is a part of manifest schema v2.
   */
  @JsonProperty("dockerImageManifestMediaType")
  public abstract String getDockerImageManifestMediaType();

  /*
   * DockerImageConfig is a JSON blob that the runtime uses to set up the container. This is a part of manifest schema v2.
   */
  @JsonProperty("dockerImageConfig")
  public abstract String getDockerImageConfig();

}
