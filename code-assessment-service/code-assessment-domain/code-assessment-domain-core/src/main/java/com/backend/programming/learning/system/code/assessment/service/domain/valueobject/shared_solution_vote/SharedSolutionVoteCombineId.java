package com.backend.programming.learning.system.code.assessment.service.domain.valueobject.shared_solution_vote;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.util.Objects;

public class SharedSolutionVoteCombineId {
    final UserId userId;
    final SharedSolutionId sharedSolutionId;

    public SharedSolutionVoteCombineId(UserId userId, SharedSolutionId sharedSolutionId) {
        this.userId = userId;
        this.sharedSolutionId = sharedSolutionId;
    }

    public UserId getUserId() {
        return userId;
    }

    public SharedSolutionId getSharedSolutionId() {
        return sharedSolutionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SharedSolutionVoteCombineId that = (SharedSolutionVoteCombineId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(sharedSolutionId, that.sharedSolutionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, sharedSolutionId);
    }
}
