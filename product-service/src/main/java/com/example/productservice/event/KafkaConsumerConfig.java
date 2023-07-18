package com.example.productservice.event;

import com.example.productservice.controller.dto.message.SyncUserMessage;
import com.example.productservice.entity.User;
import com.example.productservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.kafka.streams.kstream.KStream;

import java.util.function.Consumer;

@Configuration
public class KafkaConsumerConfig {

    private final UserRepository userRepository;

    public KafkaConsumerConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public Consumer<KStream<String, SyncUserMessage>> kafkaService(){
        return kstream -> kstream.foreach((key, message) -> userRepository.save(
                new User(
                        message.getId(),
                        message.getCreatedDate(),
                        message.getUpdatedDate(),
                        message.isActive(),
                        message.getName(),
                        message.getAge(),
                        message.getPhone(),
                        message.getEmail()
                )));
    }
}
