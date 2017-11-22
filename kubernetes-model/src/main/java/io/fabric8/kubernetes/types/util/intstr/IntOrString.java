/*
 * Copyright (C) 2017 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.types.util.intstr;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Optional;
import java.util.OptionalInt;

@JsonSerialize(using = IntOrString.Serializer.class)
@JsonDeserialize(using = IntOrString.Deserializer.class)
public class IntOrString {

  private final OptionalInt intVal;

  private final Optional<String> strVal;

  public IntOrString(int intVal) {
    this.intVal = OptionalInt.of(intVal);
    this.strVal = Optional.empty();
  }

  public IntOrString(String strVal) {
    this.intVal = OptionalInt.empty();
    this.strVal = Optional.of(strVal);
  }

  public OptionalInt getIntVal() {
    return intVal;
  }

  public Optional<String> getStrVal() {
    return strVal;
  }

  public static class Serializer extends JsonSerializer<IntOrString> {

    @Override
    public void serialize(IntOrString value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
      if (value != null) {
        if (value.getIntVal().isPresent()) {
          jgen.writeNumber(value.getIntVal().getAsInt());
          return;
        }
        if (value.getStrVal().isPresent()) {
          jgen.writeString(value.getStrVal().get());
          return;
        }
      }
      jgen.writeNull();
    }

  }

  public static class Deserializer extends JsonDeserializer<IntOrString> {

    @Override
    public IntOrString deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
      ObjectCodec oc = jsonParser.getCodec();
      JsonNode node = oc.readTree(jsonParser);
      if (node.isInt()) {
        return new IntOrString(node.asInt());
      } else {
        return new IntOrString(node.asText());
      }
    }

  }

}
