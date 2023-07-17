package com.example.userservice.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private final int errorCode;
    private final String messageKey;

    public BusinessException(int errorCode, String msg){
        super(msg);
        this.errorCode = errorCode;
        this.messageKey = msg;
    }
}
