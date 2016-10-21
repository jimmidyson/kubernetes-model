package io.fabric8.openshift.types.template.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Template contains the inputs needed to produce a Config.
 */
@Value.Immutable
abstract class AbstractTemplate implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("Template", "v1");
  }

  @Value.Derived
  public String getApiVersion() {
    return getTypeMeta().getApiVersion();
  }

  @Value.Derived
  public String getKind() {
    return getTypeMeta().getKind();
  }

  /*
   * Standard object's metadata.
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * message is an optional instructional message that will
   * be displayed when this template is instantiated.
   * This field should inform the user how to utilize the newly created resources.
   * Parameter substitution will be performed on the message before being
   * displayed so that generated credentials and other parameters can be
   * included in the output.
   */
  @JsonProperty("message")
  public abstract String getMessage();

  /*
   * objects is an array of resources to include in this template.
   */
  @JsonProperty("objects")
  public abstract java.util.List<io.fabric8.kubernetes.types.api.HasMetadata> getObjects();

  /*
   * parameters is an optional array of Parameters used during the
   * Template to Config transformation.
   */
  @JsonProperty("parameters")
  public abstract java.util.List<io.fabric8.openshift.types.template.v1.Parameter> getParameters();

  /*
   * labels is a optional set of labels that are applied to every
   * object during the Template to Config transformation.
   */
  @JsonProperty("labels")
  public abstract java.util.Map<String, String> getLabels();

}
