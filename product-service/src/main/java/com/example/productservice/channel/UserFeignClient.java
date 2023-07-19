package com.example.productservice.channel;

import com.example.productservice.controller.dto.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "user-feign-client", url = "http://localhost:8080/user")
public interface UserFeignClient {
    @GetMapping("/all")
    ResponseEntity<List<UserResponse>> getAllUser();
}
