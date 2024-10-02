**Instructions to run application**
* docker and docker-compose must installed in the system.
* Download this repository
* Go to the downloaded repository directory inside your system
* Use the below command to start the application
  ```shell
    docker-compose up
  ```
* start spring boot application "kafka-cloud-stream-demo"
* Use below curl command to to send messages to kafka.
  ```shell
    curl -X POST http://localhost:8080/api/v1/messages/send \
    -H "Content-Type: application/json" \
    -d '"Hello, Kafka"'
  ```
