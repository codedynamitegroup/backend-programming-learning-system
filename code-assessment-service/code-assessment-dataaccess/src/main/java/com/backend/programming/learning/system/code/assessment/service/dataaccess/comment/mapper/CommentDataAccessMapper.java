package com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.entity.CommentEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Comment;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CommentId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import org.springframework.stereotype.Component;

@Component
public class CommentDataAccessMapper {
    final UserDataAccessMapper userDataAccessMapper;

    public CommentDataAccessMapper(UserDataAccessMapper userDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
    }

    public Comment entityToCommentIgnoreLazy(CommentEntity commentEntity) {
        return Comment.builder()
                .id(new CommentId(commentEntity.getId()))
                .sharedSolutionId(new SharedSolutionId(commentEntity.getSharedSolution().getId()))
                .user(userDataAccessMapper.userEntityToUser(commentEntity.getUser()))
                .replyId(commentEntity.getReplyComment() !=null?
                        new CommentId(commentEntity.getReplyComment().getId()):
                        null)
                .replyLevel(commentEntity.getReplyLevel())
                .createdAt(commentEntity.getCreatedAt())
                .content(commentEntity.getContent())
                .build();
    }

    public CommentEntity commentToEntity(Comment comment) {
        return CommentEntity.builder()
                .id(comment.getId().getValue())
                .user(userDataAccessMapper.userToUserEntity(comment.getUser()))
                .sharedSolution(SharedSolutionEntity.builder().id(comment.getSharedSolutionId().getValue()).build())
                .content(comment.getContent())
                .replyLevel(comment.getReplyLevel())
                .createdAt(comment.getCreatedAt())
                .replyComment(
                        comment.getReplyId() != null?
                        CommentEntity.builder()
                        .id(comment.getId().getValue())
                        .build(): null)
                .build();
    }
}
