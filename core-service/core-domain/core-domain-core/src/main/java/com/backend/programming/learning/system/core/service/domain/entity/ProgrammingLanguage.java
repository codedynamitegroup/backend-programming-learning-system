package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;

public class ProgrammingLanguage extends AggregateRoot<ProgrammingLanguageId> {
    private String name;
    private Integer compilerApiId;
    private Float timeLimit;
    private Float memoryLimit;
    private String headCode;
    private String bodyCode;
    private String tailCode;
    private Boolean isActive;

    private ProgrammingLanguage(Builder builder) {
        super.setId(builder.programmingLanguageId);
        name = builder.name;
        compilerApiId = builder.compilerApiId;
        timeLimit = builder.timeLimit;
        memoryLimit = builder.memoryLimit;
        headCode = builder.headCode;
        bodyCode = builder.bodyCode;
        tailCode = builder.tailCode;
        isActive = builder.isActive;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public Integer getCompilerApiId() {
        return compilerApiId;
    }

    public Float getTimeLimit() {
        return timeLimit;
    }

    public Float getMemoryLimit() {
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

    public Boolean getActive() {
        return isActive;
    }


    public static final class Builder {
        private ProgrammingLanguageId programmingLanguageId;
        private String name;
        private Integer compilerApiId;
        private Float timeLimit;
        private Float memoryLimit;
        private String headCode;
        private String bodyCode;
        private String tailCode;
        private Boolean isActive;

        private Builder() {
        }

        public Builder id(ProgrammingLanguageId val) {
            programmingLanguageId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder compilerApiId(Integer val) {
            compilerApiId = val;
            return this;
        }

        public Builder timeLimit(Float val) {
            timeLimit = val;
            return this;
        }

        public Builder memoryLimit(Float val) {
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

        public Builder isActive(Boolean val) {
            isActive = val;
            return this;
        }

        public ProgrammingLanguage build() {
            return new ProgrammingLanguage(this);
        }
    }
}
