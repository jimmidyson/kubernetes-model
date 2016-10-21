package io.fabric8.kubernetes.types.api.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * EnvVar represents an environment variable present in a Container.
 */
@Value.Immutable
abstract class AbstractEnvVar {
  /*
   * Name of the environment variable. Must be a C_IDENTIFIER.
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * Variable references $(VAR_NAME) are expanded
   * using the previous defined environment variables in the container and
   * any service environment variables. If a variable cannot be resolved,
   * the reference in the input string will be unchanged. The $(VAR_NAME)
   * syntax can be escaped with a double $$, ie: $$(VAR_NAME). Escaped
   * references will never be expanded, regardless of whether the variable
   * exists or not.
   * Defaults to "".
   */
  @JsonProperty("value")
  public abstract String getValue();

  /*
   * Source for the environment variable's value. Cannot be used if value is not empty.
   */
  @JsonProperty("valueFrom")
  public abstract io.fabric8.kubernetes.types.api.v1.EnvVarSource getValueFrom();

}
