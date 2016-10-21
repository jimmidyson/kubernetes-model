package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Maps a string key to a path within a volume.
 */
@Value.Immutable
abstract class AbstractKeyToPath {
  /*
   * The key to project.
   */
  @JsonProperty("key")
  public abstract String getKey();

  /*
   * The relative path of the file to map the key to.
   * May not be an absolute path.
   * May not contain the path element '..'.
   * May not start with the string '..'.
   */
  @JsonProperty("path")
  public abstract String getPath();

}
