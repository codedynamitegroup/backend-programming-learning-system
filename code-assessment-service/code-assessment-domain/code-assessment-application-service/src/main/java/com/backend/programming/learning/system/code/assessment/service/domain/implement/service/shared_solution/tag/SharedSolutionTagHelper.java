package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.shared_solution.tag;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.tag.AddTagsToSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.tag.DeleteSharedSolutionTagCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.ValidateHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.SharedSolutionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
public class SharedSolutionTagHelper {
    final ValidateHelper validateHelper;
    final SharedSolutionRepository sharedSolutionRepository;

    public SharedSolutionTagHelper(ValidateHelper validateHelper, SharedSolutionRepository sharedSolutionRepository) {
        this.validateHelper = validateHelper;
        this.sharedSolutionRepository = sharedSolutionRepository;
    }

    @Transactional
    public void addTagToSolution(AddTagsToSharedSolutionCommand command) {
        if(command.getTagIds().isEmpty())
            return;

        User user = validateHelper.validateUserByEmail(command.getEmail());
        SharedSolution sharedSolution = validateHelper.validateSharedSolution(command.getSharedSolutionId());

        if(!user.getId().equals(sharedSolution.getUser().getId())){
            throw new CodeAssessmentDomainException("User " + user.getId().getValue() + "does not own solution " + command.getSharedSolutionId());
        }

        List<Tag> tags = validateHelper.validateTagsById(command.getTagIds());

        sharedSolutionRepository.saveTag(tags, sharedSolution.getId());

    }

    @Transactional
    public void deleteSharedSolutionTag(DeleteSharedSolutionTagCommand command) {
        if(command.getTagIds().isEmpty())
            return;

        User user = validateHelper.validateUserByEmail(command.getEmail());
        SharedSolution sharedSolution = validateHelper.validateSharedSolution(command.getSharedSolutionId());

        if(!user.getId().equals(sharedSolution.getUser().getId())){
            throw new CodeAssessmentDomainException("User " + user.getId().getValue() + "does not own solution " + command.getSharedSolutionId());
        }

        List<Tag> tags = validateHelper.validateTagsById(command.getTagIds());
        sharedSolutionRepository.deleteTag(tags, sharedSolution.getId());

    }
}
