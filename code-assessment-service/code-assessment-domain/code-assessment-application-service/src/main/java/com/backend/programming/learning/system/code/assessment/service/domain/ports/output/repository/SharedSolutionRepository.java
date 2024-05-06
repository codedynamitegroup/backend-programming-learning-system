package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SharedSolutionRepository {
    SharedSolution save(SharedSolution sharedSolution);

    void saveTag(List<Tag> tags, UUID id);

    Optional<SharedSolution> findDetailById(SharedSolutionId sharedSolutionId);

    Optional<SharedSolution> findById(UUID id);

    Integer countVoteById(UUID sharedSolutionId);

    List<SharedSolution> findByCodeQuestionId(UUID codeQuestionId);
}
