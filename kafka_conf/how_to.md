# To start docker-compose with kafka and zookeeper, go to terminal and run

```sh
$ docker compose up
$ docker compose up -d     #as a daemon
```

# To publish a message (through rest controller)
```sh
$ curl -X POST -F 'message=test' -F 'topic=D' http://localhost:8080/kafka/publish
```	