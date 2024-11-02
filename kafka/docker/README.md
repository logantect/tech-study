To run the example
---

Run from root of the `docker/kafka-cluster` folder

``` bash
# JVM based Apache Kafka Docker Image
$ IMAGE=apache/kafka:latest docker compose -f docker-compose.yml up

# GraalVM based Native Apache Kafka Docker Image
$ IMAGE=apache/kafka-native:latest docker compose -f docker-compose.yml up
```

Create a topic
``` bash
$ bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:29092
```

Write some events into the topic
``` bash
$ bin/kafka-topics.sh --describe --topic quickstart-events --bootstrap-server localhost:29092
```

Read the events
``` bash
$ bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:29092
```