package com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.entity.vote.CommentVoteEntityId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CommentVoteDataAccessMapper {

    public CommentVoteEntityId commentIdAndUserIdToEntityId(UUID commentId, UUID userId) {
        return CommentVoteEntityId.builder()
                .comment(commentId)
                .user(userId)
                .build();
    }
}
