package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.shared_solution;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.DeleteSharedSolutionCommad;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.DeleteSharedSolutionVoteCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionByCodeQuestionIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionDetailCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution.UpdateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution.comment.UpdateCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.shared_solution.comment.CommentHandler;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.SharedSolutionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
public class SharedSolutionApplicationServiceImpl implements SharedSolutionApplicationService {
    final SharedSolutionCommandHanlder sharedSolutionCommandHanlder;
    final CommentHandler commentHandler;

    public SharedSolutionApplicationServiceImpl(SharedSolutionCommandHanlder sharedSolutionCommandHanlder, CommentHandler commentHandler) {
        this.sharedSolutionCommandHanlder = sharedSolutionCommandHanlder;
        this.commentHandler = commentHandler;
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
}
