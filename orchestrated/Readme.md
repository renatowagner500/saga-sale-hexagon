Local Exec.

1 - Run docker compose
 sudo docker-compose up OR docker-compose start

2 - Access kafka and create the topic
#will list the available containers
 sudo docker ps
#you must put the kafka id container and exec
 sudo docker exec -it <kafka_conatiner_id> sh
#once into a kafka container enter in bin folder
cd /opt/kafka_<version>/bin
#create the topics
kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic tp-saga-sale
kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic tp-saga-inventory
kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic tp-saga-payment
kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --tp-saga-orchestrator
#list messages from the topic
kafka-topics.sh --bootstrap-server=localhost:9092 --describe --topic tp-saga-sale

3 - Configure My SQL databases
#will list the available containers
 sudo docker ps
#you must put the kafka id container and exec
 sudo docker exec -it <MySqlContainer_id> /bin/bash
#Access my SQL database #password = example
 mysql -u root -p
#commands
show databases;
create database saga_sales;
create database saga_inventory;
create database saga_payment;


4 - Start the 4 microservices
