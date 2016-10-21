/*
 * *
 *  * Copyright (C) 2016 Red Hat, Inc.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *         http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package io.fabric8.kubernetes.types.util.intstr;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.io.IOException;

@Value.Immutable
@JsonSerialize(using = AbstractIntOrString.Serializer.class)
public abstract class AbstractIntOrString {

    public abstract Integer getIntVal();

    public abstract String getStrVal();

    public static class Serializer extends JsonSerializer<AbstractIntOrString> {

        @Override
        public void serialize(AbstractIntOrString value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            if (value != null) {
                Integer intValue = value.getIntVal();
                if (intValue != null) {
                    jgen.writeNumber(intValue);
                } else {
                    String stringValue = value.getStrVal();
                    if (stringValue != null) {
                        jgen.writeString(stringValue);
                    } else {
                        jgen.writeNull();
                    }
                }
            } else {
                jgen.writeNull();
            }
        }

    }

}
