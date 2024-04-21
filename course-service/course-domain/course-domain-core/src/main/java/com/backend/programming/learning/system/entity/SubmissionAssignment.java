package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.valueobject.AssignmentId;
import com.backend.programming.learning.system.valueobject.SubmissionAssignmentId;

import java.time.ZonedDateTime;
import java.util.UUID;

public class SubmissionAssignment extends AggregateRoot<SubmissionAssignmentId> {

    private User user;
    private Assignment assignment;
    private Integer pass_status;
    private Float grade;
    private String content;
    private ZonedDateTime submittedAt;

    private SubmissionAssignment(Builder builder) {
        super.setId(builder.submissionAssignmentId);
        user = builder.user;
        assignment = builder.assignment;
        pass_status = builder.pass_status;
        grade = builder.grade;
        content = builder.content;
        submittedAt = builder.submittedAt;
    }

    public void setPass_status(Integer pass_status) {
        this.pass_status = pass_status;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSubmittedAt(ZonedDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public User getUser() {
        return user;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public Integer getPass_status() {
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public void initializeAssignmentSubmission() {
        setId(new SubmissionAssignmentId(UUID.randomUUID()));
    }

    public static final class Builder {
        private SubmissionAssignmentId submissionAssignmentId;
        private User user;
        private Assignment assignment;
        private Integer pass_status;
        private Float grade;
        private String content;
        private ZonedDateTime submittedAt;

        private Builder() {

        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(SubmissionAssignmentId val) {
            submissionAssignmentId = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder assignment(Assignment val) {
            assignment = val;
            return this;
        }

        public Builder pass_status(Integer val) {
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

        public SubmissionAssignment build() {
            return new SubmissionAssignment(this);
        }
    }
}
