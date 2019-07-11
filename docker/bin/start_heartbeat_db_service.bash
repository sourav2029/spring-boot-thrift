#!/bin/bash

# it duplicates, or copies, stderr onto stdout
2>&1

JAVA_EXEC=/usr/bin/java
echo 'Starting Heartbeat job'

SPRING_CONF=${CONF_DIR}/application.properties
JAVA_OPTS="-Dspring.config.location=${SPRING_CONF}"

echo $JAVA_OPTS
exec $JAVA_EXEC $JAVA_OPTS -jar ${BASE_DIRECTORY}/bin/heartbeat-db-service.jar
