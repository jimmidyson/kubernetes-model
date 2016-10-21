package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SignatureGenericEntity holds a generic information about a person or entity who is an issuer or a subject
 * of signing certificate or key.
 */
@Value.Immutable
abstract class AbstractSignatureGenericEntity {
  /*
   * Organization name.
   */
  @JsonProperty("organization")
  public abstract String getOrganization();

  /*
   * Common name (e.g. openshift-signing-service).
   */
  @JsonProperty("commonName")
  public abstract String getCommonName();

}
