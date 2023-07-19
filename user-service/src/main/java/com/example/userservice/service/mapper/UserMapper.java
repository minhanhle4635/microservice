package com.example.userservice.service.mapper;

import com.example.userservice.controller.dto.response.UserResponse;
import com.example.userservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    UserResponse mapToResponse(User user);
}
