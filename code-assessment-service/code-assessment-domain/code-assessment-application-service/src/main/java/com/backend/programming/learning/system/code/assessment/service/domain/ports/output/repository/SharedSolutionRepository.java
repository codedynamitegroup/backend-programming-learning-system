package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolutionVote;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.shared_solution_vote.SharedSolutionVoteId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SharedSolutionRepository {
    SharedSolution save(SharedSolution sharedSolution);

    void saveTag(List<Tag> tags, UUID id);

    Optional<SharedSolution> findById(UUID sharedSolutionId, UUID voteUserId);

    Optional<SharedSolution> findById(UUID sharedSolutionId);

    Integer countVoteById(UUID sharedSolutionId);

    List<SharedSolution> findByCodeQuestionId(UUID codeQuestionId);

    void increaseViewByOne(SharedSolutionId id);

    void voteSharedSolution(SharedSolutionVote ssv);

    void deleteSharedSolutionVoteById(SharedSolutionVoteId sharedSolutionVoteId);

    Optional<SharedSolutionVote> findSharedSolutionVoteById(SharedSolutionVoteId id);
}
