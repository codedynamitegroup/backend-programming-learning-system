package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.QuestionSubmissionFileId;
import com.backend.programming.learning.system.domain.entity.BaseEntity;

public class QuestionSubmissionFile  extends BaseEntity<QuestionSubmissionFileId> {
    private final QuestionSubmission questionSubmission;
    private final String url;
    private final String name;
    private final String type;
    private final Float size;

    private QuestionSubmissionFile(Builder builder) {
        super.setId(builder.id);
        questionSubmission = builder.questionSubmission;
        url = builder.url;
        name = builder.name;
        type = builder.type;
        size = builder.size;
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

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Float getSize() {
        return size;
    }

    public static final class Builder {
        private QuestionSubmissionFileId id;
        private QuestionSubmission questionSubmission;
        private String url;
        private String name;
        private String type;
        private Float size;

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

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder type(String val) {
            type = val;
            return this;
        }

        public Builder size(Float val) {
            size = val;
            return this;
        }

        public QuestionSubmissionFile build() {
            return new QuestionSubmissionFile(this);
        }
    }
}
