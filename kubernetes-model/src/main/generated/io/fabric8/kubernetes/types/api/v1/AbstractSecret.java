package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Secret holds secret data of a certain type. The total bytes of the values in
 * the Data field must be less than MaxSecretSize bytes.
 */
@Value.Immutable
abstract class AbstractSecret implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("Secret", "v1");
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
   * Standard object's metadata.
   * More info: http://releases.k8s.io/release-1.3/docs/devel/api-conventions.md#metadata
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Data contains the secret data. Each key must be a valid DNS_SUBDOMAIN
   * or leading dot followed by valid DNS_SUBDOMAIN.
   * The serialized form of the secret data is a base64 encoded string,
   * representing the arbitrary (possibly non-string) data value here.
   * Described in https://tools.ietf.org/html/rfc4648#section-4
   */
  @JsonProperty("data")
  public abstract java.util.Map<String, java.util.List<Integer>> getData();

  /*
   * stringData allows specifying non-binary secret data in string form.
   * It is provided as a write-only convenience method.
   * All keys and values are merged into the data field on write, overwriting any existing values.
   * It is never output when reading from the API.
   * +genconversion=false
   */
  @JsonProperty("stringData")
  public abstract java.util.Map<String, String> getStringData();

  /*
   * Used to facilitate programmatic handling of secret data.
   */
  @JsonProperty("type")
  public abstract String getType();

}
