package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestQuestionId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestUserId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZonedDateTime;

public class ContestUser extends AggregateRoot<ContestUserId> {
    private final UserId userId;
    private final ContestId contestId;
    private ZonedDateTime registeredAt;
    private Boolean isCompleted;
    private ZonedDateTime completedAt;

    private ContestUser(Builder builder) {
        super.setId(builder.contestUserId);
        userId = builder.userId;
        contestId = builder.contestId;
        registeredAt = builder.registeredAt;
        isCompleted = builder.isCompleted;
        completedAt = builder.completedAt;
    }

    public static Builder builder() {
        return new Builder();
    }


    public UserId getUserId() {
        return userId;
    }

    public ContestId getContestId() {
        return contestId;
    }

    public ZonedDateTime getRegisteredAt() {
        return registeredAt;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public ZonedDateTime getCompletedAt() {
        return completedAt;
    }

    public static final class Builder {
        private ContestUserId contestUserId;
        private UserId userId;
        private ContestId contestId;
        private ZonedDateTime registeredAt;
        private Boolean isCompleted;
        private ZonedDateTime completedAt;

        private Builder() {
        }

        public Builder id(ContestUserId val) {
            contestUserId = val;
            return this;
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }

        public Builder contestId(ContestId val) {
            contestId = val;
            return this;
        }

        public Builder registeredAt(ZonedDateTime val) {
            registeredAt = val;
            return this;
        }

        public Builder isCompleted(Boolean val) {
            isCompleted = val;
            return this;
        }

        public Builder completedAt(ZonedDateTime val) {
            completedAt = val;
            return this;
        }

        public ContestUser build() {
            return new ContestUser(this);
        }
    }
}
