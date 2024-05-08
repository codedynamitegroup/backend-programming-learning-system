package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.Vote;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.shared_solution_vote.SharedSolutionVoteId;
import com.backend.programming.learning.system.domain.entity.BaseEntity;

public class SharedSolutionVote extends BaseEntity<SharedSolutionVoteId> {
    Vote voteType;

    public Vote getVoteType() {
        return voteType;
    }

    private SharedSolutionVote(Builder builder) {
        super.setId(builder.id);
        voteType = builder.voteType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private SharedSolutionVoteId id;
        private Vote voteType;

        private Builder() {
        }

        public Builder id(SharedSolutionVoteId val) {
            id = val;
            return this;
        }

        public Builder voteType(Vote val) {
            voteType = val;
            return this;
        }

        public SharedSolutionVote build() {
            return new SharedSolutionVote(this);
        }
    }
}
