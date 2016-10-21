package io.fabric8.openshift.types.authorization.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SubjectRulesReviewStatus is contains the result of a rules check
 */
@Value.Immutable
abstract class AbstractSubjectRulesReviewStatus {
  /*
   * Rules is the list of rules (no particular sort) that are allowed for the subject
   */
  @JsonProperty("rules")
  public abstract java.util.List<io.fabric8.openshift.types.authorization.v1.PolicyRule> getRules();

  /*
   * EvaluationError can appear in combination with Rules.  It means some error happened during evaluation
   * that may have prevented additional rules from being populated.
   */
  @JsonProperty("evaluationError")
  public abstract String getEvaluationError();

}
