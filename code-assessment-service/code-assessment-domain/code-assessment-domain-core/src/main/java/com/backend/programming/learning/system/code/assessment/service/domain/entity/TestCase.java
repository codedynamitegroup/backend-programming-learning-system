package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TestCaseId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;

import java.util.List;
import java.util.UUID;

public class TestCase extends AggregateRoot<TestCaseId> {
    private CodeQuestionId codeQuestionId;
    private String inputData;
    private String outputData;
    private Boolean isSample;
    private Double score;

    private TestCase(Builder builder) {
        codeQuestionId = builder.codeQuestionId;
        inputData = builder.inputData;
        outputData = builder.outputData;
        isSample = builder.isSample;
        score = builder.score;
        super.setId(builder.id);
    }

    public void initiate(){
        setId(new TestCaseId(UUID.randomUUID()));
    }
    public Double getScore() {
        return score;
    }

    public CodeQuestionId getCodeQuestionId() {
        return codeQuestionId;
    }

    public String getInputData() {
        return inputData;
    }

    public String getOutputData() {
        return outputData;
    }

    public boolean getIsSample() {
        return isSample;
    }

    void initializeTestCase(CodeQuestionId codeQuestionId, TestCaseId testCaseId) {
        this.codeQuestionId = codeQuestionId;
        super.setId(testCaseId);

    }
    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private String inputData;
        private String outputData;
        private Boolean isSample;
        private Double score;
        private TestCaseId id;
        private CodeQuestionId codeQuestionId;

        private Builder() {
        }


        public Builder inputData(String val) {
            inputData = val;
            return this;
        }


        public Builder outputData(String val) {
            outputData = val;
            return this;
        }

        public Builder isSample(Boolean val) {
            isSample = val;
            return this;
        }

        public Builder score(Double val) {
            score = val;
            return this;
        }

        public Builder isSample(boolean val) {
            isSample = val;
            return this;
        }

        public Builder id(TestCaseId val) {
            id = val;
            return this;
        }

        public TestCase build() {
            return new TestCase(this);
        }

        public Builder codeQuestionId(CodeQuestionId val) {
            codeQuestionId = val;
            return this;
        }
    }
}
