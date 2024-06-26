package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.CommentDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.vote.VoteCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.tag.AddTagsToSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.DeleteSharedSolutionCommand;
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
import jakarta.validation.Valid;
import java.util.List;

public interface SharedSolutionApplicationService {
    CreateSharedSolutionResponse createSharedSolution(@Valid CreateSharedSolutionCommand command);

    GetSharedSolutionResponseItem getDetailSharedSolution(@Valid GetSharedSolutionDetailCommand command);

    GetSharedSolutionsResponse getSharedSolutions(@Valid GetSharedSolutionByCodeQuestionIdCommand command);

    VoteSharedSolutionResponse voteSharedSolution(@Valid VoteSharedSolutionCommand command);

    VoteSharedSolutionResponse deleteVote(@Valid DeleteSharedSolutionVoteCommand command);

    void updateSharedSolution(@Valid UpdateSharedSolutionCommand command);

    void deleteSharedSolution(@Valid DeleteSharedSolutionCommand command);

    CreateCommentResponse createComment(@Valid CreateCommentCommand command);

    void updateComment(@Valid UpdateCommentCommand command);

    void deleteComment(@Valid DeleteCommentCommand command);

    GetSolutionCommentResponse getComments(@Valid GetSolutionCommentCommand command);

    List<CommentDto> getReplyComments(@Valid GetReplyCommentCommand command);

    void voteComment(@Valid VoteCommentCommand command);

    void unvoteComment(@Valid UnvoteCommentCommand command);

    void addTagToSolution(@Valid AddTagsToSharedSolutionCommand command);

    void deleteSharedSolutionTag(@Valid DeleteSharedSolutionTagCommand command);
}
