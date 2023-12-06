package com.temfriend.backend.module.posts.command.api;

import com.temfriend.backend.global.response.SuccessResponse;
import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.module.posts.command.dto.request.PostsCommandRequestDTO;
import com.temfriend.backend.module.posts.command.dto.response.PostsCommandResponseDTO;
import com.temfriend.backend.module.posts.command.service.PostsCommandUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.posts}")
public class PostsCommandApiController {
    private final PostsCommandUsecase postsCommandUsecase;

    @PostMapping
    public SuccessResponse<PostsCommandResponseDTO.Create> getCreate(
            @RequestBody @Valid PostsCommandRequestDTO.Create request
            , @AuthenticationPrincipal CustomUsersDetail customUsersDetail
    ) {
        PostsCommandResponseDTO.Create response = postsCommandUsecase.executePostsSave(request, customUsersDetail);
        return SuccessResponse.ok(response);
    }

    @PutMapping("/{id}")
    public SuccessResponse<PostsCommandResponseDTO.Update> getUpdate(
            @RequestBody @Valid PostsCommandRequestDTO.Update request
            , @AuthenticationPrincipal CustomUsersDetail customUsersDetail
            , @PathVariable(name = "id") @Positive Long id
    ) {
        PostsCommandResponseDTO.Update response = postsCommandUsecase.executePostsUpdate(request, customUsersDetail, id);
        return SuccessResponse.ok(response);
    }

    @DeleteMapping("/{id}")
    public SuccessResponse<PostsCommandResponseDTO.Delete> getDelete(
            @PathVariable(name = "id") @Positive Long id
            , @AuthenticationPrincipal CustomUsersDetail customUsersDetail
    ) {
        PostsCommandResponseDTO.Delete response = postsCommandUsecase.executePostsDelete(id, customUsersDetail);
        return SuccessResponse.ok(response);
    }
}
