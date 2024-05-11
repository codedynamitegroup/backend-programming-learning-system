package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.Vote;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.comment_vote.CommentVoteId;
import com.backend.programming.learning.system.domain.entity.BaseEntity;

public class CommentVote extends BaseEntity<CommentVoteId> {
    private Vote voteType;

    private CommentVote(Builder builder) {
        super.setId(builder.id);
        voteType = builder.voteType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Vote getVoteType() {
        return voteType;
    }

    public static final class Builder {
        private CommentVoteId id;
        private Vote voteType;

        private Builder() {
        }

        public Builder id(CommentVoteId val) {
            id = val;
            return this;
        }

        public Builder voteType(Vote val) {
            voteType = val;
            return this;
        }

        public CommentVote build() {
            return new CommentVote(this);
        }
    }
}
