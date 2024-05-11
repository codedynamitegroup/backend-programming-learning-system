package com.backend.programming.learning.system.code.assessment.service.domain.mapper.shared_solution.comment;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.DtoMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.vote.VoteCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.comment.vote.UnvoteCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.comment.GetSolutionCommentResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution.comment.UpdateCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Comment;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CommentVote;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CommentId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.comment_vote.CommentVoteId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
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
                .build();
    }

    public Comment updateCommentCommandToComment(UpdateCommentCommand command) {
        return Comment.builder()
                .content(command.getContent())
                .build();
    }

    public GetSolutionCommentResponse pageableCommentToGetSolutionCommentResponse(Page<Comment> comments) {
        return GetSolutionCommentResponse.builder()
                .currentPage(comments.getNumber())
                .totalItems(comments.getTotalElements())
                .totalPages(comments.getTotalPages())
                .sharedSolution(comments.stream().map(dtoMapper::commentToCommentDto).toList())
                .build();
    }

    public CommentVote voteCommentCommandToCommentVote(VoteCommentCommand command) {
        return CommentVote.builder()
                .voteType(command.getVoteType())
                .id(new CommentVoteId(new UserId(command.getUserId()), new CommentId(command.getCommentId())))
                .build();
    }

    public CommentVoteId unvoteCommentCommandToCommentVoteId(UnvoteCommentCommand command) {
        return new CommentVoteId(new UserId(command.getUserId()), new CommentId(command.getCommentId()));
    }
}
