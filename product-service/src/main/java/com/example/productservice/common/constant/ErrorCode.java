package com.example.productservice.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorCode {
    public static final int USER_NOT_FOUND = 1;

    public static final int PRODUCT_NOT_FOUND = 2;
}
