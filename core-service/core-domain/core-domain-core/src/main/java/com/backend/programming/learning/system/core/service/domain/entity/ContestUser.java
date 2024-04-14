package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseUserId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestQuestionId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestUserId;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class ContestUser extends AggregateRoot<ContestUserId> {
    private final UserId userId;
    private final ContestId contestId;
    private Boolean isCompleted;
    private ZonedDateTime completedAt;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public void initializeContestUser() {
        setId(new ContestUserId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
        updatedAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
    }

    private ContestUser(Builder builder) {
        super.setId(builder.contestUserId);
        userId = builder.userId;
        contestId = builder.contestId;
        isCompleted = builder.isCompleted;
        completedAt = builder.completedAt;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
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

    public Boolean getCompleted() {
        return isCompleted;
    }

    public ZonedDateTime getCompletedAt() {
        return completedAt;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static final class Builder {
        private ContestUserId contestUserId;
        private UserId userId;
        private ContestId contestId;
        private Boolean isCompleted;
        private ZonedDateTime completedAt;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;

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

        public Builder isCompleted(Boolean val) {
            isCompleted = val;
            return this;
        }

        public Builder completedAt(ZonedDateTime val) {
            completedAt = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder updatedAt(ZonedDateTime val) {
            updatedAt = val;
            return this;
        }

        public ContestUser build() {
            return new ContestUser(this);
        }
    }
}
