package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.SubmissionGradeId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

import java.time.ZonedDateTime;
import java.util.UUID;

public class SubmissionGrade extends AggregateRoot<SubmissionGradeId> {
    private SubmissionAssignment submissionAssignment;
    private float grade;
    private ZonedDateTime timeCreated;
    private ZonedDateTime timeModified;

    private SubmissionGrade(Builder builder) {
        super.setId(builder.id);
        submissionAssignment = builder.submissionAssignment;
        grade = builder.grade;
        timeCreated = builder.timeCreated;
        timeModified = builder.timeModified;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SubmissionAssignment getSubmissionAssignment() {
        return submissionAssignment;
    }

    public void setSubmissionAssignment(SubmissionAssignment submissionAssignment) {
        this.submissionAssignment = submissionAssignment;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public ZonedDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(ZonedDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public ZonedDateTime getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(ZonedDateTime timeModified) {
        this.timeModified = timeModified;
    }

    public void initializeSubmissionGrade() {
        setId(new SubmissionGradeId(UUID.randomUUID()));
    }

    public static final class Builder {
        private SubmissionGradeId id;
        private SubmissionAssignment submissionAssignment;
        private float grade;
        private ZonedDateTime timeCreated;
        private ZonedDateTime timeModified;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(SubmissionGradeId val) {
            id = val;
            return this;
        }

        public Builder submissionAssignment(SubmissionAssignment val) {
            submissionAssignment = val;
            return this;
        }

        public Builder grade(float val) {
            grade = val;
            return this;
        }

        public Builder timeCreated(ZonedDateTime val) {
            timeCreated = val;
            return this;
        }

        public Builder timeModified(ZonedDateTime val) {
            timeModified = val;
            return this;
        }

        public SubmissionGrade build() {
            return new SubmissionGrade(this);
        }
    }
}
