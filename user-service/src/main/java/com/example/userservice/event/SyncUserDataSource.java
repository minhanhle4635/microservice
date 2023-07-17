package com.example.userservice.event;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SyncUserDataSource {
    String SYNCHRONIZE_USER_DATA_OUTPUT = "synchronizeUserDataOutput";

    @Output(SyncUserDataSource.SYNCHRONIZE_USER_DATA_OUTPUT)
    MessageChannel synchronizeUserDataOutput();
}
