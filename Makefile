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
CURDIR := $(shell pwd)
OLDGOPATH := $(shell go env GOPATH)
GOPATH := $(CURDIR)/_gopath
ORG := github.com/fabric8io
REPOPATH ?= $(ORG)/kubernetes-model
PACKAGES ?= $(shell go list ./... | grep -v /vendor/)
GO_FILES := $(shell find ! -path "*/_gopath/*" ! -path "*/vendor/*" -name *.go)
GENERATOR ?= sundrio

.PHONY: build
build: clean test generate
	./mvnw install

.PHONY: generate
generate: schema

.PHONY: schema
schema: .tmp/generate
	.tmp/generate -f -g $(GENERATOR)

.tmp/generate: gopath
	cd $(GOPATH)/src/$(REPOPATH) && CGO_ENABLED=0 go build -o $(CURDIR)/.tmp/generate -ldflags="-s -w -extldflags '-static'" ./cmd/generate

.PHONY: test
test: .test

.test: gopath $(GO_FILES)
	cd $(GOPATH)/src/$(REPOPATH) && go test -race -v $(PACKAGES)
	touch $@

.PHONY: gopath
gopath: .gopath

.gopath: .vendor $(GO_FILES)
	rm -rf $(GOPATH)
	mkdir -p $(GOPATH)/src/$(ORG)
	rsync -a --exclude=.git --exclude=_gopath --exclude=vendor $(shell pwd) $(GOPATH)/src/$(ORG)
	rsync -a $(shell pwd)/vendor/github.com/openshift/origin/vendor/{k8s.io,golang.org,gopkg.in,google.golang.org} $(GOPATH)/src
	rsync -a $(shell pwd)/vendor/github.com/openshift/origin/vendor/github.com/* $(GOPATH)/src/github.com
	rsync -a $(shell pwd)/vendor/github.com/openshift/origin/vendor/k8s.io/kubernetes/staging/src/k8s.io/* $(GOPATH)/src/k8s.io
	rsync -a $(shell pwd)/vendor/github.com/* $(GOPATH)/src/github.com
	rsync -a $(shell pwd)/vendor/golang.org/* $(GOPATH)/src/golang.org
	rm -rf $(GOPATH)/src/github.com/openshift/origin/vendor
	touch $@

.PHONY: clean
clean:
	rm -rf .tmp kubernetes-model/src/main/java/io/fabric8/{kubernetes/types/{api/v1,apis},openshift/types/apis}
	./mvnw clean

.PHONY: vendor
vendor: .vendor

.vendor: glide.yaml
	GOPATH=$(OLDGOPATH) glide update --no-recursive
	touch $@
