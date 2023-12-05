package com.temfriend.backend.module.posts.command.mapper.request;

import com.temfriend.backend.module.posts.command.dto.request.PostsCommandRequestDTO;
import com.temfriend.backend.module.posts.domain.Posts;
import com.temfriend.backend.module.users.domain.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostsRequestMapper {
    PostsRequestMapper INSTANCE = Mappers.getMapper(PostsRequestMapper.class);

    Posts createDTOToPosts(PostsCommandRequestDTO.Create request, Users users);

}
