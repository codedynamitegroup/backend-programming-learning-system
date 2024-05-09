package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.shared_solution;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.DeleteSharedSolutionVoteCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionDetailCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolutionVote;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.ValidateHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.shared_solution.SharedSolutionDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.SharedSolutionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.shared_solution_vote.SharedSolutionVoteId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Component
public class SharedSolutionHelper {
    final SharedSolutionRepository sharedSolutionRepository;
    final SharedSolutionDataMapper sharedSolutionDataMapper;
    final CodeAssessmentDomainService codeAssessmentDomainService;
    final ValidateHelper validateHelper;

    public SharedSolutionHelper(SharedSolutionRepository sharedSolutionRepository, SharedSolutionDataMapper sharedSolutionDataMapper, CodeAssessmentDomainService codeAssessmentDomainService, ValidateHelper validateHelper) {
        this.sharedSolutionRepository = sharedSolutionRepository;
        this.sharedSolutionDataMapper = sharedSolutionDataMapper;
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.validateHelper = validateHelper;
    }

    @Transactional
    public SharedSolution createSharedSolution(CreateSharedSolutionCommand command) {
        SharedSolution sharedSolution = sharedSolutionDataMapper.createSharedSolutionCommandToSharedSolution(command);
        validateHelper.validateUser(command.getUserId());
        validateHelper.validateCodeQuestion(command.getCodeQuestionId());
        List<Tag> tags = validateHelper.validateTagsById(command.getTagIds());
        codeAssessmentDomainService.initiateSharedSolution(sharedSolution, tags);
        return sharedSolutionRepository.save(sharedSolution);
//        sharedSolutionRepository.saveTag(sharedSolution.getTags(), sharedSolution.getId().getValue());
    }

    @Transactional
    public SharedSolution getDetailSharedSolution(GetSharedSolutionDetailCommand command) {
        SharedSolution sharedSolution = validateHelper.validateSharedSolution(command.getSharedSolutionId(), command.getUserId());
        sharedSolutionRepository.increaseViewByOne(sharedSolution.getId());
        return sharedSolution;
    }

    @Transactional
    public Integer countTotalVote(UUID sharedSolutionId) {
        return sharedSolutionRepository.countVoteById(sharedSolutionId);
    }

    @Transactional
    public List<SharedSolution> getSharedSolutionsByCodeQuestionId(UUID codeQuestionId) {
        validateHelper.validateCodeQuestion(codeQuestionId);
        return sharedSolutionRepository.findByCodeQuestionId(codeQuestionId);
    }

    @Transactional
    public List<Integer> getTotalVotes(List<SharedSolution> sharedSolutions) {
        return sharedSolutions.stream().map(item->countTotalVote(item.getId().getValue())).toList();
    }

    @Transactional
    public void voteSharedSolution(VoteSharedSolutionCommand command) {
        validateHelper.validateUser(command.getUserId());
        validateHelper.validateSharedSolution(command.getSharedSolutionId());
        SharedSolutionVote ssv = sharedSolutionDataMapper.voteSharedSolutionCommandToSharedSolutionVote(command);
        sharedSolutionRepository.voteSharedSolution(ssv);
    }

    @Transactional
    public void deleteSharedSolutionVote(DeleteSharedSolutionVoteCommand command) {

        validateHelper.validateUser(command.getUserId());
        validateHelper.validateSharedSolution(command.getSharedSolutionId());

        SharedSolutionVoteId id = new SharedSolutionVoteId(
                new UserId(command.getUserId()),
                new SharedSolutionId(command.getSharedSolutionId()));
        validateHelper.validateSharedSolutionVote(id);

        sharedSolutionRepository
                .deleteSharedSolutionVoteById(id);

    }
}
