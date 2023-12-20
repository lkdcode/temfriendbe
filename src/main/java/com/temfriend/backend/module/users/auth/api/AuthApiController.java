package com.temfriend.backend.module.users.auth.api;

import com.temfriend.backend.global.common.response.SuccessResponse;
import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.module.users.auth.dto.request.AuthRequestDTO;
import com.temfriend.backend.module.users.auth.dto.response.AuthResponseDTO;
import com.temfriend.backend.module.users.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Tag(name = "사용자 로그인 및 로그 아웃", description = "로그인 & 로그아웃 API")
@RestController
@RequestMapping("${api.users}")
@RequiredArgsConstructor
public class AuthApiController {
    private final AuthService authService;

    @Operation(summary = "로그인 API", description = "이메일과 패스워드로 로그인을 합니다.", tags = "사용자 로그인 및 로그 아웃", responses = {
            @ApiResponse(responseCode = "200", description = "로그인에 성공했습니다.")
            , @ApiResponse(responseCode = "401", description = "아이디 혹은 비밀번호가 틀렸습니다.")
    })
    @PostMapping("/log-in")
    public SuccessResponse<AuthResponseDTO.LogIn> getLogIn(
            @RequestBody @Valid AuthRequestDTO.LogIn request,
            HttpServletResponse httpServletResponse
    ) {
        AuthResponseDTO.LogIn response = authService.executeLogIn(httpServletResponse, request);
        return SuccessResponse.ok(response);
    }

    @Operation(summary = "로그아웃 API", description = "발급된 토큰을 만료시킵니다.", tags = "사용자 로그인 및 로그 아웃", responses = {
            @ApiResponse(responseCode = "200", description = "발급된 토큰을 만료시켜 로그아웃에 성공했습니다.")
            , @ApiResponse(responseCode = "403", description = "토큰이 없을 경우 접근이 불가합니다.")
    })
    @PostMapping("/log-out")
    public SuccessResponse<AuthResponseDTO.LogOut> getLogOut(
            HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse
    ) {
        AuthResponseDTO.LogOut response = authService.executeLogOut(httpServletRequest, httpServletResponse);
        return SuccessResponse.ok(response);
    }
}
