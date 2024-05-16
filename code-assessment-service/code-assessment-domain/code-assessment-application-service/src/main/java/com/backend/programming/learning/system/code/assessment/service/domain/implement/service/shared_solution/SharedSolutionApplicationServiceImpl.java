package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.shared_solution;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.CommentDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.vote.VoteCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.tag.AddTagsToSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.DeleteSharedSolutionCommad;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.tag.DeleteSharedSolutionTagCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.vote.DeleteSharedSolutionVoteCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.comment.DeleteCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.comment.vote.UnvoteCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionByCodeQuestionIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionDetailCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.comment.GetReplyCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.comment.GetSolutionCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.comment.GetSolutionCommentResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution.UpdateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution.comment.UpdateCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.shared_solution.comment.CommentHandler;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.shared_solution.tag.SharedSolutionTagHandler;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.SharedSolutionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Slf4j
public class SharedSolutionApplicationServiceImpl implements SharedSolutionApplicationService {
    final SharedSolutionCommandHanlder sharedSolutionCommandHanlder;
    final CommentHandler commentHandler;
    final SharedSolutionTagHandler sharedSolutionTagHandler;

    public SharedSolutionApplicationServiceImpl(SharedSolutionCommandHanlder sharedSolutionCommandHanlder, CommentHandler commentHandler, SharedSolutionTagHandler sharedSolutionTagHandler) {
        this.sharedSolutionCommandHanlder = sharedSolutionCommandHanlder;
        this.commentHandler = commentHandler;
        this.sharedSolutionTagHandler = sharedSolutionTagHandler;
    }

    @Override
    public CreateSharedSolutionResponse createSharedSolution(CreateSharedSolutionCommand command) {

        return sharedSolutionCommandHanlder.createSharedSolution(command);
    }

    @Override
    public GetSharedSolutionResponseItem getDetailSharedSolution(GetSharedSolutionDetailCommand command) {

        return sharedSolutionCommandHanlder.getDetailSharedSolution(command);
    }

    @Override
    public GetSharedSolutionsResponse getSharedSolutions(GetSharedSolutionByCodeQuestionIdCommand command) {
        return sharedSolutionCommandHanlder.getSharedSolutions(command);
    }

    @Override
    public VoteSharedSolutionResponse voteSharedSolution(VoteSharedSolutionCommand command) {
        return sharedSolutionCommandHanlder.voteSharedSolution(command);
    }

    @Override
    public VoteSharedSolutionResponse deleteVote(DeleteSharedSolutionVoteCommand command) {
        return sharedSolutionCommandHanlder.deleteVote(command);
    }

    @Override
    public void updateSharedSolution(UpdateSharedSolutionCommand command) {
        sharedSolutionCommandHanlder.updateSharedSolution(command);
    }

    @Override
    public void deleteSharedSolution(DeleteSharedSolutionCommad command) {
        sharedSolutionCommandHanlder.deleteSharedSolution(command);
    }

    @Override
    public CreateCommentResponse createComment(CreateCommentCommand command) {
        return commentHandler.createComment(command);
    }

    @Override
    public void updateComment(UpdateCommentCommand command) {
        commentHandler.updateComment(command);
    }

    @Override
    public void deleteComment(DeleteCommentCommand command) {
        commentHandler.deleteComment(command);
    }

    @Override
    public GetSolutionCommentResponse getComments(GetSolutionCommentCommand command) {
        return commentHandler.getComments(command);
    }

    @Override
    public List<CommentDto> getReplyComments(GetReplyCommentCommand command) {
        return commentHandler.getReplyComments(command);
    }

    @Override
    public void voteComment(VoteCommentCommand command) {
        commentHandler.voteComment(command);
    }

    @Override
    public void unvoteComment(UnvoteCommentCommand command) {
        commentHandler.unvoteComment(command);
    }

    @Override
    public void addTagToSolution(AddTagsToSharedSolutionCommand command) {
        sharedSolutionTagHandler.addTagToSolution(command);
    }

    @Override
    public void deleteSharedSolutionTag(DeleteSharedSolutionTagCommand command) {
        sharedSolutionTagHandler.deleteSharedSolutionTag(command);
    }
}
