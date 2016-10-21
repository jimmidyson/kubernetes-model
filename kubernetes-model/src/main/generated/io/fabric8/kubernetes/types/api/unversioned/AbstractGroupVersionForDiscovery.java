package io.fabric8.kubernetes.types.api.unversioned;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * GroupVersion contains the "group/version" and "version" string of a version.
 * It is made a struct to keep extensiblity.
 */
@Value.Immutable
abstract class AbstractGroupVersionForDiscovery {
  /*
   * groupVersion specifies the API group and version in the form "group/version"
   */
  @JsonProperty("groupVersion")
  public abstract String getGroupVersion();

  /*
   * version specifies the version in the form of "version". This is to save
   * the clients the trouble of splitting the GroupVersion.
   */
  @JsonProperty("version")
  public abstract String getVersion();

}
