package com.example.kafka;

import com.example.kafka.producer.KafkaProducerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(KafkaApplication.class, args);
        var producerService = context.getBean(KafkaProducerService.class);
        producerService.singlePartitionTopic("1st topic message");

        sendOutOfOrderMessages(producerService);
//        sendInOrderMessages(producerService);
    }

    private static void sendOutOfOrderMessages(KafkaProducerService producerService) {
        producerService.multiPartitionTopic("1","message1");
        producerService.multiPartitionTopic("2","message2");
        producerService.multiPartitionTopic("3","message3");
        producerService.multiPartitionTopic("3","message4");
    }

    private static void sendInOrderMessages(KafkaProducerService producerService) {
        producerService.multiPartitionTopic("1","message1");
        producerService.multiPartitionTopic("1","message2");
        producerService.multiPartitionTopic("1","message3");
        producerService.multiPartitionTopic("1","message4");
    }

}
