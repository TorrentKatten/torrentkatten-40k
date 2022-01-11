#!/usr/bin/env bash

grpcurl -plaintext -d '{"name": "Friendly Game","attacker": {"faction": "Space Marines"},"defender": {"faction": "Chaos Space Marines"}}' localhost:9090 se.torrentkatten.fourtyk.api.FourtyKService/CreateGame