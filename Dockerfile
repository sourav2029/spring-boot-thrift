FROM dockerhub.ops.inmobi.com/idp/docker-jvm-8-ubuntu-14.04:v2-20180606-23
MAINTAINER 	enterprise-solutions@inmobi.com

ENV BASE_DIRECTORY /opt/inmobi/heartbeat
ENV CONF_DIR $BASE_DIRECTORY/conf
ENV LOG_DIR $BASE_DIRECTORY/logs
ENV BIN_DIR $BASE_DIRECTORY/bin
ENV TEMPLATE_DIR $BASE_DIRECTORY/templates
ENV DATA_DIR $BASE_DIRECTORY/data
WORKDIR $BASE_DIRECTORY

RUN pip install --index-url=https://pypi.python.org/simple/ supervisor==3.3.1

COPY docker/supervisor /etc/supervisor/conf.d

# Scripts
COPY docker/bin $BIN_DIR
RUN chmod +x -R $BIN_DIR

COPY docker/templates $TEMPLATE_DIR
COPY docker/data $DATA_DIR

COPY heartbeat-db-service-impl/target/heartbeat-db-service.jar $BIN_DIR/heartbeat-db-service.jar

RUN chown -R nobody:nogroup /opt/inmobi/heartbeat
CMD ["bash", "-c", "$BIN_DIR/validate_environment_and_start.bash"]
