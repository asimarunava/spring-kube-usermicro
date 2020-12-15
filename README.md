# spring-kube-usermicro
#To run Locally (not inside Cluster)
java -jar -Dspring.cloud.kubernetes.config.enabled=false ./target/app.jar

# How to Run
#This is a kafka Producer posting msg to  topic name "first_topic"
# usermicro Spring Boot with Kafka
* Run This on machine not inside k8s cluster.

java -jar -Dspring.cloud.kubernetes.config.enabled=false ./target/usermicro-0.0.1-SNAPSHOT.jar
# To Run Kafka locally. Run below commands.
docker network create foo

docker run --network=foo -e ZOOKEEPER_CLIENT_PORT=2181 --name zookeeper confluent/zookeeper

docker run --network=foo -p 9092:9092 --name kafka  -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1  confluent/kafka

docker ps

# To create a Topic inside Kafka
docker exec -it kafka bash
kafka-topics --zookeeper zookeeper:2181 --list
kafka-topics --zookeeper zookeeper:2181 --create --topic first_topic --replication-factor 1 --partitions 1
kafka-topics --zookeeper zookeeper:2181 --list


To post messages to Kafka first_topic hit below url
#make a post request to below url
localhost:8080/kafka
topic=first_topic
msg=pushall


curl --request POST \
  --url http://localhost:8080/kafka \
  --form topic=first_topic \
  --form 'msg=pushall'


Cheers...
Feel free to email me in case any issue
asimarunava@googlemail.com