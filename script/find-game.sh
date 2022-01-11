#!/usr/bin/env bash

grpcurl -plaintext -d '{"uuid": "99c3b7a9-dcc1-4f3e-84f1-7d6590c5af42"}' localhost:9090 se.torrentkatten.fourtyk.api.FourtyKService/FindGame