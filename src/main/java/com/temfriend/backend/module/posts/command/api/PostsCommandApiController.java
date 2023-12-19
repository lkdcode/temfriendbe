package com.temfriend.backend.module.posts.command.api;

import com.temfriend.backend.global.common.response.SuccessResponse;
import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.module.posts.command.dto.request.PostsCommandRequestDTO;
import com.temfriend.backend.module.posts.command.dto.response.PostsCommandResponseDTO;
import com.temfriend.backend.module.posts.command.service.PostsCommandUsecase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Tag(name = "게시글 작성, 수정, 삭제", description = "게시글 Command API")
@RequiredArgsConstructor
@RestController
@RequestMapping("${api.posts}")
public class PostsCommandApiController {
    private final PostsCommandUsecase postsCommandUsecase;

    @Operation(summary = "게시글 작성(생성) API", description = "새로운 게시글을 작성(생성)합니다.", tags = "게시글 작성, 수정, 삭제", responses = {
            @ApiResponse(responseCode = "200", description = "게시글 작성에 성공했습니다.")
            , @ApiResponse(responseCode = "400", description = "요청 값의 제목 혹은 내용이 유효하지 않습니다.")
            , @ApiResponse(responseCode = "403", description = "토큰이 없을 경우 접근이 불가합니다.")
            , @ApiResponse(responseCode = "404", description = "존재하지 않는 회원입니다.")
    })
    @PostMapping
    public SuccessResponse<PostsCommandResponseDTO.Create> getCreate(
            @RequestBody @Valid PostsCommandRequestDTO.Create request
            , @AuthenticationPrincipal CustomUsersDetail customUsersDetail
    ) {
        PostsCommandResponseDTO.Create response = postsCommandUsecase.executePostsSave(request, customUsersDetail);
        return SuccessResponse.ok(response);
    }

    @Operation(summary = "게시글 수정 API", description = "기존 게시글을 수정합니다.", tags = "게시글 작성, 수정, 삭제", responses = {
            @ApiResponse(responseCode = "200", description = "게시글 수정에 성공했습니다.")
            , @ApiResponse(responseCode = "400", description = "요청 값의 제목 혹은 내용이 유효하지 않습니다.")
            , @ApiResponse(responseCode = "403", description = "토큰이 없을 경우 접근이 불가합니다.")
            , @ApiResponse(responseCode = "404", description = "존재하지 않는 회원입니다.")
    })
    @PutMapping("/{id}")
    public SuccessResponse<PostsCommandResponseDTO.Update> getUpdate(
            @RequestBody @Valid PostsCommandRequestDTO.Update request
            , @AuthenticationPrincipal CustomUsersDetail customUsersDetail
            , @PathVariable(name = "id") @Positive Long id
    ) {
        PostsCommandResponseDTO.Update response = postsCommandUsecase.executePostsUpdate(request, customUsersDetail, id);
        return SuccessResponse.ok(response);
    }

    @Operation(summary = "게시글 삭제 API", description = "기존 게시글을 삭제합니다.", tags = "게시글 작성, 수정, 삭제", responses = {
            @ApiResponse(responseCode = "200", description = "게시글 삭제에 성공했습니다.")
            , @ApiResponse(responseCode = "400", description = "요청 값의 제목 혹은 내용이 유효하지 않습니다.")
            , @ApiResponse(responseCode = "403", description = "토큰이 없을 경우 접근이 불가합니다.")
            , @ApiResponse(responseCode = "404", description = "존재하지 않는 회원입니다.")
    })
    @DeleteMapping("/{id}")
    public SuccessResponse<PostsCommandResponseDTO.Delete> getDelete(
            @PathVariable(name = "id") @Positive Long id
            , @AuthenticationPrincipal CustomUsersDetail customUsersDetail
    ) {
        PostsCommandResponseDTO.Delete response = postsCommandUsecase.executePostsDelete(id, customUsersDetail);
        return SuccessResponse.ok(response);
    }
}
