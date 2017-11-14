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
package io.fabric8.kubernetes.types.api;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class RFC3339DateMicroDeserializer extends StdDeserializer<ZonedDateTime> {

  public static final String RFC3339_MICRO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX";

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(RFC3339_MICRO_FORMAT);

  public RFC3339DateMicroDeserializer() {
    this(null);
  }

  public RFC3339DateMicroDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public ZonedDateTime deserialize(JsonParser jsonparser, DeserializationContext context)
      throws IOException {
    return ZonedDateTime.parse(jsonparser.getText(), FORMATTER);
  }
}
