package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.LanguageId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

public class Langauge extends AggregateRoot<LanguageId> {
    private String name;
    private Integer judge0_compilerApiId;
    private Double timeLimit;
    private Double memoryLimit;
    private String headCode;
    private String bodyCode;
    private String tailCode;
    private Boolean isActive;

    private Langauge(Builder builder) {
        name = builder.name;
        judge0_compilerApiId = builder.judge0_compilerApiId;
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

    public String getName() {
        return name;
    }

    public Integer getJudge0_compilerApiId() {
        return judge0_compilerApiId;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public static final class Builder {
        private String name;
        private Integer judge0_compilerApiId;
        private Double timeLimit;
        private Double memoryLimit;
        private String headCode;
        private String bodyCode;
        private String tailCode;
        private Boolean isActive;
        private LanguageId id;

        private Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder judge0_compilerApiId(Integer val) {
            judge0_compilerApiId = val;
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

        public Builder isActive(Boolean val) {
            isActive = val;
            return this;
        }

        public Builder id(LanguageId val) {
            id = val;
            return this;
        }

        public Langauge build() {
            return new Langauge(this);
        }
    }
}
