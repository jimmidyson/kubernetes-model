package io.fabric8.openshift.types.authorization.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SelfSubjectRulesReview is a resource you can create to determine which actions you can perform in a namespace
 */
@Value.Immutable
abstract class AbstractSelfSubjectRulesReview {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("SelfSubjectRulesReview", "v1");
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
   * Spec adds information about how to conduct the check
   */
  @JsonProperty("spec")
  public abstract io.fabric8.openshift.types.authorization.v1.SelfSubjectRulesReviewSpec getSpec();

  /*
   * Status is completed by the server to tell which permissions you have
   */
  @JsonProperty("status")
  public abstract io.fabric8.openshift.types.authorization.v1.SubjectRulesReviewStatus getStatus();

}
