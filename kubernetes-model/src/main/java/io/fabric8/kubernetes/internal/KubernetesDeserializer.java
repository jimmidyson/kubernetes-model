/**
 * Copyright (C) 2011 Red Hat, Inc.
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
package io.fabric8.kubernetes.internal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.v1.KubernetesList;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class KubernetesDeserializer extends JsonDeserializer<KubernetesResource> {

  private static final String KIND = "kind";
  private static final String API_VERSION = "apiVersion";

  private static final String KUBERNETES_PACKAGE_PREFIX = "io.fabric8.kubernetes.api.model.";
  private static final String OPENSHIFT_PACKAGE_PREFIX = "io.fabric8.openshift.api.model.";
  private static final String[] OPENSHIFT_APIS = new String[]{"authorization", "build", "deploy", "image", "oauth", "project", "quota", "route", "sdn", "security", "template", "user"};

  private static final Map<String, Class<? extends KubernetesResource>> MAP = new HashMap<>();


  static {
    // Exceptions (not just package prefix + class name) can be added here.
    MAP.put("v1/List", KubernetesList.class);
  }

  private static Class getTypeForName(String name, String apiVersion) {
    String key = apiVersion + "/" + name;
    Class result = MAP.get(key);
    if (result == null) {
      String fullName = apiVersion.replace('/', '.') + "." + name;

      result = loadKindClassFromPackagesIfExists(fullName);
      if (result != null) {
        MAP.put(key, result);
      }
    }
    return result;
  }

  private static Class loadKindClassFromPackagesIfExists(String kind) {
    Class result = loadClassIfExists(KUBERNETES_PACKAGE_PREFIX + kind);
    if (result == null) {
      for (String api : OPENSHIFT_APIS) {
        result = loadClassIfExists(OPENSHIFT_PACKAGE_PREFIX + api + "." + kind);
        if (result != null) {
          break;
        }
      }
    }
    return result;
  }

  private static Class loadClassIfExists(String className) {
    try {
      return KubernetesDeserializer.class.getClassLoader().loadClass(className);
    } catch (Throwable t) {
      return null;
    }
  }

  @Override
  public KubernetesResource deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    ObjectNode node = jp.readValueAsTree();
    JsonNode kindNode = node.get(KIND);
    JsonNode apiVersionNode = node.get(API_VERSION);
    if (kindNode != null && apiVersionNode != null) {
      String kind = kindNode.textValue();
      String apiVersion = apiVersionNode.textValue();
      Class<? extends KubernetesResource> resourceType = getTypeForName(kind, apiVersion);
      if (resourceType == null) {
        throw ctxt.mappingException("No resource type found for kind: " + apiVersion + "/" + kind);
      } else {
        return jp.getCodec().treeToValue(node, resourceType);
      }
    }
    return null;
  }
}
