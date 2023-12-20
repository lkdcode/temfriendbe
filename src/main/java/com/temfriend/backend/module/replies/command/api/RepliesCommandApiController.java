package com.temfriend.backend.module.replies.command.api;

import com.temfriend.backend.global.common.response.SuccessResponse;
import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.module.replies.command.dto.request.RepliesRequestDTO;
import com.temfriend.backend.module.replies.command.dto.response.RepliesResponseDTO;
import com.temfriend.backend.module.replies.command.service.RepliesCommandUsecase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Tag(name = "댓글 작성, 수정, 삭제", description = "댓글 Command API")
@RestController
@RequestMapping("${api.replies}")
@RequiredArgsConstructor
public class RepliesCommandApiController {
    private final RepliesCommandUsecase repliesCommandUsecase;

    @Operation(summary = "댓글 작성(생성) API", description = "새로운 댓글을 작성(생성)합니다.", tags = "댓글 작성, 수정, 삭제", responses = {
            @ApiResponse(responseCode = "200", description = "댓글 작성에 성공했습니다.")
            , @ApiResponse(responseCode = "400", description = "요청 값의 내용이 유효하지 않습니다.")
            , @ApiResponse(responseCode = "403", description = "토큰이 없을 경우 접근이 불가합니다.")
            , @ApiResponse(responseCode = "404", description = "존재하지 않는 회원입니다.")
            , @ApiResponse(responseCode = "404", description = "존재하지 않는 게시글입니다.")
    })
    @PostMapping("/{postId}")
    public SuccessResponse<RepliesResponseDTO.Create> getCreateReplies(
            @PathVariable(name = "postId") Long postId
            , @RequestBody RepliesRequestDTO.Create request
            , @AuthenticationPrincipal CustomUsersDetail customUsersDetail
    ) {
        RepliesResponseDTO.Create response =
                repliesCommandUsecase.executeRepliesSave(postId, request, customUsersDetail);

        return SuccessResponse
                .ok(response);
    }

    @Operation(summary = "댓글 수정 API", description = "댓글을 수정합니다.", tags = "댓글 작성, 수정, 삭제", responses = {
            @ApiResponse(responseCode = "200", description = "댓글 수정에 성공했습니다.")
            , @ApiResponse(responseCode = "400", description = "요청 값의 내용이 유효하지 않습니다.")
            , @ApiResponse(responseCode = "403", description = "토큰이 없을 경우 접근이 불가합니다.")
            , @ApiResponse(responseCode = "404", description = "존재하지 않는 회원입니다.")
            , @ApiResponse(responseCode = "404", description = "존재하지 않는 게시글입니다.")
    })
    @PutMapping("/updates/{repliesId}")
    public SuccessResponse<RepliesResponseDTO.Update> getUpdateReplies(
            @PathVariable(name = "repliesId") Long repliesId
            , @RequestBody RepliesRequestDTO.Update request
            , @AuthenticationPrincipal CustomUsersDetail customUsersDetail
    ) {
        RepliesResponseDTO.Update response =
                repliesCommandUsecase.executeRepliesUpdate(repliesId, request, customUsersDetail);

        return SuccessResponse
                .ok(response);
    }

    @Operation(summary = "댓글 삭제 API", description = "댓글을 삭제합니다.", tags = "댓글 작성, 수정, 삭제", responses = {
            @ApiResponse(responseCode = "200", description = "댓글 삭제에 성공했습니다.")
            , @ApiResponse(responseCode = "400", description = "요청 값의 내용이 유효하지 않습니다.")
            , @ApiResponse(responseCode = "403", description = "토큰이 없을 경우 접근이 불가합니다.")
            , @ApiResponse(responseCode = "404", description = "존재하지 않는 회원입니다.")
            , @ApiResponse(responseCode = "404", description = "존재하지 않는 게시글입니다.")
    })
    @DeleteMapping("/{repliesId}")
    public SuccessResponse<RepliesResponseDTO.Delete> getDeleteReplies(
            @PathVariable(name = "repliesId") Long repliesId
            , @AuthenticationPrincipal CustomUsersDetail customUsersDetail
    ) {
        RepliesResponseDTO.Delete response =
                repliesCommandUsecase.executeRepliesDelete(repliesId, customUsersDetail);

        return SuccessResponse
                .ok(response);
    }
}