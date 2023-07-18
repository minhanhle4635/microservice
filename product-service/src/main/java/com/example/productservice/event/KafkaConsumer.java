package com.example.productservice.event;

import com.example.productservice.controller.dto.message.SyncUserMessage;
import com.example.productservice.entity.User;
import com.example.productservice.repository.UserRepository;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class KafkaConsumer {
    private final UserRepository userRepository;

    @KafkaListener(id = "newUserGroup", topics = "new-user")
    public void listen(SyncUserMessage message) {
        try {
            userRepository.save(new User(
                    message.getId(),
                    message.getCreatedDate(),
                    message.getUpdatedDate(),
                    message.isActive(),
                    message.getName(),
                    message.getAge(),
                    message.getPhone(),
                    message.getEmail()
            ));
        } catch (Exception e) {
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }
}
