package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.course.service.domain.valueobject.SubmissionAssignmentId;

import java.time.ZonedDateTime;
import java.util.UUID;

public class SubmissionAssignment extends AggregateRoot<SubmissionAssignmentId> {

    private User user;
    private Assignment assignment;
    private Boolean isGraded;
    private Float grade;
    private String content;

    private String feedback;

    private ZonedDateTime submittedAt;
    private ZonedDateTime timemodified;

    private SubmissionAssignment(Builder builder) {
        super.setId(builder.submissionAssignmentId);
        user = builder.user;
        assignment = builder.assignment;
        isGraded = builder.isGraded;
        feedback = builder.feedback;
        timemodified = builder.timemodified;
        grade = builder.grade;
        content = builder.content;
        submittedAt = builder.submittedAt;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Boolean getGraded() {
        return isGraded;
    }

    public void setGraded(Boolean graded) {
        isGraded = graded;
    }

    public ZonedDateTime getTimemodified() {
        return timemodified;
    }

    public void setTimemodified(ZonedDateTime timemodified) {
        this.timemodified = timemodified;
    }

    public void setIsGraded(Boolean graded) {
        isGraded = graded;
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

    public Boolean getGradedStatus() {
        return isGraded;
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
        private Boolean isGraded;
        private Float grade;
        private String content;
        private String feedback;
        private ZonedDateTime submittedAt;
        private ZonedDateTime timemodified;

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

        public Builder isGraded(Boolean val) {
            isGraded = val;
            return this;
        }

        public Builder grade(Float val) {
            grade = val;
            return this;
        }

        public Builder timemodified(ZonedDateTime val) {
            timemodified = val;
            return this;
        }


        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder feedback(String val) {
            feedback = val;
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
