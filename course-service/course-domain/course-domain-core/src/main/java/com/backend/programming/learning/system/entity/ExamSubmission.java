package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.valueobject.ExamId;
import com.backend.programming.learning.system.valueobject.ExamSubmissionId;

public class ExamSubmission extends AggregateRoot<ExamSubmissionId> {

    private ExamId examId;
    private UserId userId;
    private Integer type;
    private Integer pass_status;

    private ExamSubmission(Builder builder) {
        super.setId(builder.examSubmissionId);
        examId = builder.examId;
        userId = builder.userId;
        type = builder.type;
        pass_status = builder.pass_status;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ExamId getExamId() {
        return examId;
    }

    public UserId getUserId() {
        return userId;
    }

    public Integer getType() {
        return type;
    }

    public Integer getPass_status() {
        return pass_status;
    }

    public static final class Builder {
        private ExamSubmissionId examSubmissionId;
        private ExamId examId;
        private UserId userId;
        private Integer type;
        private Integer pass_status;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder examSubmissionId(ExamSubmissionId val) {
            examSubmissionId = val;
            return this;
        }

        public Builder examId(ExamId val) {
            examId = val;
            return this;
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }

        public Builder type(Integer val) {
            type = val;
            return this;
        }

        public Builder pass_status(Integer val) {
            pass_status = val;
            return this;
        }

        public ExamSubmission build() {
            return new ExamSubmission(this);
        }
    }
}
