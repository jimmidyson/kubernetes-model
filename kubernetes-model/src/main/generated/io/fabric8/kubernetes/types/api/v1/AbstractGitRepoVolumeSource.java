package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Represents a volume that is populated with the contents of a git repository.
 * Git repo volumes do not support ownership management.
 * Git repo volumes support SELinux relabeling.
 */
@Value.Immutable
abstract class AbstractGitRepoVolumeSource {
  /*
   * Repository URL
   */
  @JsonProperty("repository")
  public abstract String getRepository();

  /*
   * Commit hash for the specified revision.
   */
  @JsonProperty("revision")
  public abstract String getRevision();

  /*
   * Target directory name.
   * Must not contain or start with '..'.  If '.' is supplied, the volume directory will be the
   * git repository.  Otherwise, if specified, the volume will contain the git repository in
   * the subdirectory with the given name.
   */
  @JsonProperty("directory")
  public abstract String getDirectory();

}
