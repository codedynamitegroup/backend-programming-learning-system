package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CommentId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.BaseEntity;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Comment extends BaseEntity<CommentId> {
    private final SharedSolutionId sharedSolutionId;
    private final User user;
    private String content;
    private CommentId replyId;
    private Integer replyLevel;
    private ZonedDateTime createdAt;

    public SharedSolutionId getSharedSolutionId() {
        return sharedSolutionId;
    }

    public User getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public CommentId getReplyId() {
        return replyId;
    }

    public Integer getReplyLevel() {
        return replyLevel;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    private Comment(Builder builder) {
        super.setId(builder.id);
        sharedSolutionId = builder.sharedSolutionId;
        user = builder.user;
        content = builder.content;
        replyId = builder.replyId;
        replyLevel = builder.replyLevel;
        createdAt = builder.createdAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void initate(Comment replyComment) {
        super.setId(new CommentId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of(DomainConstants.UTC));
        replyLevel = replyComment == null? 0: 1;
        replyId = replyComment != null? replyComment.getId(): null;
    }


    public static final class Builder {
        private CommentId id;
        private SharedSolutionId sharedSolutionId;
        private User user;
        private String content;
        private CommentId replyId;
        private Integer replyLevel;
        private ZonedDateTime createdAt;

        private Builder() {
        }

        public Builder id(CommentId val) {
            id = val;
            return this;
        }

        public Builder sharedSolutionId(SharedSolutionId val) {
            sharedSolutionId = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder replyId(CommentId val) {
            replyId = val;
            return this;
        }

        public Builder replyLevel(Integer val) {
            replyLevel = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Comment build() {
            return new Comment(this);
        }
    }
}
