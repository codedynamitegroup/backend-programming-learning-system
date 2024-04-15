package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TestCaseId;
import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;

import java.util.List;

public class TestCase extends BaseEntity<TestCaseId> {
    private CodeQuestionId codeQuestionId;
    private final String inputData;
    private final String outputData;
    private final boolean isSample;
    private List<CodeSubmissionTestCase> codeSubmissionTestCaseList;

    private TestCase(Builder builder) {
        inputData = builder.inputData;
        outputData = builder.outputData;
        isSample = builder.isSample;
        codeSubmissionTestCaseList = builder.codeSubmissionTestCaseList;
        super.setId(builder.id);
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
        private boolean isSample;
        private TestCaseId id;
        private List<CodeSubmissionTestCase> codeSubmissionTestCaseList;

        private Builder() {
        }


        public Builder inputData(String val) {
            inputData = val;
            return this;
        }
        public Builder codeSubmissionTestCaseList(List<CodeSubmissionTestCase> val) {
            codeSubmissionTestCaseList = val;
            return this;
        }

        public Builder outputData(String val) {
            outputData = val;
            return this;
        }

        public Builder isSample(boolean val) {
            isSample = val;
            return this;
        }

        public Builder testCaseId(TestCaseId val) {
            id = val;
            return this;
        }

        public TestCase build() {
            return new TestCase(this);
        }
    }
}
