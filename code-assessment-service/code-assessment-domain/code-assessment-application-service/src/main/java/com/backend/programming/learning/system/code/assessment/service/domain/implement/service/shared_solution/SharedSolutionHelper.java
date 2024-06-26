package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.shared_solution;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.DeleteSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.vote.DeleteSharedSolutionVoteCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionByCodeQuestionIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionDetailCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution.UpdateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.*;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.GenericHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.ValidateHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.shared_solution.SharedSolutionDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.tag.TagDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.SharedSolutionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.shared_solution_vote.SharedSolutionVoteId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import java.util.List;

@Component
public class SharedSolutionHelper {
    final SharedSolutionRepository sharedSolutionRepository;
    final SharedSolutionDataMapper sharedSolutionDataMapper;
    final CodeAssessmentDomainService codeAssessmentDomainService;
    final TagDataMapper tagDataMapper;
    final ValidateHelper validateHelper;
    final GenericHelper genericHelper;

    public SharedSolutionHelper(SharedSolutionRepository sharedSolutionRepository, SharedSolutionDataMapper sharedSolutionDataMapper, CodeAssessmentDomainService codeAssessmentDomainService, TagDataMapper tagDataMapper, ValidateHelper validateHelper, GenericHelper genericHelper) {
        this.sharedSolutionRepository = sharedSolutionRepository;
        this.sharedSolutionDataMapper = sharedSolutionDataMapper;
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.tagDataMapper = tagDataMapper;
        this.validateHelper = validateHelper;
        this.genericHelper = genericHelper;
    }

    @Transactional
    public SharedSolution createSharedSolution(CreateSharedSolutionCommand command) {
        User user = validateHelper.validateUserByEmail(command.getEmail());
        validateHelper.validateCodeQuestion(command.getCodeQuestionId());
        List<Tag> tags = validateHelper.validateTagsById(command.getTagIds());

        SharedSolution sharedSolution = sharedSolutionDataMapper.createSharedSolutionCommandToSharedSolution(command, user);

        codeAssessmentDomainService.initiateSharedSolution(sharedSolution, tags);
        return sharedSolutionRepository.save(sharedSolution);
//        sharedSolutionRepository.saveTag(sharedSolution.getTags(), sharedSolution.getId().getValue());
    }

    @Transactional
    public SharedSolution getDetailSharedSolution(GetSharedSolutionDetailCommand command) {
        User user = validateHelper.validateUserByEmail(command.getEmail());
        SharedSolution sharedSolution = validateHelper.validateSharedSolution(command.getSharedSolutionId(), user.getId().getValue());
        if(command.isIncreaseView())
            sharedSolutionRepository.increaseViewByOne(sharedSolution.getId());
        return sharedSolution;
    }

    @Transactional
    public Page<SharedSolution> getSharedSolutionsByCodeQuestionId(GetSharedSolutionByCodeQuestionIdCommand command) {
        User user = command.getEmail() == null? null: validateHelper.validateUserByEmail(command.getEmail());

        CodeQuestion codeQuestion = command.getCodeQuestionId() != null? validateHelper.validateCodeQuestion(command.getCodeQuestionId()): null;
        
        List<TagId> tagIds = command.getFilterTagIds() == null || command.getFilterTagIds().isEmpty()?
                null:
                command.getFilterTagIds().stream().map(tagDataMapper::UUIDToTagId).toList();

        return sharedSolutionRepository.findByCodeQuestionId(
                codeQuestion != null? codeQuestion.getId(): null,
                command.getPageNum(),
                command.getPageSize(),
                command.getSortBy(),
                command.getOrderBy(),
                command.getSearch(),
                tagIds,
                user == null? null: user.getId());
    }
    //hello

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

    @Transactional
    public void updateSharedSolution(UpdateSharedSolutionCommand command) {
        User user = validateHelper.validateUserByEmail(command.getEmail());
        SharedSolution sharedSolutionRepo = validateHelper.validateSharedSolution(command.getSharedSolutionId());

        if(!user.getId().equals(sharedSolutionRepo.getUser().getId())){
            throw new CodeAssessmentDomainException("User " + user.getId().getValue() + "does not own solution " + command.getSharedSolutionId());
        }
        SharedSolution sharedSolution = sharedSolutionDataMapper.updateSharedSolutionCommandToSharedSolution(command);

        genericHelper.mapRepositoryAttributeToUpdateAttribute(sharedSolutionRepo, sharedSolution, SharedSolution.class);

        sharedSolutionRepository.save(sharedSolutionRepo);

    }

    @Transactional
    public void deleteSharedSolution(DeleteSharedSolutionCommand command) {
        User user = validateHelper.validateUserByEmail(command.getEmail());
        SharedSolution sharedSolutionRepo = validateHelper.validateSharedSolution(command.getSharedSolutionId());

        if(!user.getId().equals(sharedSolutionRepo.getUser().getId())){
            throw new CodeAssessmentDomainException("User " + user.getId().getValue() + "does not own solution " + command.getSharedSolutionId());
        }

        sharedSolutionRepository.deleteById(sharedSolutionRepo.getId());
    }
}
