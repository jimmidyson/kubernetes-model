package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * ImageSignature holds a signature of an image. It allows to verify image identity and possibly other claims
 * as long as the signature is trusted. Based on this information it is possible to restrict runnable images
 * to those matching cluster-wide policy.
 * Mandatory fields should be parsed by clients doing image verification. The others are parsed from
 * signature's content by the server. They serve just an informative purpose.
 */
@Value.Immutable
abstract class AbstractImageSignature implements io.fabric8.kubernetes.types.api.HasMetadata {

  @JsonUnwrapped
  @Value.Derived
  public io.fabric8.kubernetes.types.api.unversioned.TypeMeta getTypeMeta() {
    return io.fabric8.kubernetes.types.api.unversioned.TypeMeta.of("ImageSignature", "v1");
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
   */
  @JsonProperty("metadata")
  public abstract io.fabric8.kubernetes.types.api.v1.ObjectMeta getMetadata();

  /*
   * Required: Describes a type of stored blob.
   */
  @JsonProperty("type")
  public abstract String getType();

  /*
   * Required: An opaque binary string which is an image's signature.
   */
  @JsonProperty("content")
  public abstract java.util.List<Integer> getContent();

  /*
   * Conditions represent the latest available observations of a signature's current state.
   */
  @JsonProperty("conditions")
  public abstract java.util.List<io.fabric8.openshift.types.image.v1.SignatureCondition> getConditions();

  /*
   * A human readable string representing image's identity. It could be a product name and version, or an
   * image pull spec (e.g. "registry.access.redhat.com/rhel7/rhel:7.2").
   */
  @JsonProperty("imageIdentity")
  public abstract String getImageIdentity();

  /*
   * Contains claims from the signature.
   */
  @JsonProperty("signedClaims")
  public abstract java.util.Map<String, String> getSignedClaims();

  /*
   * If specified, it is the time of signature's creation.
   */
  @JsonProperty("created")
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC")
  public abstract java.util.Date getCreated();

  /*
   * If specified, it holds information about an issuer of signing certificate or key (a person or entity
   * who signed the signing certificate or key).
   */
  @JsonProperty("issuedBy")
  public abstract io.fabric8.openshift.types.image.v1.SignatureIssuer getIssuedBy();

  /*
   * If specified, it holds information about a subject of signing certificate or key (a person or entity
   * who signed the image).
   */
  @JsonProperty("issuedTo")
  public abstract io.fabric8.openshift.types.image.v1.SignatureSubject getIssuedTo();

}
