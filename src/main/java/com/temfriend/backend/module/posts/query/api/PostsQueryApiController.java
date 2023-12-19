package com.temfriend.backend.module.posts.query.api;

import com.temfriend.backend.global.common.response.SuccessResponse;
import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.module.posts.query.dto.response.PostsQueryResponseDTO;
import com.temfriend.backend.module.posts.query.service.PostsQueryUsecase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Tag(name = "게시글 조회", description = "게시글 Query API")
@RestController
@RequestMapping("${api.posts}")
@RequiredArgsConstructor
public class PostsQueryApiController {
    private final PostsQueryUsecase postsQueryUsecase;

    @Operation(summary = "게시글 ID로 단일 게시글 조회 API", description = "게시글의 ID로 조회합니다.", tags = "게시글 조회", responses = {
            @ApiResponse(responseCode = "200", description = "게시글 조회에 성공했습니다.")
            , @ApiResponse(responseCode = "400", description = "요청 값이 유효하지 않습니다.")
            , @ApiResponse(responseCode = "403", description = "토큰이 없을 경우 접근이 불가합니다.")
            , @ApiResponse(responseCode = "404", description = "존재하지 않는 게시글입니다.")
    })
    @GetMapping("/{id}")
    public SuccessResponse<PostsQueryResponseDTO.Get> getFindById(
            @PathVariable(name = "id") @Positive Long id
    ) {
        PostsQueryResponseDTO.Get response = postsQueryUsecase.retrieveSinglePostsById(id);
        return SuccessResponse.ok(response);
    }

    @Operation(summary = "유저 닉네임으로 게시글 목록 조회 API", description = "유저의 닉네임으로 게시글을 조회합니다.", tags = "게시글 조회", responses = {
            @ApiResponse(responseCode = "200", description = "게시글 조회에 성공했습니다.")
            , @ApiResponse(responseCode = "400", description = "요청 값이 유효하지 않습니다.")
//            , @ApiResponse(responseCode = "403", description = "토큰이 없을 경우 접근이 불가합니다.")
            , @ApiResponse(responseCode = "404", description = "존재하지 않는 회원입니다.")
    })
    @GetMapping("/writers/{usersId}")
    public SuccessResponse<List<PostsQueryResponseDTO.Get>> getFindByUsersId(
            @PathVariable(name = "usersId") @Positive Long usersId
    ) {
        // TODO : 비회원에게도 제공될 것인지?
        // TODO : nickname 으로 조회 기능
        // TODO : 존재하지 않는 회원
        List<PostsQueryResponseDTO.Get> response = postsQueryUsecase.retrievePostsListByUsersId(usersId);
        return SuccessResponse.ok(response);
    }

    @Operation(summary = "게시글 전체 목록 조회 API", description = "페이징 처리를 해 게시글 목록을 조회합니다.", tags = "게시글 조회", responses = {
            @ApiResponse(responseCode = "200", description = "게시글 조회에 성공했습니다."),
            //            , @ApiResponse(responseCode = "403", description = "토큰이 없을 경우 접근이 불가합니다.")
    })
    @GetMapping
    public SuccessResponse<List<PostsQueryResponseDTO.Get>> getFindAll(
            @PageableDefault(size = 3, sort = "createdAt", direction = DESC) Pageable pageable
    ) {
        List<PostsQueryResponseDTO.Get> response = postsQueryUsecase.retrievePostsList(pageable);
        return SuccessResponse.ok(response);
    }
}
