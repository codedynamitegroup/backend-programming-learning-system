package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class CodeQuestion extends AggregateRoot<CodeQuestionId> {
    private final QuestionId questionId;
    private String name;
    private UserId userId;
    private final String dslTemplate;
    private String problemStatement;
    private String inputFormat;
    private String outputFormat;
    private String constraints;
    private CopyState copyState;
    private Float maxGrade;
    private Boolean isPublic;
    private QuestionDifficulty difficulty;
    private ZonedDateTime createdAt;
    private Boolean solved;
    private List<String> failureMessages;
    private List<ProgrammingLanguage> programmingLanguages;
    private ProgrammingLanguageId sourceCodeLanguageId;
    private String sourceCode;
    private List<TestCase> tcs;



    public static final String FAILURE_MESSAGE_DELIMITER = ",";

    public static Builder builder() {
        return new Builder();
    }

    public void initializeCodeQuestion(){
        setId(new CodeQuestionId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of(DomainConstants.UTC));
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

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public List<TestCase> getTcs() {
        return tcs;
    }

    public QuestionDifficulty getDifficulty() {
        return difficulty;
    }

    public Boolean getSolved() {
        return solved;
    }

    public String getProblemStatement() {
        return problemStatement;
    }

    public List<ProgrammingLanguage> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public ProgrammingLanguageId getSourceCodeLanguageId() {
        return sourceCodeLanguageId;
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

    public Boolean getIsPublic() {
        return isPublic;
    }

    public UserId getUserId() {
        return userId;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }

    public Float getMaxGrade() {
        return maxGrade;
    }

    private CodeQuestion(Builder builder) {
        super.setId(builder.id);
        questionId = builder.questionId;
        name = builder.name;
        userId = builder.userId;
        dslTemplate = builder.dslTemplate;
        problemStatement = builder.problemStatement;
        inputFormat = builder.inputFormat;
        outputFormat = builder.outputFormat;
        constraints = builder.constraints;
        setCopyState(builder.copyState);
        maxGrade = builder.maxGrade;
        isPublic = builder.isPublic;
        difficulty = builder.difficulty;
        createdAt = builder.createdAt;
        solved = builder.solved;
        failureMessages = builder.failureMessages;
    }

    public void getDetail(List<TestCase> sampleTestCase, CodeSubmission codeSubmission, List<ProgrammingLanguage> languages) {
        tcs = sampleTestCase == null || sampleTestCase.isEmpty()? null: sampleTestCase;
        sourceCode = codeSubmission != null? codeSubmission.getSourceCode(): null;
        sourceCodeLanguageId = codeSubmission != null? codeSubmission.getLanguageId() : null;
        this.programmingLanguages = languages;
    }

    public enum Fields { name, difficulty, createdAt}

    public static final class Builder {
        private QuestionId questionId;
        private String name;
        private UserId userId;
        private String dslTemplate;
        private String problemStatement;
        private String inputFormat;
        private String outputFormat;
        private String constraints;
        private CopyState copyState;
        private Float maxGrade;
        private Boolean isPublic;
        private QuestionDifficulty difficulty;
        private ZonedDateTime createdAt;
        private Boolean solved;
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

        public Builder userId(UserId val) {
            userId = val;
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

        public Builder isPublic(Boolean val) {
            isPublic = val;
            return this;
        }

        public Builder difficulty(QuestionDifficulty val) {
            difficulty = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder solved(Boolean val) {
            solved = val;
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
