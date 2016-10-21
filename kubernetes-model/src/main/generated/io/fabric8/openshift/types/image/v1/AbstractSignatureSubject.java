package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SignatureSubject holds information about a person or entity who created the signature.
 */
@Value.Immutable
abstract class AbstractSignatureSubject {

  @JsonUnwrapped
  public abstract io.fabric8.openshift.types.image.v1.SignatureGenericEntity getSignatureGenericEntity();

  /*
   * If present, it is a human readable key id of public key belonging to the subject used to verify image
   * signature. It should contain at least 64 lowest bits of public key's fingerprint (e.g.
   * 0x685ebe62bf278440).
   */
  @JsonProperty("publicKeyID")
  public abstract String getPublicKeyID();

}
