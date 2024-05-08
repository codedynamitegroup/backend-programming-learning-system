package com.backend.programming.learning.system.code.assessment.service.domain.valueobject.shared_solution_vote;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.domain.valueobject.BaseId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

public class SharedSolutionVoteId extends BaseId<SharedSolutionVoteCombineId> {
    public SharedSolutionVoteId(UserId userId, SharedSolutionId sharedSolutionId) {
        super(new SharedSolutionVoteCombineId(userId, sharedSolutionId));
    }
}
