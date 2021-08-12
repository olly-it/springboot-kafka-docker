# springboot-kafka-docker
Spring Boot app with Apache Kafka in Docker container

Based on:  
https://habr.com/en/post/529222/  
https://www.confluent.io/blog/apache-kafka-spring-boot-application/

Project content:  
1. kafka+zookeeper docker-compose to run kafka and zookeeper in docker
1. simple spring boot web application that interract with kafka topics

# ABCD topic test:
1. KafkaController receive a request /kafka/abcd and send a message in topic "A"
1. AConsumer consumes the message in topic "A" and publish on topic "B"
1. BConsumer consumes the message in topic "B" and publish on topic "C"
1. CConsumer consumes the message in topic "C" and publish on topic "D"
1. DConsumer consumes the message in topic "D" and write how long it took

To test it:

```sh
$ curl -X POST -F 'message=test' http://localhost:8080/kafka/abcd
```
