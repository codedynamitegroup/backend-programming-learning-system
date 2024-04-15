package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.LanguageId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import com.backend.programming.learning.system.domain.valueobject.SubmissionPassStatus;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.util.List;

public class CodeSubmission extends AggregateRoot<CodeSubmissionId> {
    private final CodeQuestionId codeQuestionId;
    private final UserId userId;
    private final LanguageId languageId;
    private Double grade;
    private Double runTime;
    private Double memory;
    private String sourceCode;
    private SubmissionPassStatus submissionPassStatus;
    private String aiAssessment;
    private String sonaqueAssessment;
    private List<CodeSubmissionTestCase> codeSubmissionTestCaseList;

    private CodeSubmission(Builder builder) {
        codeQuestionId = builder.codeQuestionId;
        userId = builder.userId;
        languageId = builder.languageId;
        grade = builder.grade;
        runTime = builder.runTime;
        memory = builder.memory;
        sourceCode = builder.sourceCode;
        submissionPassStatus = builder.submissionPassStatus;
        aiAssessment = builder.aiAssessment;
        sonaqueAssessment = builder.sonaqueAssessment;
        codeSubmissionTestCaseList = builder.codeSubmissionTestCaseList;
        super.setId(builder.id);
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<CodeSubmissionTestCase> getCodeSubmissionTestCaseList() {
        return codeSubmissionTestCaseList;
    }
    public CodeQuestionId getCodeQuestionId() {
        return codeQuestionId;
    }

    public UserId getUserId() {
        return userId;
    }

    public LanguageId getLanguageId() {
        return languageId;
    }

    public Double getGrade() {
        return grade;
    }

    public Double getRunTime() {
        return runTime;
    }

    public Double getMemory() {
        return memory;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public SubmissionPassStatus getSubmissionPassStatus() {
        return submissionPassStatus;
    }

    public String getAiAssessment() {
        return aiAssessment;
    }

    public String getSonaqueAssessment() {
        return sonaqueAssessment;
    }

    public static final class Builder {
        private CodeQuestionId codeQuestionId;
        private UserId userId;
        private LanguageId languageId;
        private Double grade;
        private Double runTime;
        private Double memory;
        private String sourceCode;
        private SubmissionPassStatus submissionPassStatus;
        private String aiAssessment;
        private String sonaqueAssessment;
        private List<CodeSubmissionTestCase> codeSubmissionTestCaseList;
        private CodeSubmissionId id;

        private Builder() {
        }

        public Builder codeQuestionId(CodeQuestionId val) {
            codeQuestionId = val;
            return this;
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }

        public Builder languageId(LanguageId val) {
            languageId = val;
            return this;
        }

        public Builder grade(Double val) {
            grade = val;
            return this;
        }

        public Builder runTime(Double val) {
            runTime = val;
            return this;
        }

        public Builder memory(Double val) {
            memory = val;
            return this;
        }

        public Builder sourceCode(String val) {
            sourceCode = val;
            return this;
        }

        public Builder submissionPassStatus(SubmissionPassStatus val) {
            submissionPassStatus = val;
            return this;
        }

        public Builder aiAssessment(String val) {
            aiAssessment = val;
            return this;
        }

        public Builder sonaqueAssessment(String val) {
            sonaqueAssessment = val;
            return this;
        }

        public Builder codeSubmissionTestCaseList(List<CodeSubmissionTestCase> val) {
            codeSubmissionTestCaseList = val;
            return this;
        }


        public Builder id(CodeSubmissionId val) {
            id = val;
            return this;
        }

        public CodeSubmission build() {
            return new CodeSubmission(this);
        }
    }
}
