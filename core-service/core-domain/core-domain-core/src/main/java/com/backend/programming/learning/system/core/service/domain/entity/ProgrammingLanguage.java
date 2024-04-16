package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;

public class ProgrammingLanguage extends AggregateRoot<ProgrammingLanguageId> {
    private String name;
    private Integer compilerApiId;
    private Float timeLimit;
    private Float memoryLimit;

    private ProgrammingLanguage(Builder builder) {
        super.setId(builder.programmingLanguageId);
        name = builder.name;
        compilerApiId = builder.compilerApiId;
        timeLimit = builder.timeLimit;
        memoryLimit = builder.memoryLimit;
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

    public static final class Builder {
        private ProgrammingLanguageId programmingLanguageId;
        private String name;
        private Integer compilerApiId;
        private Float timeLimit;
        private Float memoryLimit;

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

        public ProgrammingLanguage build() {
            return new ProgrammingLanguage(this);
        }
    }
}
