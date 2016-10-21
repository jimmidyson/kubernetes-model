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
GOPATH := $(shell pwd)/_gopath
ORG := github.com/fabric8io
REPOPATH ?= $(ORG)/kubernetes-model
PACKAGES ?= $(shell go list ./... | grep -v /vendor/)

.PHONY: build
build: test generate
	mvn clean install

.PHONY: generate
generate: schema

.PHONY: schema
schema: .tmp/generate
	.tmp/generate -f

.tmp/generate: gopath $(shell find -name *.go)
	cd $(GOPATH)/src/$(REPOPATH) && CGO_ENABLED=0 go build -o .tmp/generate -ldflags="-s -w -extldflags '-static'" ./cmd/generate

.PHONY: test
test: gopath
	cd $(GOPATH)/src/$(REPOPATH) && go test -race -v $(PACKAGES)

.PHONY: gopath
gopath: $(GOPATH)/src/$(ORG)

$(GOPATH)/src/$(ORG):
	mkdir -p $(GOPATH)/src/$(ORG)
	ln -s -f $(shell pwd) $(GOPATH)/src/$(ORG)
	ln -s -f $(shell pwd)/vendor/{k8s.io,golang.org,gopkg.in,google.golang.org} $(GOPATH)/src
	ln -s -f $(shell pwd)/vendor/github.com/* $(GOPATH)/src/github.com/

.PHONY: clean
clean:
	rm -rf $(GOPATH) .tmp
	mvn clean
