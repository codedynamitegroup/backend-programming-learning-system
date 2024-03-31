package com.backend.programming.learning.system.domain.entity;

import com.backend.programming.learning.system.domain.valueobject.ContestId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZonedDateTime;

public class Contest extends AggregateRoot<ContestId> {
    private String name;
    private String description;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private final UserId createdBy;
    private UserId updatedBy;
    private final ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private Contest(Builder builder) {
        super.setId(builder.contestId);
        createdBy = builder.createdBy;
        createdAt = builder.createdAt;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public UserId getCreatedBy() {
        return createdBy;
    }

    public UserId getUpdatedBy() {
        return updatedBy;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static final class Builder {
        private ContestId contestId;
        private UserId createdBy;
        private ZonedDateTime createdAt;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder contestId(ContestId val) {
            contestId = val;
            return this;
        }

        public Builder createdBy(UserId val) {
            createdBy = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Contest build() {
            return new Contest(this);
        }
    }
}
