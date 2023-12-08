package com.temfriend.backend.module.replies.command.mapper.request;

import com.temfriend.backend.module.posts.domain.Posts;
import com.temfriend.backend.module.replies.command.dto.request.RepliesRequestDTO;
import com.temfriend.backend.module.replies.domain.Replies;
import com.temfriend.backend.module.users.domain.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RepliesRequestMapper {
    RepliesRequestMapper INSTANCE = Mappers.getMapper(RepliesRequestMapper.class);

    @Mapping(target = "content", source = "request.content")
    @Mapping(target = "users", source = "users")
    @Mapping(target = "posts", source = "posts")
    Replies convertRepliesFrom(RepliesRequestDTO.Create request, Users users, Posts posts);

    @Mapping(target = "content", source = "request.content")
    @Mapping(target = "users", source = "users")
    @Mapping(target = "posts", source = "posts")
    Replies convertRepliesFrom(RepliesRequestDTO.Update request, Users users, Posts posts);
}
