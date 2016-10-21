package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * BuildStrategy contains the details of how to perform a build.
 */
@Value.Immutable
abstract class AbstractBuildStrategy {
  /*
   * type is the kind of build strategy.
   * +genconversion=false
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * dockerStrategy holds the parameters to the Docker build strategy.
   */
  @JsonProperty("dockerStrategy")
  public abstract io.fabric8.openshift.types.build.v1.DockerBuildStrategy getDockerStrategy();

  /*
   * sourceStrategy holds the parameters to the Source build strategy.
   */
  @JsonProperty("sourceStrategy")
  public abstract io.fabric8.openshift.types.build.v1.SourceBuildStrategy getSourceStrategy();

  /*
   * customStrategy holds the parameters to the Custom build strategy
   */
  @JsonProperty("customStrategy")
  public abstract io.fabric8.openshift.types.build.v1.CustomBuildStrategy getCustomStrategy();

  /*
   * JenkinsPipelineStrategy holds the parameters to the Jenkins Pipeline build strategy.
   * This strategy is in tech preview.
   */
  @JsonProperty("jenkinsPipelineStrategy")
  public abstract io.fabric8.openshift.types.build.v1.JenkinsPipelineBuildStrategy getJenkinsPipelineStrategy();

}
