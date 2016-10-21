package io.fabric8.openshift.types.authorization.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ResourceAccessReview is a means to request a list of which users and groups are authorized to perform the
 * action specified by spec
 */
@Value.Immutable
abstract class AbstractResourceAccessReview {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ResourceAccessReview", "v1");
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
   * Action describes the action being tested.
   */
  @JsonUnwrapped
  public abstract io.fabric8.openshift.types.authorization.v1.Action getAction();

}
