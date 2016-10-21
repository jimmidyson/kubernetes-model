package io.fabric8.openshift.types.quota.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ClusterResourceQuotaSelector is used to select projects.  At least one of LabelSelector or AnnotationSelector
 * must present.  If only one is present, it is the only selection criteria.  If both are specified,
 * the project must match both restrictions.
 */
@Value.Immutable
abstract class AbstractClusterResourceQuotaSelector {
  /*
   * LabelSelector is used to select projects by label.
   */
  @JsonProperty("labels")
  public abstract io.fabric8.kubernetes.types.api.unversioned.LabelSelector getLabels();

  /*
   * AnnotationSelector is used to select projects by annotation.
   */
  @JsonProperty("annotations")
  public abstract java.util.Map<String, String> getAnnotations();

}
