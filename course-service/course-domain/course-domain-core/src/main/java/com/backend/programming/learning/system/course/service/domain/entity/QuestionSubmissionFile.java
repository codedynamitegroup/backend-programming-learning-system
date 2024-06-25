package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.QuestionSubmissionFileId;
import com.backend.programming.learning.system.domain.entity.BaseEntity;

public class QuestionSubmissionFile  extends BaseEntity<QuestionSubmissionFileId> {
    private final QuestionSubmission questionSubmission;
    private final String url;

    private QuestionSubmissionFile(Builder builder) {
        super.setId(builder.id);
        questionSubmission = builder.questionSubmission;
        url = builder.url;
    }

    public static Builder builder() {
        return new Builder();
    }

    public QuestionSubmission getQuestionSubmission() {
        return questionSubmission;
    }

    public String getUrl() {
        return url;
    }


    public static final class Builder {
        private QuestionSubmissionFileId id;
        private QuestionSubmission questionSubmission;
        private String url;

        private Builder() {
        }

        public Builder id(QuestionSubmissionFileId val) {
            id = val;
            return this;
        }

        public Builder questionSubmission(QuestionSubmission val) {
            questionSubmission = val;
            return this;
        }

        public Builder url(String val) {
            url = val;
            return this;
        }

        public QuestionSubmissionFile build() {
            return new QuestionSubmissionFile(this);
        }
    }
}
