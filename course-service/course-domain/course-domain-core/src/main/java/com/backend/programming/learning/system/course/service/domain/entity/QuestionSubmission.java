package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.course.service.domain.valueobject.QuestionSubmissionId;

import java.util.List;
import java.util.UUID;

public class QuestionSubmission extends AggregateRoot<QuestionSubmissionId> {
    private final User user;
    private final ExamSubmission examSubmission;
    private final Question question;
    private Integer passStatus;
    private Float grade;
    private String content;
    private String rightAnswer;
    private Integer numFile;
    private Boolean flag;
    private Boolean answerStatus;
    private String feedback;
    private List<QuestionSubmissionFile> questionSubmissionFiles;

    private QuestionSubmission(Builder builder) {
        super.setId(builder.id);
        user = builder.user;
        examSubmission = builder.examSubmission;
        question = builder.question;
        setPassStatus(builder.passStatus);
        setGrade(builder.grade);
        setContent(builder.content);
        setRightAnswer(builder.rightAnswer);
        setNumFile(builder.numFile);
        setFlag(builder.flag);
        setAnswerStatus(builder.answerStatus);
        setQuestionSubmissionFiles(builder.questionSubmissionFiles);
    }

    public static Builder builder() {
        return new Builder();
    }

    public void initializeQuestionSubmission() {
        setId(new QuestionSubmissionId(UUID.randomUUID()));
    }



    public void setPassStatus(Integer passStatus) {
        this.passStatus = passStatus;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public void setNumFile(Integer numFile) {
        this.numFile = numFile;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public void setAnswerStatus(Boolean answerStatus) {
        this.answerStatus = answerStatus;
    }

    public void setQuestionSubmissionFiles(List<QuestionSubmissionFile> questionSubmissionFiles) {
        this.questionSubmissionFiles = questionSubmissionFiles;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public User getUser() {
        return user;
    }

    public ExamSubmission getExamSubmission() {
        return examSubmission;
    }

    public Question getQuestion() {
        return question;
    }

    public Integer getPassStatus() {
        return passStatus;
    }

    public Float getGrade() {
        return grade;
    }

    public String getContent() {
        return content;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public Integer getNumFile() {
        return numFile;
    }

    public Boolean getFlag() {
        return flag;
    }

    public Boolean getAnswerStatus() {
        return answerStatus;
    }

    public String getFeedback() {
        return feedback;
    }

    public List<QuestionSubmissionFile> getQuestionSubmissionFiles() {
        return questionSubmissionFiles;
    }

    public static final class Builder {
        private QuestionSubmissionId id;
        private User user;
        private ExamSubmission examSubmission;
        private Question question;
        private Integer passStatus;
        private Float grade;
        private String content;
        private String rightAnswer;
        private Integer numFile;
        private Boolean flag;
        private Boolean answerStatus;
        private String feedback;
        private List<QuestionSubmissionFile> questionSubmissionFiles;

        private Builder() {
        }

        public Builder id(QuestionSubmissionId val) {
            id = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder examSubmission(ExamSubmission val) {
            examSubmission = val;
            return this;
        }

        public Builder question(Question val) {
            question = val;
            return this;
        }

        public Builder passStatus(Integer val) {
            passStatus = val;
            return this;
        }

        public Builder grade(Float val) {
            grade = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder rightAnswer(String val) {
            rightAnswer = val;
            return this;
        }

        public Builder numFile(Integer val) {
            numFile = val;
            return this;
        }

        public Builder flag(Boolean val) {
            flag = val;
            return this;
        }

        public Builder answerStatus(Boolean val) {
            answerStatus = val;
            return this;
        }

        public Builder questionSubmissionFiles(List<QuestionSubmissionFile> val) {
            questionSubmissionFiles = val;
            return this;
        }

        public Builder feedback(String val) {
            feedback = val;
            return this;
        }

        public QuestionSubmission build() {
            return new QuestionSubmission(this);
        }
    }
}
