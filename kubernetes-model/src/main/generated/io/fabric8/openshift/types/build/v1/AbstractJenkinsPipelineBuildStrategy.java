package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * JenkinsPipelineBuildStrategy holds parameters specific to a Jenkins Pipeline build.
 * This strategy is in tech preview.
 */
@Value.Immutable
abstract class AbstractJenkinsPipelineBuildStrategy {
  /*
   * JenkinsfilePath is the optional path of the Jenkinsfile that will be used to configure the pipeline
   * relative to the root of the context (contextDir). If both JenkinsfilePath & Jenkinsfile are
   * both not specified, this defaults to Jenkinsfile in the root of the specified contextDir.
   */
  @JsonProperty("jenkinsfilePath")
  public abstract String getJenkinsfilePath();

  /*
   * Jenkinsfile defines the optional raw contents of a Jenkinsfile which defines a Jenkins pipeline build.
   */
  @JsonProperty("jenkinsfile")
  public abstract String getJenkinsfile();

}
