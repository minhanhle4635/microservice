package com.example.authservice.event.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface SyncUserDataSink {
    String SYNCHRONIZE_USER_DATA_INPUT = "synchronizeUserDataInput";

    @Input(SyncUserDataSink.SYNCHRONIZE_USER_DATA_INPUT)
    SubscribableChannel synchronizeUserDataInput();
}
