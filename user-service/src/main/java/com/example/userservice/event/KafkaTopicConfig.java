package com.example.userservice.event;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
    @Bean
    NewTopic newUser(){
        return new NewTopic("new-user", 2, (short) 1);
    }
}
