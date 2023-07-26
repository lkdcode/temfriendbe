package com.temfriend.backend.modules.post.controller.dto.mapper;

import com.temfriend.backend.modules.post.controller.dto.request.PostCreateRequestDTO;
import com.temfriend.backend.modules.post.domain.Post;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
//        ,unmappedTargetPolicy = ReportingPolicy.WARN
)
public interface PostMapper {

    PostCreateRequestDTO entityToDto(Post post);

    Post dtoToEntity(PostCreateRequestDTO postCreateRequestDTO);

}
