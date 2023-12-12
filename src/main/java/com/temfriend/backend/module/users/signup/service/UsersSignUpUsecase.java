package com.temfriend.backend.module.users.signup.service;

import com.temfriend.backend.module.users.signup.dto.request.UsersSignUpRequest;
import com.temfriend.backend.module.users.signup.dto.rseponse.UsersSignUpResponse;

public interface UsersSignUpUsecase {
    UsersSignUpResponse.Create executeSignUp(UsersSignUpRequest.Create request);
}
