package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * BuildConfig is a template which can be used to create new builds.
 */
@Value.Immutable
abstract class AbstractBuildConfig implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("BuildConfig", "v1");
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
   * metadata for BuildConfig.
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * spec holds all the input necessary to produce a new build, and the conditions when
   * to trigger them.
   */
  @JsonProperty("spec")
  public abstract io.fabric8.openshift.types.build.v1.BuildConfigSpec getSpec();

  /*
   * status holds any relevant information about a build config
   */
  @JsonProperty("status")
  public abstract io.fabric8.openshift.types.build.v1.BuildConfigStatus getStatus();

}
