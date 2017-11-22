package generator

import (
	"fmt"
	"io/ioutil"
	"os"
	"path"
	"path/filepath"
	"regexp"
	"strings"
	"text/template"
	"unicode"
	"unicode/utf8"

	"github.com/pkg/errors"
	codegenutils "k8s.io/code-generator/cmd/client-gen/generators/util"

	"github.com/fabric8io/kubernetes-model/pkg/loader"
)

const immutableTemplateText = `/*
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
package {{.JavaPackage}};

import org.immutables.value.Value;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;{{if .Tags.GenerateClient}}
import io.fabric8.kubernetes.types.api.GenerateClient;{{if .Tags.Extensions}}
import io.fabric8.kubernetes.types.api.GenerateClient.Extension;{{end}}
{{end}}

{{if .Doc}}{{comment .Doc ""}}{{end}}
@Value.Immutable
@JsonSerialize(as = Immutable{{.ClassName}}.class)
@JsonDeserialize(builder = {{.ClassName}}.Builder.class)
@JsonPropertyOrder({{"{"}}{{jsonPropertyOrder .Fields}}{{"}"}}){{if .Tags.GenerateClient}}
@GenerateClient{{generateClientTags .Tags .RootPackage .JavaPackage}}{{end}}
public abstract class {{.ClassName}} implements With{{.ClassName}}{{if .HasMetadata}}, io.fabric8.kubernetes.types.api.HasMetadata{{end}}{{" {"}}{{$className := .ClassName}}{{$loaderPackage := .LoaderPackage}}{{$goPackage := .GoPackage}}{{$fieldsLen := len .Fields}}{{range .Fields}}
{{if .Doc}}
{{comment .Doc "  "}}{{end}}{{if eq .Name ""}}{{if typeName .Type | ne "TypeMeta"}}
  @JsonUnwrapped{{end}}{{else}}{{if typeName .Type | ne "TypeMeta"}}
  @JsonProperty("{{.Name}}"){{end}}{{end}}{{if typeName .Type | ne "TypeMeta"}}{{if eq .Type "java.time.ZonedDateTime"}}
  @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.class)
  @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = io.fabric8.kubernetes.types.api.RFC3339DateDeserializer.RFC3339_FORMAT, timezone="UTC"){{end}}
  public abstract {{if .Optional}}{{if notCollectionType .Type}}java.util.Optional<{{end}}{{end}}{{.Type}}{{if .Optional}}{{if notCollectionType .Type}}>{{end}}{{end}} {{if eq .Type "Boolean"}}is{{else}}get{{end}}{{if .Name}}{{upperFirst .Name | sanitize}}{{else}}{{typeName .Type | upperFirst | sanitize}}{{end}}();{{else}}
  @Value.Default
  @JsonUnwrapped
  public {{.Type}} get{{typeName .Type}}() {
    return new {{.Type}}.Builder().kind("{{$className}}").apiVersion("{{apiVersion $loaderPackage $goPackage}}").build();
  }

  @Value.Auxiliary
  @JsonIgnore
  public String getApiVersion() {
    return getTypeMeta().getApiVersion().orElse("{{apiVersion $loaderPackage $goPackage}}");
  }

  @Value.Auxiliary
  @JsonIgnore
  public String getKind() {
    return getTypeMeta().getKind().orElse("{{$className}}");
  }{{end}}{{end}}

  public static final class Builder extends Immutable{{.ClassName}}.Builder {}
}
`

var (
	startOfLineRegexp   = regexp.MustCompile(`(?m:^)`)
	trailingSpaceRegexp = regexp.MustCompile(`(?m:[\t ]+$)`)
)

var immutableTemplate = template.Must(template.New("immutable").
	Funcs(
		template.FuncMap{
			"comment": func(doc string, indent string) string {
				doc = strings.Replace(strings.Replace(doc, "/", "&#47;", -1), "\t", "  ", -1)
				return trailingSpaceRegexp.ReplaceAllString(indent+"/*\n"+startOfLineRegexp.ReplaceAllString(doc, indent+" * ")+"\n"+indent+" */", "")
			},
			"typeName": func(s string) string {
				lastDotIndex := strings.LastIndex(s, ".")
				if lastDotIndex >= 0 {
					return s[lastDotIndex+1:]
				} else {
					return s
				}
			},
			"packageName": func(s string) string {
				lastDotIndex := strings.LastIndex(s, ".")
				if lastDotIndex >= 0 {
					return s[:lastDotIndex]
				} else {
					return s
				}
			},
			"upperFirst": func(s string) string {
				if s == "" {
					return ""
				}
				r, n := utf8.DecodeRuneInString(s)
				return string(unicode.ToUpper(r)) + s[n:]
			},
			"apiVersion": func(pkg loader.Package, s string) string {
				apiVersion := path.Base(s)
				apiGroup := pkg.APIGroup
				if apiGroup != "" {
					apiVersion = apiGroup + "/" + apiVersion
				}
				return apiVersion
			},
			"sanitize": func(s string) string {
				res := ""
				splitRes := strings.Split(s, ".")
				for i, spl := range splitRes {
					if i > 0 {
						if len(spl) > 0 {
							r, n := utf8.DecodeRuneInString(spl)
							spl = string(unicode.ToUpper(r)) + spl[n:]
						}
					}
					res += spl
				}
				return res
			},
			"notCollectionType": func(s string) bool {
				return !strings.HasPrefix(s, "java.util.List") && !strings.HasPrefix(s, "java.util.Map") && !strings.HasPrefix(s, "java.util.Set")
			},
			"jsonPropertyOrder": func(fields []field) string {
				var propertyOrder []string
				for _, f := range fields {
					if strings.HasSuffix(f.Type, ".TypeMeta") {
						propertyOrder = append([]string{"\"typeMeta\""}, propertyOrder...)
						continue
					}
					if f.Name != "" {
						propertyOrder = append(propertyOrder, "\""+f.Name+"\"")
					}
				}
				return strings.Join(propertyOrder, ", ")
			},
			"generateClientTags": func(tags codegenutils.Tags, rootPackage, currentPackage string) string {
				t := []string{}

				if !tags.GenerateClient {
					t = append(t, "generate=false")
				}
				if tags.NonNamespaced {
					t = append(t, "nonNamespaced=true")
				}
				if tags.NoStatus {
					t = append(t, "noStatus=true")
				}
				if tags.NoVerbs {
					t = append(t, "noVerbs=true")
				}
				if len(tags.SkipVerbs) > 0 {
					skipVerbs := []string{}
					for _, v := range tags.SkipVerbs {
						skipVerbs = append(skipVerbs, "\""+v+"\"")
					}
					t = append(t, "skipVerbs={"+strings.Join(skipVerbs, ", ")+"}")
				}

				if len(tags.Extensions) > 0 {
					extensions := []string{}
					for _, e := range tags.Extensions {
						annotationValues := []string{"verbName = \"" + e.VerbName + "\"", "verbType = \"" + e.VerbType + "\""}
						if e.SubResourcePath != "" {
							annotationValues = append(annotationValues, "subresourcePath = \""+e.SubResourcePath+"\"")
						}
						if e.InputTypeOverride != "" {
							if !strings.Contains(e.InputTypeOverride, ".") {
								annotationValues = append(annotationValues, "inputType = "+currentPackage+"."+e.InputTypeOverride+".class")
							} else {
								annotationValues = append(annotationValues, "inputType = "+javaPackage(rootPackage, e.InputTypeOverride)+".class")
							}
						}
						if e.ResultTypeOverride != "" {
							if !strings.Contains(e.ResultTypeOverride, ".") {
								annotationValues = append(annotationValues, "resultType = "+currentPackage+"."+e.ResultTypeOverride+".class")
							} else {
								annotationValues = append(annotationValues, "resultType = "+javaPackage(rootPackage, e.ResultTypeOverride)+".class")
							}
						}
						extensions = append(extensions, "@Extension("+strings.Join(annotationValues, ", ")+")")
					}

					t = append(t, "extensions = {\n    "+strings.Join(extensions, ",\n    ")+"\n  }")
				}

				s := strings.Join(t, ",\n  ")
				if s != "" {
					s = "(\n  " + s + "\n)"
				}
				return s
			},
		},
	).
	Parse(immutableTemplateText))

const styleClassName = "ImmutablesStyle"

type immutablesGenerator struct {
	config Config
}

var _ Generator = &immutablesGenerator{}

func (g *immutablesGenerator) Generate(pkgs []loader.Package) error {
	g.config.Logger.Debug("generating")

	stylesPackage := g.config.JavaRootPackage + ".kubernetes.types.api"
	pkgDir := javaPackageToDir(g.config.OutputDirectory, stylesPackage)
	if err := os.MkdirAll(pkgDir, 0755); err != nil && os.IsExist(err) {
		return errors.Wrapf(err, "failed to create directory %s", pkgDir)
	}

	stylesClass := stylesPackage + "." + styleClassName

	for _, pkg := range pkgs {
		javaPkg := javaPackage(g.config.JavaRootPackage, pkg.Path)
		pkgDir := javaPackageToDir(g.config.OutputDirectory, javaPkg)
		g.config.Logger.Debug("generating for package", "package", pkg.Path, "javaPackage", javaPkg, "dir", pkgDir)

		if err := os.MkdirAll(pkgDir, 0755); err != nil && os.IsExist(err) {
			return errors.Wrapf(err, "failed to create directory %s", pkgDir)
		}

		if err := g.writePackageJava(pkgDir, javaPkg, stylesClass, pkg.Doc); err != nil {
			return errors.Wrap(err, "failed to write package-info.java file")
		}

		for _, typ := range pkg.Types {
			if typ.Name == "Time" || typ.Name == "MicroTime" {
				continue
			}

			fp := filepath.Join(pkgDir, typ.Name+".java")

			if !g.config.Force {
				_, err := os.Stat(fp)
				if err == nil {
					return errors.Errorf("target file %s already exists", fp)
				}
				if !os.IsNotExist(err) {
					return errors.Errorf("failed to check if target file %s exists: %v", fp, err)
				}
			}

			f, err := os.OpenFile(fp, os.O_WRONLY|os.O_CREATE|os.O_TRUNC, 0644)
			if err != nil {
				return errors.Wrapf(err, "failed to open file %s to write", fp)
			}

			if err := g.write(pkg, javaPkg, typ, f); err != nil {
				return errors.Wrapf(err, "failed to write file %s", fp)
			}
		}
	}

	return nil
}

func (g *immutablesGenerator) write(pkg loader.Package, javaPkg string, typ loader.Type, f *os.File) error {
	defer func() {
		_ = f.Close()
	}()

	fields := make([]field, 0, len(typ.Fields))

	hasMetadata := false
	hasTypeMeta := false
	for _, fld := range typ.Fields {
		javaType, err := javaType(g.config.JavaRootPackage, fld.Type, fld.TypeName)
		if err != nil {
			return errors.Wrapf(err, "unhandled field type %s for field %s.%s.%s", pkg, typ.Name, fld.Type.String())
		}

		fldTypeStr := fld.Type.String()
		if fld.JSONProperty == "metadata" && fldTypeStr == "k8s.io/apimachinery/pkg/apis/meta/v1.ObjectMeta" {
			hasMetadata = true
		}
		if fld.JSONProperty == "" && fldTypeStr == "k8s.io/apimachinery/pkg/apis/meta/v1.TypeMeta" {
			hasTypeMeta = true
		}

		if fldTypeStr == "k8s.io/apimachinery/pkg/apis/meta/v1.Time" {
			javaType = "java.util.Date"
		}

		if fldTypeStr == "k8s.io/apimachinery/pkg/api/resource.Quantity" {
			javaType = "String"
		}

		fields = append(fields, field{
			javaType,
			fld.JSONProperty,
			fld.Doc,
			!fld.JSONRequired,
		})
	}

	return immutableTemplate.Execute(f, data{
		JavaPackage:   javaPkg,
		GoPackage:     typ.Package,
		ClassName:     typ.Name,
		HasMetadata:   hasMetadata,
		HasTypeMeta:   hasTypeMeta,
		Doc:           typ.Doc,
		Fields:        fields,
		LoaderPackage: pkg,
		Tags:          typ.Tags,
		RootPackage:   g.config.JavaRootPackage,
	})
}

func (g *immutablesGenerator) writePackageJava(pkgDir, javaPackage, styleClass, doc string) error {
	pkgDoc := doc
	if len(pkgDoc) > 0 {
		pkgDoc = startOfLineRegexp.ReplaceAllString(pkgDoc, "// ") + "\n"
		pkgDoc = strings.Replace(pkgDoc, "\t", "  ", -1)
		pkgDoc = trailingSpaceRegexp.ReplaceAllString(pkgDoc, "")
	}
	contents := []byte(fmt.Sprintf(`/*
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
%s@%s
package %s;
`, pkgDoc, styleClass, javaPackage))
	return ioutil.WriteFile(filepath.Join(pkgDir, "package-info.java"), contents, 0644)
}
