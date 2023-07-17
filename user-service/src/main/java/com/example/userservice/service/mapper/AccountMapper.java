package com.example.userservice.service.mapper;

import com.example.userservice.controller.dto.response.UserDTO;
import com.example.userservice.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "id", source = "u.id")
    UserDTO mapToDTO(Account u);
}
