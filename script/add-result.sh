#!/usr/bin/env bash

grpcurl -plaintext -d '{"name": "meowlolz"}' localhost:9090 Simple/SayHello

grpcurl -plaintext -d '{"name": "meowlolz"}' localhost:9090 Simple/SayGoodbye