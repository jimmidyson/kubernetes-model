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

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JacksonTypeIdResolver extends TypeIdResolverBase {

  private final Map<String, Class<?>> apiToClassMap = new HashMap<>();
  private final Map<Class<?>, String> classToApiMap = new HashMap<>();

  @Override
  public void init(JavaType bt) {
    new FastClasspathScanner("io.fabric8.kubernetes.types", "io.fabric8.openshift.types")
        .matchClassesWithAnnotation(KubernetesType.class, (c) -> {
          KubernetesType kt = c.getAnnotation(KubernetesType.class);
          String apiGroupVersion = String.join("/", kt.apiGroup(), kt.apiVersion());
          apiToClassMap.put(apiGroupVersion, c);
          classToApiMap.put(c, apiGroupVersion);
        })
        .scan();
  }

  @Override
  public String idFromValue(Object obj) {
    return idFromValueAndType(obj, obj.getClass());
  }

  @Override
  public String idFromValueAndType(Object value, Class<?> suggestedType) {
    return classToApiMap.get(suggestedType);
  }

  @Override
  public JavaType typeFromId(DatabindContext context, String id) {
    return context.constructType(apiToClassMap.get(id));
  }

  @Override
  public JsonTypeInfo.Id getMechanism() {
    return JsonTypeInfo.Id.CUSTOM;
  }

}
