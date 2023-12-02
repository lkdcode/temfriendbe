package com.temfriend.backend.module.users.signup.mapper;

import com.temfriend.backend.module.users.domain.Users;
import com.temfriend.backend.module.users.signup.dto.request.UsersSignUpRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsersSignUpMapper {
    UsersSignUpMapper INSTANCE = Mappers.getMapper(UsersSignUpMapper.class);

    Users SignUpDTOToUser(UsersSignUpRequest.Create request);
}
