package com.example.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.example.kafka.topics.KafkaTopics.TOPIC_1;
import static com.example.kafka.topics.KafkaTopics.TOPIC_2;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void singlePartitionTopic(String message) {
        kafkaTemplate.send(TOPIC_1, message);
    }

    //    String topic, K key, @Nullable V data
    public void multiPartitionTopic(String key, String message) {
        kafkaTemplate.send(TOPIC_2, key, message);
    }
}
