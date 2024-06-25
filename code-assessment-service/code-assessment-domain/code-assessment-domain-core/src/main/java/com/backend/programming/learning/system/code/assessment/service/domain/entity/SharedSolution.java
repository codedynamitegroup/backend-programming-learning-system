package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.Vote;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class SharedSolution extends AggregateRoot<SharedSolutionId> {
    private final CodeQuestionId codeQuestionId;
    private final User user;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private Vote youVote;

    private Integer totalVote;
    private Integer totalComment;

    private String content;
    private String title;
    private Integer viewNumber;

    private List<Tag> tags;


    public CodeQuestionId getCodeQuestionId() {
        return codeQuestionId;
    }

    public User getUser() {
        return user;
    }

    public Integer getTotalVote() {
        return totalVote;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public Integer getTotalComment() {
        return totalComment;
    }

    public Vote getYouVote() {
        return youVote;
    }

    public Integer getViewNumber() {
        return viewNumber;
    }

    public List<Tag> getTags() {
        return tags;
    }


    private SharedSolution(Builder builder) {
        super.setId(builder.id);
        codeQuestionId = builder.codeQuestionId;
        user = builder.user;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        youVote = builder.youVote;
        totalVote = builder.totalVote;
        totalComment = builder.totalComment;
        content = builder.content;
        title = builder.title;
        viewNumber = builder.viewNumber;
        tags = builder.tags;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void initiate(List<Tag> tags) {
        setId(new SharedSolutionId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of("UTC"));
        updatedAt = createdAt;
        viewNumber = 0;
        this.tags = tags;
    }

    public enum SortedFields {createdAt, totalVote, viewNumber, totalComment}

    public static final class Builder {
        private CodeQuestionId codeQuestionId;
        private User user;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private Vote youVote;
        private Integer totalVote;
        private Integer totalComment;
        private String content;
        private String title;
        private Integer viewNumber;
        private List<Tag> tags;
        private SharedSolutionId id;

        public Builder() {
        }

        public Builder id(SharedSolutionId val) {
            id = val;
            return this;
        }

        public Builder codeQuestionId(CodeQuestionId val) {
            codeQuestionId = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
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

        public Builder youVote(Vote val) {
            youVote = val;
            return this;
        }

        public Builder totalVote(Integer val) {
            totalVote = val;
            return this;
        }

        public Builder totalComment(Integer val) {
            totalComment = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder viewNumber(Integer val) {
            viewNumber = val;
            return this;
        }

        public Builder tags(List<Tag> val) {
            tags = val;
            return this;
        }

        public SharedSolution build() {
            return new SharedSolution(this);
        }

    }

}
