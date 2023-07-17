package com.example.userservice.event;

import com.example.userservice.controller.dto.message.SyncUserMessage;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(SyncUserDataSource.class)
public class UserDataEventProducer {
    private SyncUserDataSource syncUserDataSource;

    public UserDataEventProducer(SyncUserDataSource syncUserDataSource) {
        this.syncUserDataSource = syncUserDataSource;
    }

    public void send(SyncUserMessage message) {
        syncUserDataSource.synchronizeUserDataOutput().send(MessageBuilder.withPayload(message)
                .build());
    }
}
