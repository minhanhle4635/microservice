package com.example.kafkaservice.event;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(topics = "topic-example1",
            groupId = "groupId")
    void listener(String data) {
        System.out.println("Listener received: " + data);
    }
}
