package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * GenericWebHookCause holds information about a generic WebHook that
 * triggered a build.
 */
@Value.Immutable
abstract class AbstractGenericWebHookCause {
  /*
   * revision is an optional field that stores the git source revision
   * information of the generic webhook trigger when it is available.
   */
  @JsonProperty("revision")
  public abstract io.fabric8.openshift.types.build.v1.SourceRevision getRevision();

  /*
   * secret is the obfuscated webhook secret that triggered a build.
   */
  @JsonProperty("secret")
  public abstract String getSecret();

}
