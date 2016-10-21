package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DownwardAPIVolumeSource represents a volume containing downward API info.
 * Downward API volumes support ownership management and SELinux relabeling.
 */
@Value.Immutable
abstract class AbstractDownwardAPIVolumeSource {
  /*
   * Items is a list of downward API volume file
   */
  @JsonProperty("items")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.DownwardAPIVolumeFile> getItems();

}
