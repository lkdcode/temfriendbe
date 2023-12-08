package com.temfriend.backend.module.replies.command.mapper.response;

import com.temfriend.backend.module.replies.command.dto.response.RepliesResponseDTO;
import com.temfriend.backend.module.replies.domain.Replies;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RepliesResponseMapper {
    RepliesResponseMapper INSTANCE = Mappers.getMapper(RepliesResponseMapper.class);

    RepliesResponseDTO.Create convertCreateDTOFrom(Replies replies);

    RepliesResponseDTO.Update convertUpdateDTOFrom(Replies replies);
}
