package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamSubmissionId;
import com.backend.programming.learning.system.course.service.domain.valueobject.Status;
import com.backend.programming.learning.system.course.service.domain.valueobject.Type;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class ExamSubmission extends AggregateRoot<ExamSubmissionId> {
    private Exam exam;
    private User user;
    private Integer submitCount;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private ZonedDateTime submitTime;
    private Type type;
    private Status status;
    private Float score;

    private ExamSubmission(Builder builder) {
        super.setId(builder.examSubmissionId);
        exam = builder.exam;
        user = builder.user;
        submitCount = builder.submissionCount;
        startTime = builder.startTime;
        submitTime = builder.submitTime;
        type = builder.type;
        endTime = builder.endTime;
        status = builder.status;
        score = builder.score;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Exam getExam() {
        return exam;
    }

    public User getUser() {
        return user;
    }

    public Integer getSubmissionCount() {
        return submitCount;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public ZonedDateTime getSubmitTime() {
        return submitTime;
    }

    public Type getType() {
        return type;
    }

    public Status status() {
        return status;
    }

    public void initializeExamSubmission() {
        setId(new ExamSubmissionId(UUID.randomUUID()));
        status = Status.SUBMITTED;
    }

    public void initializeStartExamSubmission() {
        setId(new ExamSubmissionId(UUID.randomUUID()));
        status = Status.NOT_SUBMITTED;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Float getScore() {
        return score;
    }

    public static final class Builder {
        private ExamSubmissionId examSubmissionId;
        private Exam exam;
        private User user;
        private Integer submissionCount;
        private ZonedDateTime startTime;
        private ZonedDateTime endTime;
        private ZonedDateTime submitTime;
        private Type type;
        private Status status;
        private Float score;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(ExamSubmissionId val) {
            examSubmissionId = val;
            return this;
        }

        public Builder exam(Exam val) {
            exam = val;
            return this;
        }

        public Builder endTime(ZonedDateTime val) {
            endTime = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder submissionCount(Integer val) {
            submissionCount = val;
            return this;
        }

        public Builder startTime(ZonedDateTime val) {
            startTime = val;
            return this;
        }

        public Builder submitTime(ZonedDateTime val) {
            submitTime = val;
            return this;
        }

        public Builder type(Type val) {
            type = val;
            return this;
        }

        public Builder status(Status val) {
            status = val;
            return this;
        }

        public Builder score(Float val) {
            score = val;
            return this;
        }

        public ExamSubmission build() {
            return new ExamSubmission(this);
        }
    }
}
