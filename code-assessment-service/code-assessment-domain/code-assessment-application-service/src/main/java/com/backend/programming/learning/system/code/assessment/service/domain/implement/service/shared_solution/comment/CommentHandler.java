package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.shared_solution.comment;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.comment.DeleteCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.comment.GetSolutionCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.comment.GetSolutionCommentResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution.comment.UpdateCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Comment;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.shared_solution.comment.CommentDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CommentHandler {
    final CommentDataMapper commentDataMapper;
    final CommentHelper commentHelper;

    public CommentHandler(CommentDataMapper commentDataMapper, CommentHelper commentHelper) {
        this.commentDataMapper = commentDataMapper;
        this.commentHelper = commentHelper;
    }

    public CreateCommentResponse createComment(CreateCommentCommand command) {
        Comment comment = commentHelper.createComment(command);
        return commentDataMapper.commentToCreateCommentResponse(comment);
    }

    public void updateComment(UpdateCommentCommand command) {
        commentHelper.updateComment(command);
    }

    public void deleteComment(DeleteCommentCommand command) {
        commentHelper.deleteComment(command);
    }

    public GetSolutionCommentResponse getComments(GetSolutionCommentCommand command) {
        Page<Comment> comments = commentHelper.getComments(command);
        return commentDataMapper.pageableCommentToGetSolutionCommentResponse(comments);
    }
}
