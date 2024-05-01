package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.programming_language_code_question.ProgrammingLanguageCodeQuestionId;
import com.backend.programming.learning.system.domain.entity.BaseEntity;

public class ProgrammingLanguageCodeQuestion extends BaseEntity<ProgrammingLanguageCodeQuestionId> {
    private Float timeLimit;
    private Float memoryLimit;
    private Boolean active;

    private ProgrammingLanguageCodeQuestion(Builder builder) {
        timeLimit = builder.timeLimit;
        memoryLimit = builder.memoryLimit;
        active = builder.active;
        super.setId(builder.id);
    }

    public static Builder builder() {
        return new Builder();
    }


    public Float getTimeLimit() {
        return timeLimit;
    }

    public Float getMemoryLimit() {
        return memoryLimit;
    }

    public Boolean getActive() {
        return active;
    }

    public static final class Builder {
        private Float timeLimit;
        private Float memoryLimit;
        private Boolean active;
        private ProgrammingLanguageCodeQuestionId id;

        private Builder() {
        }

        public Builder timeLimit(Float val) {
            timeLimit = val;
            return this;
        }

        public Builder memoryLimit(Float val) {
            memoryLimit = val;
            return this;
        }

        public Builder active(Boolean val) {
            active = val;
            return this;
        }

        public Builder id(ProgrammingLanguageCodeQuestionId val) {
            id = val;
            return this;
        }

        public ProgrammingLanguageCodeQuestion build() {
            return new ProgrammingLanguageCodeQuestion(this);
        }
    }
}
