package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.shared_solution;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.DeleteSharedSolutionVoteCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionByCodeQuestionIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionDetailCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.shared_solution.SharedSolutionDataMapper;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class SharedSolutionCommandHanlder {
    private final SharedSolutionHelper sharedSolutionHelper;
    private final SharedSolutionDataMapper sharedSolutionDataMapper;

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
        Integer totalVote = sharedSolutionHelper.countTotalVote(command.getSharedSolutionId());
        return sharedSolutionDataMapper.sharedSolutionToGetSharedSolutionResponseItem(sharedSolution, totalVote);
    }

    @Transactional
    public List<GetSharedSolutionResponseItem> getSharedSolutions(GetSharedSolutionByCodeQuestionIdCommand command) {
        List<SharedSolution> sharedSolutions = sharedSolutionHelper.getSharedSolutionsByCodeQuestionId(command.getCodeQuestionId());
        List<GetSharedSolutionResponseItem> items =  sharedSolutions.stream().map(sharedSolutionDataMapper::sharedSolutionToGetSharedSolutionResponseItemIgnoreTitleAndContent)
                .toList();
        List<Integer> totalVotes = sharedSolutionHelper.getTotalVotes(sharedSolutions);
        for(int i = 0; i<items.size(); ++i)
            items.get(i).setTotalVote(totalVotes.get(i));
        return items;
    }

    public VoteSharedSolutionResponse voteSharedSolution(VoteSharedSolutionCommand command) {
        sharedSolutionHelper.voteSharedSolution(command);
        return VoteSharedSolutionResponse.builder().message("vote successfully").build();
    }

    public VoteSharedSolutionResponse deleteVote(DeleteSharedSolutionVoteCommand command) {
        sharedSolutionHelper.deleteSharedSolutionVote(command);
        return VoteSharedSolutionResponse.builder().message("delete vote successfully").build();

    }
}
