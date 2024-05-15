package com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.entity.CommentEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.entity.vote.CommentVoteEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.entity.vote.CommentVoteEntityId;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CommentVote;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CommentId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.comment_vote.CommentVoteId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
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

    public CommentVoteEntity commentVoteToEntity(CommentVote commentVote) {
        return CommentVoteEntity.builder()
                .voteType(commentVote.getVoteType())
                .user(UserEntity.builder().id(commentVote.getId().getValue().getUserId().getValue()).build())
                .comment(CommentEntity.builder().id(commentVote.getId().getValue().getCommentId().getValue()).build())
                .build();
    }

    public CommentVoteEntityId idToEntityId(CommentVoteId commentVoteId) {
        return CommentVoteEntityId.builder()
                .user(commentVoteId.getValue().getUserId().getValue())
                .comment(commentVoteId.getValue().getCommentId().getValue())
                .build();
    }

    public CommentVote entityToCommentVote(CommentVoteEntity commentVoteEntity) {
        return CommentVote.builder()
                .voteType(commentVoteEntity.getVoteType())
                .id(new CommentVoteId(new UserId(commentVoteEntity.getUser().getId()), new CommentId(commentVoteEntity.getComment().getId())))
                .build();
    }
}
