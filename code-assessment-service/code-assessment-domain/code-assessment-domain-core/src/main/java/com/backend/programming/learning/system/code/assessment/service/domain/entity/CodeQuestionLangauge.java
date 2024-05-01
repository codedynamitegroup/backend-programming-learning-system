package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CodeQuestionLangaugeId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;

public class CodeQuestionLangauge extends BaseEntity<CodeQuestionLangaugeId> {
    private final CodeQuestionId codeQuestionId;
    private final ProgrammingLanguageId programmingLanguageId;
    private Double timeLimit;
    private Double memoryLimit;
    private String headCode;
    private String bodyCode;
    private String tailCode;
    private boolean isActive;

    private CodeQuestionLangauge(Builder builder) {
        codeQuestionId = builder.codeQuestionId;
        programmingLanguageId = builder.programmingLanguageId;
        timeLimit = builder.timeLimit;
        memoryLimit = builder.memoryLimit;
        headCode = builder.headCode;
        bodyCode = builder.bodyCode;
        tailCode = builder.tailCode;
        isActive = builder.isActive;
        super.setId(builder.id);
    }

    public static Builder builder() {
        return new Builder();
    }

    public CodeQuestionId getCodeQuestionId() {
        return codeQuestionId;
    }

    public ProgrammingLanguageId getLanguageId() {
        return programmingLanguageId;
    }

    public Double getTimeLimit() {
        return timeLimit;
    }

    public Double getMemoryLimit() {
        return memoryLimit;
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

    public boolean isActive() {
        return isActive;
    }

    public static final class Builder {
        private CodeQuestionId codeQuestionId;
        private ProgrammingLanguageId programmingLanguageId;
        private Double timeLimit;
        private Double memoryLimit;
        private String headCode;
        private String bodyCode;
        private String tailCode;
        private boolean isActive;
        private CodeQuestionLangaugeId id;

        private Builder() {
        }

        public Builder codeQuestionId(CodeQuestionId val) {
            codeQuestionId = val;
            return this;
        }

        public Builder languageId(ProgrammingLanguageId val) {
            programmingLanguageId = val;
            return this;
        }

        public Builder timeLimit(Double val) {
            timeLimit = val;
            return this;
        }

        public Builder memoryLimit(Double val) {
            memoryLimit = val;
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

        public Builder isActive(boolean val) {
            isActive = val;
            return this;
        }

        public Builder id(CodeQuestionLangaugeId val) {
            id = val;
            return this;
        }

        public CodeQuestionLangauge build() {
            return new CodeQuestionLangauge(this);
        }
    }
}
