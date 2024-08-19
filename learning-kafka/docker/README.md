To run the example
---

Run from root of the `docker/kafka-cluster` folder

``` bash
# JVM based Apache Kafka Docker Image
$ IMAGE=apache/kafka:latest docker compose -f docker-compose.yml up

# GraalVM based Native Apache Kafka Docker Image
$ IMAGE=apache/kafka-native:latest docker compose -f docker-compose.yml up
```
   
To access using client script:
``` bash
# Run from root of the repo
$ bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:29092
```