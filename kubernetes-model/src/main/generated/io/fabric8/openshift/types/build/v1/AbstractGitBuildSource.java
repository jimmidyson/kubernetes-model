package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * GitBuildSource defines the parameters of a Git SCM
 */
@Value.Immutable
abstract class AbstractGitBuildSource {
  /*
   * uri points to the source that will be built. The structure of the source
   * will depend on the type of build to run
   */
  @JsonProperty("uri")
  public abstract String getUri();

  /*
   * ref is the branch/tag/ref to build.
   */
  @JsonProperty("ref")
  public abstract String getRef();

  /*
   * httpProxy is a proxy used to reach the git repository over http
   */
  @JsonProperty("httpProxy")
  public abstract String getHttpProxy();

  /*
   * httpsProxy is a proxy used to reach the git repository over https
   */
  @JsonProperty("httpsProxy")
  public abstract String getHttpsProxy();

}
