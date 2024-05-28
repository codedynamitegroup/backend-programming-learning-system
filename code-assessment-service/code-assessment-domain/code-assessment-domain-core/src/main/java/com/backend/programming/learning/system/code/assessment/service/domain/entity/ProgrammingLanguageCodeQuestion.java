package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.programming_language_code_question.ProgrammingLanguageCodeQuestionId;
import com.backend.programming.learning.system.domain.entity.BaseEntity;

public class ProgrammingLanguageCodeQuestion extends BaseEntity<ProgrammingLanguageCodeQuestionId> {
    private Float timeLimit;
    private Float memoryLimit;
    private ProgrammingLanguage language;
    private Boolean active;
    private String headCode;
    private String bodyCode;
    private String tailCode;

    private ProgrammingLanguageCodeQuestion(Builder builder) {
        super.setId(builder.id);
        timeLimit = builder.timeLimit;
        memoryLimit = builder.memoryLimit;
        language = builder.language;
        active = builder.active;
        headCode = builder.headCode;
        bodyCode = builder.bodyCode;
        tailCode = builder.tailCode;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getHeadCode() {
        return headCode;
    }

    public String getBodyCode() {
        return bodyCode;
    }

    public String getTailCode() {
        return tailCode;
    }

    public Float getTimeLimit() {
        return timeLimit;
    }

    public Float getMemoryLimit() {
        return memoryLimit;
    }

    public ProgrammingLanguage getLanguage() {
        return language;
    }

    public Boolean getActive() {
        return active;
    }

    public static final class Builder {
        private Float timeLimit;
        private Float memoryLimit;
        private ProgrammingLanguage language;
        private Boolean active;
        private String headCode;
        private String bodyCode;
        private String tailCode;
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

        public Builder language(ProgrammingLanguage val) {
            language = val;
            return this;
        }

        public Builder active(Boolean val) {
            active = val;
            return this;
        }

        public Builder headCode(String val) {
            headCode = val;
            return this;
        }

        public Builder bodyCode(String val) {
            bodyCode = val;
            return this;
        }

        public Builder tailCode(String val) {
            tailCode = val;
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
