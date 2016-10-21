package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * BuildRequest is the resource used to pass parameters to build generator
 */
@Value.Immutable
abstract class AbstractBuildRequest implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("BuildRequest", "v1");
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
   * metadata for BuildRequest.
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * revision is the information from the source for a specific repo snapshot.
   */
  @JsonProperty("revision")
  public abstract io.fabric8.openshift.types.build.v1.SourceRevision getRevision();

  /*
   * triggeredByImage is the Image that triggered this build.
   */
  @JsonProperty("triggeredByImage")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getTriggeredByImage();

  /*
   * from is the reference to the ImageStreamTag that triggered the build.
   */
  @JsonProperty("from")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectReference getFrom();

  /*
   * binary indicates a request to build from a binary provided to the builder
   */
  @JsonProperty("binary")
  public abstract io.fabric8.openshift.types.build.v1.BinaryBuildSource getBinary();

  /*
   * lastVersion (optional) is the LastVersion of the BuildConfig that was used
   * to generate the build. If the BuildConfig in the generator doesn't match, a build will
   * not be generated.
   */
  @JsonProperty("lastVersion")
  public abstract Long getLastVersion();

  /*
   * env contains additional environment variables you want to pass into a builder container
   */
  @JsonProperty("env")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.EnvVar> getEnv();

  /*
   * triggeredBy describes which triggers started the most recent update to the
   * build configuration and contains information about those triggers.
   */
  @JsonProperty("triggeredBy")
  public abstract java.util.List<io.fabric8.openshift.types.build.v1.BuildTriggerCause> getTriggeredBy();

}
