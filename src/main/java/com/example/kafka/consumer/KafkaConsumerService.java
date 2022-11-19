package com.example.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import static com.example.kafka.topics.KafkaTopics.TOPIC_1;
import static com.example.kafka.topics.KafkaTopics.TOPIC_2;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = TOPIC_1, groupId = "group1", autoStartup = "false")
    public void consumeTopic1_1(String message) {
        System.out.println("group1: " + message);
    }

    @KafkaListener(topics = TOPIC_1, groupId = "group2")
    public void consumeTopic1_2(String message) {
        System.out.println("group2: " + message);
    }

    @KafkaListener(topics = TOPIC_1, groupId = "group3")
    public void consumeTopic1_3(String message) {
        System.out.println("group3: " + message);
    }

    @KafkaListener(topics = TOPIC_2, groupId = "group4")
    public void consume4(@Payload String message) {
        System.out.println("group4: " + message);
    }

    @KafkaListener(topics = TOPIC_2, groupId = "group5")
    public void consume5(ConsumerRecord<String, String> record) {
        System.out.println("group5: " + record);
    }
}
