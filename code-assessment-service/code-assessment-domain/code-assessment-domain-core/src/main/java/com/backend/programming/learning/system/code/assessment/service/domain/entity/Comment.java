package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CommentId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZonedDateTime;

public class Comment extends BaseEntity<CommentId> {
    private final SharedSolutionId sharedSolutionId;
    private String content;
    private ZonedDateTime updatedAt;
    private final ZonedDateTime createdAt;
    private UserId updatedBy;
    private final UserId createdBy;

    private Comment(Builder builder) {
        sharedSolutionId = builder.sharedSolutionId;
        content = builder.content;
        updatedAt = builder.updatedAt;
        createdAt = builder.createdAt;
        updatedBy = builder.updatedBy;
        createdBy = builder.createdBy;
        super.setId(builder.id);
    }

    public static Builder builder() {
        return new Builder();
    }

    public SharedSolutionId getSharedSolutionId() {
        return sharedSolutionId;
    }

    public String getContent() {
        return content;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }


    public UserId getUpdatedBy() {
        return updatedBy;
    }

    public UserId getCreatedBy() {
        return createdBy;
    }

    public static final class Builder {
        private SharedSolutionId sharedSolutionId;
        private String content;
        private ZonedDateTime updatedAt;
        private ZonedDateTime createdAt;
        private UserId updatedBy;
        private UserId createdBy;
        private CommentId id;

        private Builder() {
        }

        public Builder sharedSolutionId(SharedSolutionId val) {
            sharedSolutionId = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder updatedAt(ZonedDateTime val) {
            updatedAt = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder updatedBy(UserId val) {
            updatedBy = val;
            return this;
        }

        public Builder createdBy(UserId val) {
            createdBy = val;
            return this;
        }

        public Builder id(CommentId val) {
            id = val;
            return this;
        }

        public Comment build() {
            return new Comment(this);
        }
    }
}
