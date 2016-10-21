package io.fabric8.openshift.types.template.v1;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * Parameter defines a name/value variable that is to be processed during
 * the Template to Config transformation.
 */
@Value.Immutable
abstract class AbstractParameter {
  /*
   * Name must be set and it can be referenced in Template
   * Items using ${PARAMETER_NAME}. Required.
   */
  @JsonProperty("name")
  public abstract String getName();

  /*
   * Optional: The name that will show in UI instead of parameter 'Name'
   */
  @JsonProperty("displayName")
  public abstract String getDisplayName();

  /*
   * Description of a parameter. Optional.
   */
  @JsonProperty("description")
  public abstract String getDescription();

  /*
   * Value holds the Parameter data. If specified, the generator will be
   * ignored. The value replaces all occurrences of the Parameter ${Name}
   * expression during the Template to Config transformation. Optional.
   */
  @JsonProperty("value")
  public abstract String getValue();

  /*
   * generate specifies the generator to be used to generate random string
   * from an input value specified by From field. The result string is
   * stored into Value field. If empty, no generator is being used, leaving
   * the result Value untouched. Optional.
   * 
   * The only supported generator is "expression", which accepts a "from"
   * value in the form of a simple regular expression containing the
   * range expression "[a-zA-Z0-9]", and the length expression "a{length}".
   * 
   * Examples:
   * 
   * from             | value
   * -----------------------------
   * "test[0-9]{1}x"  | "test7x"
   * "[0-1]{8}"       | "01001100"
   * "0x[A-F0-9]{4}"  | "0xB3AF"
   * "[a-zA-Z0-9]{8}" | "hW4yQU5i"
   */
  @JsonProperty("generate")
  public abstract String getGenerate();

  /*
   * From is an input value for the generator. Optional.
   */
  @JsonProperty("from")
  public abstract String getFrom();

  /*
   * Optional: Indicates the parameter must have a value.  Defaults to false.
   */
  @JsonProperty("required")
  public abstract Boolean isRequired();

}
