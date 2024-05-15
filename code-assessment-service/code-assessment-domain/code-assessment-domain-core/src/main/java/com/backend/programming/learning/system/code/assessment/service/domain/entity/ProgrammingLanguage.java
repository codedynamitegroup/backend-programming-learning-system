package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;

import java.util.UUID;

public class ProgrammingLanguage extends AggregateRoot<ProgrammingLanguageId> {
    private String name;
    private Integer judge0_compilerApiId;
    private Float timeLimit;
    private Float memoryLimit;
    private String headCode;
    private String bodyCode;
    private String tailCode;
    private Boolean isActive;
    private CopyState copyState;

    private ProgrammingLanguage(Builder builder) {
        name = builder.name;
        judge0_compilerApiId = builder.judge0_compilerApiId;
        timeLimit = builder.timeLimit;
        memoryLimit = builder.memoryLimit;
        headCode = builder.headCode;
        bodyCode = builder.bodyCode;
        tailCode = builder.tailCode;
        isActive = builder.isActive;
        copyState = builder.copyState;
        super.setId(builder.id);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public CopyState getCopyState() {
        return copyState;
    }
    public Integer getJudge0_compilerApiId() {
        return judge0_compilerApiId;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void initiate() {
        super.setId(new ProgrammingLanguageId(UUID.randomUUID()));
        copyState = CopyState.CREATING;
    }

    public static final class Builder {
        private String name;
        private Integer judge0_compilerApiId;
        private Float timeLimit;
        private Float memoryLimit;
        private String headCode;
        private String bodyCode;
        private String tailCode;
        private Boolean isActive;
        private CopyState copyState;
        private ProgrammingLanguageId id;

        private Builder() {
        }

        private Builder(Builder builder) {
            name = builder.name;
            judge0_compilerApiId = builder.judge0_compilerApiId;
            timeLimit = builder.timeLimit;
            memoryLimit = builder.memoryLimit;
            headCode = builder.headCode;
            bodyCode = builder.bodyCode;
            tailCode = builder.tailCode;
            isActive = builder.isActive;
            id = builder.id;
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder judge0_compilerApiId(Integer val) {
            judge0_compilerApiId = val;
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

        public Builder copyState(CopyState val) {
            copyState = val;
            return this;
        }

        public Builder id(ProgrammingLanguageId val) {
            id = val;
            return this;
        }

        public ProgrammingLanguage build() {
            return new ProgrammingLanguage(this);
        }

    }
}
