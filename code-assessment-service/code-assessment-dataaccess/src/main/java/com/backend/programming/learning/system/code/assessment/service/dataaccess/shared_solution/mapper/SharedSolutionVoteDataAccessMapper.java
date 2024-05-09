package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.vote.SharedSolutionVoteEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.vote.SharedSolutionVoteEntityId;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolutionVote;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.shared_solution_vote.SharedSolutionVoteId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SharedSolutionVoteDataAccessMapper {
    public SharedSolutionVoteEntity voteToEntity(SharedSolutionVote ssv) {
        return SharedSolutionVoteEntity.builder()
                .user(UserEntity.builder()
                        .id(ssv.getId().getValue().getUserId().getValue())
                        .build())
                .sharedSolution(SharedSolutionEntity.builder()
                        .id(ssv.getId().getValue().getSharedSolutionId().getValue())
                        .build())
                .voteType(ssv.getVoteType())
                .build();
    }

    public SharedSolutionVoteEntityId idToEntityId(SharedSolutionVoteId sharedSolutionVoteId) {
        return SharedSolutionVoteEntityId.builder()
                .sharedSolution(sharedSolutionVoteId.getValue().getSharedSolutionId().getValue())
                .user(sharedSolutionVoteId.getValue().getUserId().getValue())
                .build();
    }

    public SharedSolutionVote entityToVote(SharedSolutionVoteEntity sharedSolutionVoteEntity) {
        return SharedSolutionVote.builder()
                .voteType(sharedSolutionVoteEntity.getVoteType())
                .id(new SharedSolutionVoteId(
                        new UserId(sharedSolutionVoteEntity.getUser().getId()),
                        new SharedSolutionId(sharedSolutionVoteEntity.getSharedSolution().getId())
                ))
                .build();
    }

    public SharedSolutionVoteEntityId userIdAndSharedSolutionIdToEntityId(UUID sharedSolutionId, UUID voteUserId) {
        return SharedSolutionVoteEntityId.builder()
                .user(voteUserId)
                .sharedSolution(sharedSolutionId)
                .build();
    }
}
