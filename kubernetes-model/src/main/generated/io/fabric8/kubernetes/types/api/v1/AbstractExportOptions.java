package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ExportOptions is the query options to the standard REST get call.
 */
@Value.Immutable
abstract class AbstractExportOptions {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ExportOptions", "v1");
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
   * Should this value be exported.  Export strips fields that a user can not specify.
   */
  @JsonProperty("export")
  public abstract Boolean isExport();

  /*
   * Should the export be exact.  Exact export maintains cluster-specific fields like 'Namespace'
   */
  @JsonProperty("exact")
  public abstract Boolean isExact();

}
