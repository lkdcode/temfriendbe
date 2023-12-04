package com.temfriend.backend.module.users.signup.mapper;

import com.temfriend.backend.module.users.domain.Users;
import com.temfriend.backend.module.users.signup.dto.request.UsersSignUpRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsersSignUpMapper {
    UsersSignUpMapper INSTANCE = Mappers.getMapper(UsersSignUpMapper.class);

    @Mapping(target = "password", source = "password")
    Users SignUpDTOToUsers(UsersSignUpRequest.Create request, String password);
}
