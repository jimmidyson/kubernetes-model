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

.PHONY: build
build: kubernetes-model/src/main/resources/schema/kube-schema.json
	mvn -e clean install

kubernetes-model/src/main/resources/schema/kube-schema.json: generate
	./generate > kubernetes-model/src/main/resources/schema/kube-schema.json

.tmp/generate-schema-struct: ./tools/generate-schema-struct/*
	go build -o .tmp/generate-schema-struct ./tools/generate-schema-struct

generate: .tmp/generate-schema-struct cmd/generate/generated_schema.go $(find -name *.go)
	CGO_ENABLED=0 GO15VENDOREXPERIMENT=1 go build ./cmd/generate

cmd/generate/generated_schema.go: ./tools/generate-schema-struct/* $(shell find vendor -name *.go)
	PATH=$(shell pwd)/.tmp/:$${PATH} go generate ./cmd/generate
