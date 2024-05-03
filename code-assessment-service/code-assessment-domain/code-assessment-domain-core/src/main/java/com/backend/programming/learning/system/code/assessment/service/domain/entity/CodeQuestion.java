package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;

import java.util.List;
import java.util.UUID;

public class CodeQuestion extends AggregateRoot<CodeQuestionId> {
    private final QuestionId questionId;
    private final String name;
    private final String dslTemplate;
    private final String problemStatement;
    private final String inputFormat;
    private final String outputFormat;
    private final String constraints;
    private CopyState copyState;
    private Float maxGrade;
    private List<String> failureMessages;
    public static final String FAILURE_MESSAGE_DELIMITER = ",";

    public static Builder builder() {
        return new Builder();
    }

    public void initializeCodeQuestion(){
        setId(new CodeQuestionId(UUID.randomUUID()));
        copyState = CopyState.CREATING;
    }
    public void validateCodeQuestion(){
        validateInitialCodeQuestion();
        //code later
    }
    public void setCopyState(CopyState state){
        copyState = state;
    }

    private void validateInitialCodeQuestion() {
    }
    public void initCancelCopy(CopyState state, List<String> failureMessages){
        this.copyState = state;
        updateFailureMessages(failureMessages);

    }
    private void updateFailureMessages(List<String> failureMessages) {
        if (this.failureMessages != null && failureMessages != null) {
            this.failureMessages.addAll(failureMessages.stream().filter(message -> !message.isEmpty()).toList());
        }
        if (this.failureMessages == null) {
            this.failureMessages = failureMessages;
        }
    }


    public String getConstraints() {
        return constraints;
    }

    public String getName() {
        return name;
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

    public CopyState getCopyState() {
        return copyState;
    }

    public QuestionId getQuestionId() {
        return questionId;
    }

    public String getDslTemplate() {
        return dslTemplate;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }

    public Float getMaxGrade() {
        return maxGrade;
    }

    private CodeQuestion(Builder builder) {
        questionId = builder.questionId;
        name = builder.name;
        dslTemplate = builder.dslTemplate;
        problemStatement = builder.problemStatement;
        inputFormat = builder.inputFormat;
        outputFormat = builder.outputFormat;
        constraints = builder.constraints;
        setCopyState(builder.copyState);
        maxGrade = builder.maxGrade;
        failureMessages = builder.failureMessages;
        super.setId(builder.id);
    }

    public static final class Builder {
        private QuestionId questionId;
        private String name;
        private String dslTemplate;
        private String problemStatement;
        private String inputFormat;
        private String outputFormat;
        private String constraints;
        private CopyState copyState;
        private Float maxGrade;
        private List<String> failureMessages;
        private CodeQuestionId id;

        private Builder() {
        }

        public Builder questionId(QuestionId val) {
            questionId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
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

        public Builder constraints(String val) {
            constraints = val;
            return this;
        }

        public Builder copyState(CopyState val) {
            copyState = val;
            return this;
        }

        public Builder maxGrade(Float val) {
            maxGrade = val;
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
