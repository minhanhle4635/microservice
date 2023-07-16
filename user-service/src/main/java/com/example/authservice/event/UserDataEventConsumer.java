package com.example.authservice.event;

import com.example.authservice.controller.dto.message.SyncUserMessage;
import com.example.authservice.event.sink.SyncUserDataSink;
import com.example.authservice.repository.UserRepository;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(SyncUserDataSink.class)
public class UserDataEventConsumer {
    private final UserRepository userRepository;

    private final SyncUserDataSink syncUserDataSink;

    public UserDataEventConsumer(UserRepository userRepository, SyncUserDataSink syncUserDataSink) {
        this.userRepository = userRepository;
        this.syncUserDataSink = syncUserDataSink;
    }

    public void receiveMessage(SyncUserMessage message){
        //save user
    }
}
