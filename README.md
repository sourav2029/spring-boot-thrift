# heartbeat-db-service

mvn clean install -DskipTests
docker build -t heartbeat-db-service .
docker run -e IDP_ENVIRONMENT=non_prod  -p 9000:9000 heartbeat-db-service:latest

The service should be running on http://localhost:9000/