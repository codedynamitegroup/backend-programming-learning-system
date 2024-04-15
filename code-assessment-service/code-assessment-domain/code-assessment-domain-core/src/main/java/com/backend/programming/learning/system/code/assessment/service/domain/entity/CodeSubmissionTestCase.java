package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CodeSubmissionTestCaseId;
import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.TestCasePassStatus;

public class CodeSubmissionTestCase extends BaseEntity<CodeSubmissionTestCaseId> {
    private final TestCase testCase;
    private final CodeSubmission codeSubmission;
    private final String actualOutput;
    private final TestCasePassStatus testCasePassStatus;

    private CodeSubmissionTestCase(Builder builder) {
        testCase = builder.testCase;
        codeSubmission = builder.codeSubmission;
        actualOutput = builder.actualOutput;
        testCasePassStatus = builder.testCasePassStatus;
        super.setId(builder.id);
    }


    public TestCase getTestCase() {
        return testCase;
    }

    public CodeSubmission getCodeSubmission() {
        return codeSubmission;
    }

    public String getActualOutput() {
        return actualOutput;
    }

    public TestCasePassStatus getIsPass() {
        return testCasePassStatus;
    }
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private TestCase testCase;
        private CodeSubmission codeSubmission;
        private String actualOutput;
        private TestCasePassStatus testCasePassStatus;
        private CodeSubmissionTestCaseId id;

        private Builder() {
        }

        public Builder testCase(TestCase val) {
            testCase = val;
            return this;
        }

        public Builder codeSubmission(CodeSubmission val) {
            codeSubmission = val;
            return this;
        }

        public Builder actualOutput(String val) {
            actualOutput = val;
            return this;
        }

        public Builder testCasePassStatus(TestCasePassStatus val) {
            testCasePassStatus = val;
            return this;
        }

        public Builder id(CodeSubmissionTestCaseId val) {
            id = val;
            return this;
        }

        public CodeSubmissionTestCase build() {
            return new CodeSubmissionTestCase(this);
        }
    }
}
