package io.fabric8.kubernetes.types.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Style(
    deepImmutablesDetection = true,
    jdkOnly = true,
    visibility = Value.Style.ImplementationVisibility.PUBLIC,
    builderVisibility = Value.Style.BuilderVisibility.PUBLIC,
    defaultAsDefault = true,
    headerComments = true,
    depluralize = true,
    typeImmutable = "*",
    allParameters = true,
	from = "copyOf"
)
@JsonSerialize
public @interface ImmutablesStyle {
}
