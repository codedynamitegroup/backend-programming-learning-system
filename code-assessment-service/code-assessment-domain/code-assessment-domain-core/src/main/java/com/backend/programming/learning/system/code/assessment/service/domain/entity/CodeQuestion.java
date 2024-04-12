package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TestCaseId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;

import java.util.List;
import java.util.UUID;

public class CodeQuestion extends AggregateRoot<CodeQuestionId> {
    private final QuestionId questionId;
    private final List<TestCase> testCases;
    private final String dslTemplate;
    private final String problemStatement;
    private final String inputFormat;
    private final String outputFormat;
    private final Boolean isDeleted;
    private List<String> failureMessages;

    public void initializeCodeQuestion(){
        setId(new CodeQuestionId(UUID.randomUUID()));
        intializeTestCases();
    }
    public void validateCodeQuestion(){
        validateInitialCodeQuestion();
        //code later
    }

    private void validateInitialCodeQuestion() {
    }

    private void intializeTestCases() {
        long tcId = 1;
        if(testCases != null)
            for(TestCase testCase: testCases){
                testCase.initializeTestCase(super.getId(), new TestCaseId(tcId++));
            }
    }

    public String getProblemStatement() {
        return problemStatement;
    }

    public String getInputFormat() {
        return inputFormat;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public QuestionId getQuestionId() {
        return questionId;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public String getDslTemplate() {
        return dslTemplate;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }
    private CodeQuestion(Builder builder) {
        questionId = builder.questionId;
        testCases = builder.testCases;
        dslTemplate = builder.dslTemplate;
        problemStatement = builder.problemStatement;
        inputFormat = builder.inputFormat;
        outputFormat = builder.outputFormat;
        isDeleted = builder.isDeleted;
        failureMessages = builder.failureMessages;
        super.setId(builder.id);
    }

    public static final class Builder {
        private QuestionId questionId;
        private List<TestCase> testCases;
        private String dslTemplate;
        private String problemStatement;
        private String inputFormat;
        private String outputFormat;
        private Boolean isDeleted;
        private List<String> failureMessages;
        private CodeQuestionId id;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder questionId(QuestionId val) {
            questionId = val;
            return this;
        }

        public Builder testCases(List<TestCase> val) {
            testCases = val;
            return this;
        }

        public Builder dslTemplate(String val) {
            dslTemplate = val;
            return this;
        }

        public Builder problemStatement(String val) {
            problemStatement = val;
            return this;
        }

        public Builder inputFormat(String val) {
            inputFormat = val;
            return this;
        }

        public Builder outputFormat(String val) {
            outputFormat = val;
            return this;
        }

        public Builder isDeleted(Boolean val) {
            isDeleted = val;
            return this;
        }

        public Builder failureMessages(List<String> val) {
            failureMessages = val;
            return this;
        }

        public Builder codeQuestionId(CodeQuestionId val) {
            id = val;
            return this;
        }

        public CodeQuestion build() {
            return new CodeQuestion(this);
        }
    }
}
