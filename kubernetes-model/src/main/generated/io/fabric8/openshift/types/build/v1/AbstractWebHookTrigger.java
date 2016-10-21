package io.fabric8.openshift.types.build.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * WebHookTrigger is a trigger that gets invoked using a webhook type of post
 */
@Value.Immutable
abstract class AbstractWebHookTrigger {
  /*
   * secret used to validate requests.
   */
  @JsonProperty("secret")
  public abstract String getSecret();

  /*
   * allowEnv determines whether the webhook can set environment variables; can only
   * be set to true for GenericWebHook.
   */
  @JsonProperty("allowEnv")
  public abstract Boolean isAllowEnv();

}
