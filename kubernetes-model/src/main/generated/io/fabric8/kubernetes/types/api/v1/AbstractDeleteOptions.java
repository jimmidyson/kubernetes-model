package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * DeleteOptions may be provided when deleting an API object
 */
@Value.Immutable
abstract class AbstractDeleteOptions {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("DeleteOptions", "v1");
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
   * The duration in seconds before the object should be deleted. Value must be non-negative integer.
   * The value zero indicates delete immediately. If this value is nil, the default grace period for the
   * specified type will be used.
   * Defaults to a per object value if not specified. zero means delete immediately.
   */
  @JsonProperty("gracePeriodSeconds")
  public abstract Long getGracePeriodSeconds();

  /*
   * Must be fulfilled before a deletion is carried out. If not possible, a 409 Conflict status will be
   * returned.
   */
  @JsonProperty("preconditions")
  public abstract io.fabric8.kubernetes.types.api.v1.Preconditions getPreconditions();

  /*
   * Should the dependent objects be orphaned. If true/false, the "orphan"
   * finalizer will be added to/removed from the object's finalizers list.
   */
  @JsonProperty("orphanDependents")
  public abstract Boolean isOrphanDependents();

}
