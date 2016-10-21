package io.fabric8.openshift.types.authorization.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SelfSubjectRulesReviewSpec adds information about how to conduct the check
 */
@Value.Immutable
abstract class AbstractSelfSubjectRulesReviewSpec {
  /*
   * Scopes to use for the evaluation.  Empty means "use the unscoped (full) permissions of the user/groups".
   * Nil means "use the scopes on this request".
   */
  @JsonProperty("scopes")
  public abstract java.util.List<String> getScopes();

}
