#
# Copyright (C) 2011 Red Hat, Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#         http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

SHELL := /bin/bash
tag := $(shell cat .openshift-version)
GOPATH := $(shell pwd)/_gopath
ORG := github.com/fabric8io
REPOPATH ?= $(ORG)/kubernetes-model

MKGOPATH := if [ ! -e $(GOPATH)/src/$(ORG) ]; then \
	mkdir -p $(GOPATH)/src/$(ORG); \
	ln -s -f $(shell pwd) $(GOPATH)/src/$(ORG); \
	ln -s -f $(shell pwd)/vendor/{k8s.io,cloud.google.com,golang.org,google.golang.org,gopkg.in} $(GOPATH)/src/; \
	ln -s -f $(shell pwd)/vendor/github.com/* $(GOPATH)/src/github.com/; \
fi

.PHONY: build
build: kubernetes-model/target
	
kubernetes-model/target: $(shell find -name *.java) $(shell find -name pom.xml) kubernetes-model/src/main/resources/schema/kube-schema.json
	mvn clean install

kubernetes-model/src/main/resources/schema/kube-schema.json: generate
	./generate > kubernetes-model/src/main/resources/schema/kube-schema.json

.tmp/generate-schema-struct: $(shell find ./tools/generate-schema-struct/ -name *.go) $(shell find vendor -name *.go)
	$(MKGOPATH)
	go build -o .tmp/generate-schema-struct ./tools/generate-schema-struct

generate: cmd/generate/generated_schema.go $(find -name *.go)
	$(MKGOPATH)
	CGO_ENABLED=0 GO15VENDOREXPERIMENT=1 go build ./cmd/generate

cmd/generate/generated_schema.go: .tmp/generate-schema-struct $(shell find vendor -name *.go)
	$(MKGOPATH)
	PATH=$(shell pwd)/.tmp/:$${PATH} go generate ./cmd/generate

.PHONY: clean
clean:
	rm -rf $(GOPATH) .tmp
	rm -f cmd/generate/generated_schema.go
	mvn clean
