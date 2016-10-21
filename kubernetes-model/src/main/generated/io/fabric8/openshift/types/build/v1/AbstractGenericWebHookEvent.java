package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * GenericWebHookEvent is the payload expected for a generic webhook post
 */
@Value.Immutable
abstract class AbstractGenericWebHookEvent {
  /*
   * type is the type of source repository
   * +genconversion=false
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * git is the git information if the Type is BuildSourceGit
   */
  @JsonProperty("git")
  public abstract io.fabric8.openshift.types.build.v1.GitInfo getGit();

  /*
   * env contains additional environment variables you want to pass into a builder container
   */
  @JsonProperty("env")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.v1.EnvVar> getEnv();

}
