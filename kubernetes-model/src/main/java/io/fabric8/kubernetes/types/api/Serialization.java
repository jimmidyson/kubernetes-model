package io.fabric8.kubernetes.types.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Serialization {

  private static final StdTypeResolverBuilder TYPE_RESOLVER_BUILDER = new StdTypeResolverBuilder().init(JsonTypeInfo.Id.NONE, new JacksonTypeIdResolver());

  private static final ObjectMapper JSON_MAPPER = new ObjectMapper()
      .registerModule(new Jdk8Module())
      .setDefaultTyping(TYPE_RESOLVER_BUILDER)
      .setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

  private static final ObjectMapper YAML_MAPPER = new ObjectMapper(
      new YAMLFactory()
          .configure(YAMLGenerator.Feature.MINIMIZE_QUOTES, true)
          .configure(YAMLGenerator.Feature.ALWAYS_QUOTE_NUMBERS_AS_STRINGS, true)
  )
      .registerModule(new Jdk8Module())
      .setDefaultTyping(TYPE_RESOLVER_BUILDER)
      .setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

  public static ObjectMapper yamlMapper() {
    return YAML_MAPPER;
  }

  public static ObjectMapper jsonMapper() {
    return JSON_MAPPER;
  }

  public static <T> String asYaml(T obj) {
    try {
      return YAML_MAPPER.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> String asJson(T obj) {
    try {
      return JSON_MAPPER.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> T unmarshal(InputStream is, Class<T> type) {
    try (BufferedInputStream bis = new BufferedInputStream(is)) {
      bis.mark(-1);
      int intch;
      do {
        intch = bis.read();
      } while (intch > -1 && Character.isWhitespace(intch));
      bis.reset();

      ObjectMapper mapper = JSON_MAPPER;
      if (intch != '{') {
        mapper = YAML_MAPPER;
      }
      return mapper.readValue(bis, type);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
