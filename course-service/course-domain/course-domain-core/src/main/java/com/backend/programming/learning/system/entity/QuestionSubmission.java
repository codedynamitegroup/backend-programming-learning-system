package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.valueobject.ExamSubmissionId;
import com.backend.programming.learning.system.valueobject.QuestionId;
import com.backend.programming.learning.system.valueobject.QuestionSubmissionId;

public class QuestionSubmission extends AggregateRoot<QuestionSubmissionId> {
    private UserId userId;
    private ExamSubmissionId examSubmissionId;
    private QuestionId questionId;

    private Integer pass_status;
    private Float grade;
    private String content;
    private String rightAnswer;
    private Integer num_file;

    private QuestionSubmission(Builder builder) {
        super.setId(builder.questionSubmissionId);
        userId = builder.userId;
        examSubmissionId = builder.examSubmissionId;
        questionId = builder.questionId;
        pass_status = builder.pass_status;
        grade = builder.grade;
        content = builder.content;
        rightAnswer = builder.rightAnswer;
        num_file = builder.num_file;
    }

    public static Builder builder() {
        return new Builder();
    }

    public UserId getUserId() {
        return userId;
    }

    public ExamSubmissionId getExamSubmissionId() {
        return examSubmissionId;
    }

    public QuestionId getQuestionId() {
        return questionId;
    }

    public Integer getPass_status() {
        return pass_status;
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

    public Integer getNum_file() {
        return num_file;
    }

    public static final class Builder {
        private QuestionSubmissionId questionSubmissionId;
        private UserId userId;
        private ExamSubmissionId examSubmissionId;
        private QuestionId questionId;
        private Integer pass_status;
        private Float grade;
        private String content;
        private String rightAnswer;
        private Integer num_file;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public QuestionSubmissionId getQuestionSubmissionId() {
            return questionSubmissionId;
        }

        public UserId getUserId() {
            return userId;
        }

        public ExamSubmissionId getExamSubmissionId() {
            return examSubmissionId;
        }

        public QuestionId getQuestionId() {
            return questionId;
        }

        public Integer getPass_status() {
            return pass_status;
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

        public Integer getNum_file() {
            return num_file;
        }

        public Builder id(QuestionSubmissionId val) {
            questionSubmissionId = val;
            return this;
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }

        public Builder examSubmissionId(ExamSubmissionId val) {
            examSubmissionId = val;
            return this;
        }

        public Builder questionId(QuestionId val) {
            questionId = val;
            return this;
        }

        public Builder pass_status(Integer val) {
            pass_status = val;
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

        public Builder num_file(Integer val) {
            num_file = val;
            return this;
        }

        public QuestionSubmission build() {
            return new QuestionSubmission(this);
        }
    }
}
