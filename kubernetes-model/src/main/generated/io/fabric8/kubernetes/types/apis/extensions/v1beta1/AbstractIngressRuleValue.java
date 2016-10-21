package io.fabric8.kubernetes.types.apis.extensions.v1beta1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * IngressRuleValue represents a rule to apply against incoming requests. If the
 * rule is satisfied, the request is routed to the specified backend. Currently
 * mixing different types of rules in a single Ingress is disallowed, so exactly
 * one of the following must be set.
 */
@Value.Immutable
abstract class AbstractIngressRuleValue {

  @JsonProperty("http")
  public abstract io.fabric8.kubernetes.types.apis.extensions.v1beta1.HTTPIngressRuleValue getHttp();

}
