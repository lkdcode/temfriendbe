package com.temfriend.backend.module.posts.command.api;

import com.temfriend.backend.global.response.SuccessResponse;
import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.module.posts.command.dto.request.PostsRequestDTO;
import com.temfriend.backend.module.posts.command.dto.response.PostsResponseDTO;
import com.temfriend.backend.module.posts.command.service.PostsCommandUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.posts}")
public class PostsCommandApiController {
    private final PostsCommandUsecase postsCommandUsecase;

    @PostMapping
    public SuccessResponse<PostsResponseDTO.Create> create(
            @AuthenticationPrincipal CustomUsersDetail customUsersDetail
            , @RequestBody @Valid PostsRequestDTO.Create request
    ) {
        PostsResponseDTO.Create response = postsCommandUsecase.executePostsSave(request, customUsersDetail);
        return SuccessResponse.ok(response);
    }

    @PutMapping("/{id}")
    public SuccessResponse<PostsResponseDTO.Update> update(
            @AuthenticationPrincipal CustomUsersDetail customUsersDetail
            , @PathVariable(name = "id") Long id
            , @RequestBody @Valid PostsRequestDTO.Update request
    ) {
        PostsResponseDTO.Update response = postsCommandUsecase.executePostsUpdate(request, customUsersDetail, id);
        return SuccessResponse.ok(response);
    }

    @PutMapping("/{id}")
    public SuccessResponse<PostsResponseDTO.Update> update(
            @AuthenticationPrincipal CustomUsersDetail customUsersDetail
            , @PathVariable(name = "id") Long id
            , @RequestBody @Valid PostsRequestDTO.UpdateOnlyTitle request
    ) {
        PostsResponseDTO.Update response = postsCommandUsecase.executePostsUpdate(request, customUsersDetail, id);
        return SuccessResponse.ok(response);
    }

    @PutMapping("/{id}")
    public SuccessResponse<PostsResponseDTO.Update> update(
            @AuthenticationPrincipal CustomUsersDetail customUsersDetail
            , @PathVariable(name = "id") Long id
            , @RequestBody @Valid PostsRequestDTO.UpdateOnlyContent request
    ) {
        PostsResponseDTO.Update response = postsCommandUsecase.executePostsUpdate(request, customUsersDetail, id);
        return SuccessResponse.ok(response);
    }

    @DeleteMapping("/{id}")
    public SuccessResponse<?> delete(
            @AuthenticationPrincipal CustomUsersDetail customUsersDetail
            , @PathVariable(name = "id") Long id
    ) {

        return SuccessResponse.ok(null);
    }
}
