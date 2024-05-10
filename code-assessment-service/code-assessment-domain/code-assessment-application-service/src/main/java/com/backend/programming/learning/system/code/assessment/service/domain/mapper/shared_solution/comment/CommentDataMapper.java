package com.backend.programming.learning.system.code.assessment.service.domain.mapper.shared_solution.comment;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.DtoMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Comment;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CommentId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import org.springframework.stereotype.Component;

@Component
public class CommentDataMapper {
    final DtoMapper dtoMapper;

    public CommentDataMapper(DtoMapper dtoMapper) {
        this.dtoMapper = dtoMapper;
    }

    public Comment createCommentCommandToCommand(CreateCommentCommand command, User user) {
        return Comment.builder()
                .sharedSolutionId(new SharedSolutionId(command.getSharedSolutionId()))
                .user(user)
                .content(command.getContent())
                .replyId(new CommentId(command.getReplyId()))
                .build();
    }

    public CreateCommentResponse commentToCreateCommentResponse(Comment comment) {
        return CreateCommentResponse.builder()
                .comment(dtoMapper.commentToCommentDto(comment))
                .user(dtoMapper.userToUserDto(comment.getUser()))
                .build();
    }
}
