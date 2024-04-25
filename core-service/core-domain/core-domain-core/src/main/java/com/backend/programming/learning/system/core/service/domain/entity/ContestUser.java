package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseUserId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestQuestionId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestUserId;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class ContestUser extends BaseEntity<ContestUserId> {
    private final User user;
    private final Contest contest;
    private Boolean isCompleted;
    private ZonedDateTime completedAt;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public void initializeContestUser() {
        setId(new ContestUserId(UUID.randomUUID()));
        setCreatedAt(ZonedDateTime.now());
        setUpdatedAt(ZonedDateTime.now());
    }

    private ContestUser(Builder builder) {
        super.setId(builder.contestUserId);
        user = builder.user;
        contest = builder.contest;
        isCompleted = builder.isCompleted;
        setCompletedAt(builder.completedAt);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
    }

    public static Builder builder() {
        return new Builder();
    }


    public User getUser() {
        return user;
    }

    public Contest getContest() {
        return contest;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public ZonedDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(ZonedDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static final class Builder {
        private ContestUserId contestUserId;
        private User user;
        private Contest contest;
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

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder contest(Contest val) {
            contest = val;
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
