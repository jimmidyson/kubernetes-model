package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Build encapsulates the inputs needed to produce a new deployable image, as well as
 * the status of the execution and a reference to the Pod which executed the build.
 */
@Value.Immutable
abstract class AbstractBuild implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("Build", "v1");
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
   * spec is all the inputs used to execute the build.
   */
  @JsonProperty("spec")
  public abstract io.fabric8.openshift.types.build.v1.BuildSpec getSpec();

  /*
   * status is the current status of the build.
   */
  @JsonProperty("status")
  public abstract io.fabric8.openshift.types.build.v1.BuildStatus getStatus();

}
