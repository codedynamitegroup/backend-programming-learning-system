package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolutionVote;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.shared_solution_vote.SharedSolutionVoteId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QueryOrderBy;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SharedSolutionRepository {

    //main group
    SharedSolution save(SharedSolution sharedSolution);

    Optional<SharedSolution> findById(UUID sharedSolutionId, UUID voteUserId);

    Optional<SharedSolution> findById(UUID sharedSolutionId);

    void increaseViewByOne(SharedSolutionId id);

    void deleteById(SharedSolutionId id);

    Page<SharedSolution> findByCodeQuestionId(CodeQuestionId codeQuestionId, Integer pageNo, Integer pageSize, SharedSolution.SortedFields sortBy, QueryOrderBy orderBy, List<TagId> tagIds);




    //tag group
    void saveTag(List<Tag> tags, SharedSolutionId id);



    //vote group
    void voteSharedSolution(SharedSolutionVote ssv);

    void deleteSharedSolutionVoteById(SharedSolutionVoteId sharedSolutionVoteId);

    Optional<SharedSolutionVote> findSharedSolutionVoteById(SharedSolutionVoteId id);

    void deleteTag(List<Tag> tags, SharedSolutionId id);
}
