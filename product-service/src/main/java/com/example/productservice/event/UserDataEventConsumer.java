//package com.example.productservice.event;
//
//import com.example.productservice.controller.dto.message.SyncUserMessage;
//import com.example.productservice.event.sink.SyncUserDataSink;
//import com.example.productservice.repository.UserRepository;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@EnableBinding(SyncUserDataSink.class)
//public class UserDataEventConsumer {
//    private final UserRepository userRepository;
//
//    private final SyncUserDataSink syncUserDataSink;
//
//    public UserDataEventConsumer(UserRepository userRepository, SyncUserDataSink syncUserDataSink) {
//        this.userRepository = userRepository;
//        this.syncUserDataSink = syncUserDataSink;
//    }
//
//    @StreamListener(SyncUserDataSink.SYNCHRONIZE_USER_DATA_INPUT)
//    public void receiveMessage(SyncUserMessage message) {
//        syncUserDataSink.synchronizeUserDataInput().subscribe(m -> {
//            //save user
//        });
//    }
//}
