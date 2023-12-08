package com.temfriend.backend.module.replies.command.api;

import com.temfriend.backend.global.common.response.SuccessResponse;
import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.module.replies.command.dto.request.RepliesRequestDTO;
import com.temfriend.backend.module.replies.command.dto.response.RepliesResponseDTO;
import com.temfriend.backend.module.replies.command.service.RepliesCommandUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.replies}")
@RequiredArgsConstructor
public class RepliesCommandApiController {
    private final RepliesCommandUsecase repliesCommandUsecase;

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
