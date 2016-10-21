package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ImageStreamImport imports an image from remote repositories into OpenShift.
 */
@Value.Immutable
abstract class AbstractImageStreamImport implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ImageStreamImport", "v1");
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
   * Spec is a description of the images that the user wishes to import
   */
  @JsonProperty("spec")
  public abstract io.fabric8.openshift.types.image.v1.ImageStreamImportSpec getSpec();

  /*
   * Status is the the result of importing the image
   */
  @JsonProperty("status")
  public abstract io.fabric8.openshift.types.image.v1.ImageStreamImportStatus getStatus();

}
