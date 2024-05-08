package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.DeleteSharedSolutionVoteCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionByCodeQuestionIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionDetailCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionResponseItem;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution.UpdateSharedSolutionCommand;
import jakarta.validation.Valid;
import java.util.List;

public interface SharedSolutionApplicationService {
    CreateSharedSolutionResponse createSharedSolution(@Valid CreateSharedSolutionCommand command);

    GetSharedSolutionResponseItem getDetailSharedSolution(@Valid GetSharedSolutionDetailCommand command);

    List<GetSharedSolutionResponseItem> getSharedSolutions(@Valid GetSharedSolutionByCodeQuestionIdCommand command);

    VoteSharedSolutionResponse voteSharedSolution(@Valid VoteSharedSolutionCommand command);

    VoteSharedSolutionResponse deleteVote(@Valid DeleteSharedSolutionVoteCommand command);

    void updateSharedSolution(@Valid UpdateSharedSolutionCommand command);
}
