package io.fabric8.openshift.types.authorization.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Action describes a request to the API server
 */
@Value.Immutable
abstract class AbstractAction {
  /*
   * Namespace is the namespace of the action being requested.  Currently, there is no distinction between no namespace and all namespaces
   */
  @JsonProperty("namespace")
  public abstract String getNamespace();

  /*
   * Verb is one of: get, list, watch, create, update, delete
   */
  @JsonProperty("verb")
  public abstract String getVerb();

  /*
   * Group is the API group of the resource
   * Serialized as resourceAPIGroup to avoid confusion with the 'groups' field when inlined
   */
  @JsonProperty("resourceAPIGroup")
  public abstract String getResourceAPIGroup();

  /*
   * Version is the API version of the resource
   * Serialized as resourceAPIVersion to avoid confusion with TypeMeta.apiVersion and ObjectMeta.resourceVersion when inlined
   */
  @JsonProperty("resourceAPIVersion")
  public abstract String getResourceAPIVersion();

  /*
   * Resource is one of the existing resource types
   */
  @JsonProperty("resource")
  public abstract String getResource();

  /*
   * ResourceName is the name of the resource being requested for a "get" or deleted for a "delete"
   */
  @JsonProperty("resourceName")
  public abstract String getResourceName();

  /*
   * Content is the actual content of the request for create and update
   */
  @JsonProperty("content")
  public abstract io.fabric8.kubernetes.types.api.HasMetadata getContent();

}
