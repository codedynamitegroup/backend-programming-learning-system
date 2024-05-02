package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CodeSubmissionTestCaseId;
import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.TestCasePassStatus;

public class CodeSubmissionTestCase extends BaseEntity<CodeSubmissionTestCaseId> {
    private final TestCase testCase;
    private final CodeSubmission codeSubmission;
    private String actualOutput;
    private String compileOutput;
    private String message;
    private String stderr;
    private String statusDescription;
    private Float runTime;
    private Float memory;
    private Boolean passed;
    private String judgeToken;

    private CodeSubmissionTestCase(Builder builder) {
        testCase = builder.testCase;
        codeSubmission = builder.codeSubmission;
        actualOutput = builder.actualOutput;
        compileOutput = builder.compileOutput;
        message = builder.message;
        stderr = builder.stderr;
        statusDescription = builder.statusDescription;
        runTime = builder.runTime;
        memory = builder.memory;
        passed = builder.passed;
        setJudgeToken(builder.judgeToken);
        super.setId(builder.id);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getMessage() {
        return message;
    }

    public String getStderr() {
        return stderr;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public TestCase getTestCase() {
        return testCase;
    }

    public String getCompileOutput() {
        return compileOutput;
    }

    public CodeSubmission getCodeSubmission() {
        return codeSubmission;
    }

    public String getActualOutput() {
        return actualOutput;
    }

    public Float getRunTime() {
        return runTime;
    }

    public Float getMemory() {
        return memory;
    }

    public Boolean getPassed() {
        return passed;
    }

    public String getJudgeToken() {
        return judgeToken;
    }

    public void setJudgeToken(String judgeToken) {
        this.judgeToken = judgeToken;
    }

    public static final class Builder {
        private TestCase testCase;
        private CodeSubmission codeSubmission;
        private String actualOutput;
        private String compileOutput;
        private String message;
        private String stderr;
        private String statusDescription;
        private Float runTime;
        private Float memory;
        private Boolean passed;
        private String judgeToken;
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

        public Builder compileOutput(String val) {
            compileOutput = val;
            return this;
        }

        public Builder message(String val) {
            message = val;
            return this;
        }

        public Builder stderr(String val) {
            stderr = val;
            return this;
        }

        public Builder statusDescription(String val) {
            statusDescription = val;
            return this;
        }

        public Builder runTime(Float val) {
            runTime = val;
            return this;
        }

        public Builder memory(Float val) {
            memory = val;
            return this;
        }

        public Builder passed(Boolean val) {
            passed = val;
            return this;
        }

        public Builder judgeToken(String val) {
            judgeToken = val;
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
