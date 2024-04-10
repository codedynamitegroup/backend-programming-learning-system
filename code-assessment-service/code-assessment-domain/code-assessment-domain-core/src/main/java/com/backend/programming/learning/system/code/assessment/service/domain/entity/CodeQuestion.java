package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;

import java.util.List;
import java.util.UUID;

public class CodeQuestion extends AggregateRoot<CodeQuestionId> {
    private final QuestionId questionId;
    private final List<TestCase> testCases;
    private final String dslTemplate;

    private List<String> failureMessages;

    private CodeQuestion(Builder builder) {
        questionId = builder.questionId;
        testCases = builder.testCases;
        dslTemplate = builder.dslTemplate;
        failureMessages = builder.failureMessages;
        super.setId(builder.id);
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

    public static final class Builder {
        private QuestionId questionId;
        private List<TestCase> testCases;
        private String dslTemplate;
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
