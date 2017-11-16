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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Optional;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface GenerateClient {

  boolean generate() default true;

  boolean nonNamespaced() default false;

  boolean noStatus() default false;

  boolean noVerbs() default false;

  String[] skipVerbs() default {};

  Extension[] extensions() default {};

  @interface Extension {

    String verbName();

    String verbType();

    String subresourcePath() default "";

    Class<?> inputType() default Object.class;;

    Class<?> resultType() default Object.class;

  }

}
