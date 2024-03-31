package com.backend.programming.learning.system.domain.entity;

import com.backend.programming.learning.system.domain.valueobject.ContestId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.LocalDateTime;

public class Contest extends AggregateRoot<ContestId> {
    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private final UserId createdBy;
    private UserId updatedBy;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Contest(Builder builder) {
        super.setId(builder.contestId);
        name = builder.name;
        description = builder.description;
        startTime = builder.startTime;
        endTime = builder.endTime;
        createdBy = builder.createdBy;
        updatedBy = builder.updatedBy;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public UserId getCreatedBy() {
        return createdBy;
    }

    public UserId getUpdatedBy() {
        return updatedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static final class Builder {
        private ContestId contestId;
        private String name;
        private String description;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private UserId createdBy;
        private UserId updatedBy;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder contestId(ContestId val) {
            contestId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder startTime(LocalDateTime val) {
            startTime = val;
            return this;
        }

        public Builder endTime(LocalDateTime val) {
            endTime = val;
            return this;
        }

        public Builder createdBy(UserId val) {
            createdBy = val;
            return this;
        }

        public Builder updatedBy(UserId val) {
            updatedBy = val;
            return this;
        }

        public Builder createdAt(LocalDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder updatedAt(LocalDateTime val) {
            updatedAt = val;
            return this;
        }

        public Contest build() {
            return new Contest(this);
        }
    }
}
