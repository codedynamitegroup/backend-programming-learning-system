package com.backend.programming.learning.system.code.assessment.service.domain.dto.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.Comment;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper {
    public CommentDto commentToCommentDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId().getValue())
                .content(comment.getContent())
                .numOfReply(null)
                .totalVote(null)
                .replyId(comment.getReplyId() != null? comment.getReplyId().getValue(): null)
                .createdAt(comment.getCreatedAt())
                .build();
    }

    public UserDto userToUserDto(User user) {
        return UserDto.builder()
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .avatarUrl(user.getAvatarUrl())
                .id(user.getId().getValue())
                .build();
    }
}
