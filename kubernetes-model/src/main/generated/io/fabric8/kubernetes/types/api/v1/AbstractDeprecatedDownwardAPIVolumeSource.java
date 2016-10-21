package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeprecatedDownwardAPIVolumeSource represents a volume containing downward API info.
 * This type is deprecated and should be replaced by use of the downwardAPI volume source.
 */
@Value.Immutable
abstract class AbstractDeprecatedDownwardAPIVolumeSource {
  /*
   * Items is a list of downward API volume file
   */
  @JsonProperty("items")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.DeprecatedDownwardAPIVolumeFile> getItems();

}
