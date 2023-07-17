package com.example.productservice.event;

import com.example.productservice.controller.dto.message.SyncUserMessage;
import com.example.productservice.entity.User;
import com.example.productservice.event.sink.SyncUserDataSink;
import com.example.productservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(SyncUserDataSink.class)
@Slf4j
public class UserDataEventConsumer {
    private final UserRepository userRepository;

    private final SyncUserDataSink syncUserDataSink;

    public UserDataEventConsumer(UserRepository userRepository, SyncUserDataSink syncUserDataSink) {
        this.userRepository = userRepository;
        this.syncUserDataSink = syncUserDataSink;
    }

    @StreamListener(SyncUserDataSink.SYNCHRONIZE_USER_DATA_INPUT)
    public void receiveMessage(SyncUserMessage message) {
        try {
            log.info(String.format("User Data consumer poll record: %s", message.getId()));
            userRepository.save(
                    new User(
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
            log.error(String.format("User Data consumer poll record fail: %s", message.getId()), e);
        }
    }
}
