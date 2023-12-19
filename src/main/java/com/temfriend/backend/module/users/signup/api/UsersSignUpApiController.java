package com.temfriend.backend.module.users.signup.api;

import com.temfriend.backend.global.common.response.SuccessResponse;
import com.temfriend.backend.module.users.signup.dto.request.UsersSignUpRequest;
import com.temfriend.backend.module.users.signup.dto.rseponse.UsersSignUpResponse;
import com.temfriend.backend.module.users.signup.service.UsersSignUpUsecase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "사용자 회원 가입", description = "회원 가입 API")
@RestController
@RequestMapping("${api.users}")
@RequiredArgsConstructor
public class UsersSignUpApiController {
    private final UsersSignUpUsecase usersSignUpUsecase;

    @Operation(summary = "회원 가입 API", description = "신규 회원을 등록합니다.", tags = "사용자 회원 가입", responses = {
            @ApiResponse(responseCode = "200", description = "신규 회원가입에 성공했습니다.")
            , @ApiResponse(responseCode = "400", description = "회원가입의 요청 값이 잘 못 됐습니다.")
            , @ApiResponse(responseCode = "409", description = "이메일 또는 닉네임이 중복됐습니다.")
    })
    @PostMapping("/sign-up")
    public SuccessResponse<UsersSignUpResponse.Create> getSignUp(
            @RequestBody @Valid UsersSignUpRequest.Create request
    ) {
        UsersSignUpResponse.Create response = usersSignUpUsecase.executeSignUp(request);

        return SuccessResponse
                .ok(response);
    }
}
