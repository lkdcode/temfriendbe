package com.temfriend.backend.module.users.signup.api;

import com.temfriend.backend.global.common.response.SuccessResponse;
import com.temfriend.backend.module.users.signup.dto.request.UsersSignUpRequest;
import com.temfriend.backend.module.users.signup.dto.rseponse.UsersSignUpResponse;
import com.temfriend.backend.module.users.signup.service.UsersSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("${api.users}")
@RequiredArgsConstructor
public class UsersSignUpApiController {
    private final UsersSignUpService usersSignUpService;

    @PostMapping("/sign-up")
    public SuccessResponse<UsersSignUpResponse.Create> getSignUp(
            @RequestBody @Valid UsersSignUpRequest.Create request
    ) {
        UsersSignUpResponse.Create response = usersSignUpService.executeSignUp(request);
        return SuccessResponse
                .ok(response);
    }
}
