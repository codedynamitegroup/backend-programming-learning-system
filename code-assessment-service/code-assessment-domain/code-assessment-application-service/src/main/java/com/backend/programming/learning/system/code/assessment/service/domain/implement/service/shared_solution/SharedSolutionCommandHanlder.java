package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.shared_solution;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.DeleteSharedSolutionCommad;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.vote.DeleteSharedSolutionVoteCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionByCodeQuestionIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionDetailCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution.UpdateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.shared_solution.SharedSolutionDataMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

@Component
public class SharedSolutionCommandHanlder {
    final SharedSolutionHelper sharedSolutionHelper;
    final SharedSolutionDataMapper sharedSolutionDataMapper;


    public SharedSolutionCommandHanlder(SharedSolutionHelper sharedSolutionHelper, SharedSolutionDataMapper sharedSolutionDataMapper) {
        this.sharedSolutionHelper = sharedSolutionHelper;
        this.sharedSolutionDataMapper = sharedSolutionDataMapper;
    }

    public CreateSharedSolutionResponse createSharedSolution(CreateSharedSolutionCommand command) {
        return sharedSolutionDataMapper.sharedSolutionToCreateSharedSolutionResponse(sharedSolutionHelper.createSharedSolution(command));
    }

    @Transactional
    public GetSharedSolutionResponseItem getDetailSharedSolution(GetSharedSolutionDetailCommand command) {
        SharedSolution sharedSolution = sharedSolutionHelper.getDetailSharedSolution(command);
        return sharedSolutionDataMapper.sharedSolutionToGetSharedSolutionResponseItem(sharedSolution);
    }

    @Transactional
    public GetSharedSolutionsResponse getSharedSolutions(GetSharedSolutionByCodeQuestionIdCommand command) {
        Page<SharedSolution> sharedSolutions
                = sharedSolutionHelper.getSharedSolutionsByCodeQuestionId(command);

        return sharedSolutionDataMapper.pageableSharedSolutionListToGetSharedSolutionsResponse(sharedSolutions);
    }



    public VoteSharedSolutionResponse voteSharedSolution(VoteSharedSolutionCommand command) {
        sharedSolutionHelper.voteSharedSolution(command);
        return VoteSharedSolutionResponse.builder().message("vote successfully").build();
    }

    public VoteSharedSolutionResponse deleteVote(DeleteSharedSolutionVoteCommand command) {
        sharedSolutionHelper.deleteSharedSolutionVote(command);
        return VoteSharedSolutionResponse.builder().message("delete vote successfully").build();

    }

    public void updateSharedSolution(UpdateSharedSolutionCommand command) {
        sharedSolutionHelper.updateSharedSolution(command);
    }

    public void deleteSharedSolution(DeleteSharedSolutionCommad command) {
        sharedSolutionHelper.deleteSharedSolution(command);
    }


}
