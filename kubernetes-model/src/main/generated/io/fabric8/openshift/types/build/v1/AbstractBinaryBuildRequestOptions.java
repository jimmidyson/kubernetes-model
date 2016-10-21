package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * BinaryBuildRequestOptions are the options required to fully speficy a binary build request
 */
@Value.Immutable
abstract class AbstractBinaryBuildRequestOptions implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("BinaryBuildRequestOptions", "v1");
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
   * metadata for BinaryBuildRequestOptions.
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * asFile determines if the binary should be created as a file within the source rather than extracted as an archive
   */
  @JsonProperty("asFile")
  public abstract String getAsFile();

  /*
   * revision.commit is the value identifying a specific commit
   */
  @JsonProperty("revision.commit")
  public abstract String getRevisionCommit();

  /*
   * revision.message is the description of a specific commit
   */
  @JsonProperty("revision.message")
  public abstract String getRevisionMessage();

  /*
   * revision.authorName of the source control user
   */
  @JsonProperty("revision.authorName")
  public abstract String getRevisionAuthorName();

  /*
   * revision.authorEmail of the source control user
   */
  @JsonProperty("revision.authorEmail")
  public abstract String getRevisionAuthorEmail();

  /*
   * revision.committerName of the source control user
   */
  @JsonProperty("revision.committerName")
  public abstract String getRevisionCommitterName();

  /*
   * revision.committerEmail of the source control user
   */
  @JsonProperty("revision.committerEmail")
  public abstract String getRevisionCommitterEmail();

}
