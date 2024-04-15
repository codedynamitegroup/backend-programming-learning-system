package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.valueobject.AssignmentId;
import com.backend.programming.learning.system.valueobject.AssignmentSubmissionId;

import java.time.ZonedDateTime;

public class AssignmentSubmission extends AggregateRoot<AssignmentSubmissionId> {

    private UserId userId;
    private AssignmentId assignmentId;
    private Boolean pass_status;
    private Float grade;
    private String content;
    private ZonedDateTime submittedAt;

    private AssignmentSubmission(Builder builder) {
        super.setId(builder.assignmentSubmissionId);
        userId = builder.userId;
        assignmentId = builder.assignmentId;
        pass_status = builder.pass_status;
        grade = builder.grade;
        content = builder.content;
        submittedAt = builder.submittedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public UserId getUserId() {
        return userId;
    }

    public AssignmentId getAssignmentId() {
        return assignmentId;
    }

    public Boolean getPass_status() {
        return pass_status;
    }

    public Float getGrade() {
        return grade;
    }

    public String getContent() {
        return content;
    }

    public ZonedDateTime getSubmittedAt() {
        return submittedAt;
    }

    public static final class Builder {
        private AssignmentSubmissionId assignmentSubmissionId;
        private UserId userId;
        private AssignmentId assignmentId;
        private Boolean pass_status;
        private Float grade;
        private String content;
        private ZonedDateTime submittedAt;

        private Builder() {

        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder assignmentSubmission(AssignmentSubmissionId val) {
            assignmentSubmissionId = val;
            return this;
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }

        public Builder assignmentId(AssignmentId val) {
            assignmentId = val;
            return this;
        }

        public Builder pass_status(Boolean val) {
            pass_status = val;
            return this;
        }

        public Builder grade(Float val) {
            grade = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder submittedAt(ZonedDateTime val) {
            submittedAt = val;
            return this;
        }

        public AssignmentSubmission build() {
            return new AssignmentSubmission(this);
        }
    }
}
