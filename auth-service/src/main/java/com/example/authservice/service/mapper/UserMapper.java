package com.example.authservice.service.mapper;

import com.example.authservice.controller.dto.response.UserDTO;
import com.example.authservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", source = "u.id")
    UserDTO mapToDTO(User u);
}
