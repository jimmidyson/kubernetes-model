package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DockerImageReference points to a Docker image.
 */
@Value.Immutable
abstract class AbstractDockerImageReference {
  /*
   * Registry is the registry that contains the Docker image
   */
  @JsonProperty("Registry")
  public abstract String getRegistry();

  /*
   * Namespace is the namespace that contains the Docker image
   */
  @JsonProperty("Namespace")
  public abstract String getNamespace();

  /*
   * Name is the name of the Docker image
   */
  @JsonProperty("Name")
  public abstract String getName();

  /*
   * Tag is which tag of the Docker image is being referenced
   */
  @JsonProperty("Tag")
  public abstract String getTag();

  /*
   * ID is the identifier for the Docker image
   */
  @JsonProperty("ID")
  public abstract String getID();

}
