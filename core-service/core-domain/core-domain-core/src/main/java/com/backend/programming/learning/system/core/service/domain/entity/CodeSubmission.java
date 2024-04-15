package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import com.backend.programming.learning.system.domain.valueobject.QtypeCodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

public class CodeSubmission extends AggregateRoot<CodeSubmissionId> {
    private final QtypeCodeQuestionId codeQuestionId;
    private final UserId userId;
    private Float grade;
    private Boolean pass;

    private CodeSubmission(Builder builder) {
        super.setId(builder.codeSubmissionId);
        codeQuestionId = builder.codeQuestionId;
        userId = builder.userId;
        grade = builder.grade;
        pass = builder.pass;
    }

    public static Builder builder() {
        return new Builder();
    }

    public QtypeCodeQuestionId getCodeQuestionId() {
        return codeQuestionId;
    }

    public UserId getUserId() {
        return userId;
    }

    public Float getGrade() {
        return grade;
    }

    public Boolean getPass() {
        return pass;
    }

    public static final class Builder {
        private CodeSubmissionId codeSubmissionId;
        private QtypeCodeQuestionId codeQuestionId;
        private UserId userId;
        private Float grade;
        private Boolean pass;

        private Builder() {
        }

        public Builder id(CodeSubmissionId val) {
            codeSubmissionId = val;
            return this;
        }

        public Builder codeQuestionId(QtypeCodeQuestionId val) {
            codeQuestionId = val;
            return this;
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }

        public Builder grade(Float val) {
            grade = val;
            return this;
        }

        public Builder pass(Boolean val) {
            pass = val;
            return this;
        }

        public CodeSubmission build() {
            return new CodeSubmission(this);
        }
    }
}
