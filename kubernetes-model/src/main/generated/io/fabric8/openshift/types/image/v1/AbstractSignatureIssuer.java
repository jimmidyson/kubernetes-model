package io.fabric8.openshift.types.image.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * SignatureIssuer holds information about an issuer of signing certificate or key.
 */
@Value.Immutable
abstract class AbstractSignatureIssuer {

  @JsonUnwrapped
  public abstract io.fabric8.openshift.types.image.v1.SignatureGenericEntity getSignatureGenericEntity();

}
