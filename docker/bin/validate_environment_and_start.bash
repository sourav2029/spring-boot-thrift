#!/bin/bash

set -e
2>&1

# Validate and sanitise environment variables
. ${BIN_DIR}/validate_env.bash

# Detemplatise configs
${BIN_DIR}/detemplatise.bash

# Supervisord Setup
mkdir -p ${LOG_DIR}/process

# Starting supervisord
exec /usr/local/bin/supervisord -c /etc/supervisor/supervisord.conf
