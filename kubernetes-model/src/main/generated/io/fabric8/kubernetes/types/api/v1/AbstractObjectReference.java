package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ObjectReference contains enough information to let you inspect or modify the referred object.
 */
@Value.Immutable
abstract class AbstractObjectReference {
  /*
   * Kind of the referent.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  public abstract String getKind();

  /*
   * Namespace of the referent.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/namespaces.md
   */
  @JsonProperty("namespace")
  public abstract String getNamespace();

  /*
   * Name of the referent.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/identifiers.md#names
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * UID of the referent.
   * More info: http://releases.k8s.io/release-1.3/docs/user-guide/identifiers.md#uids
   */
  @JsonProperty("uid")
  public abstract String getUid();

  /*
   * API version of the referent.
   */
  @JsonProperty("apiVersion")
  public abstract String getApiVersion();

  /*
   * Specific resourceVersion to which this reference is made, if any.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#concurrency-control-and-consistency
   */
  @JsonProperty("resourceVersion")
  public abstract String getResourceVersion();

  /*
   * If referring to a piece of an object instead of an entire object, this string
   * should contain a valid JSON/Go field access statement, such as desiredState.manifest.containers[2].
   * For example, if the object reference is to a container within a pod, this would take on a value like:
   * "spec.containers{name}" (where "name" refers to the name of the container that triggered
   * the event) or if no container name is specified "spec.containers[2]" (container with
   * index 2 in this pod). This syntax is chosen only to have some well-defined way of
   * referencing a part of an object.
   * TODO: this design is not final and this field is subject to change in the future.
   */
  @JsonProperty("fieldPath")
  public abstract String getFieldPath();

}
