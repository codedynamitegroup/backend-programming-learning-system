package com.backend.programming.learning.system.domain.entity;

import com.backend.programming.learning.system.domain.valueobject.QtypeEssayQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;

public class QtypeEssayQuestion extends BaseEntity<QtypeEssayQuestionId> {
    private final QuestionId questionId;
    private final String responseFormat;
    private final Integer responseRequired;
    private final Integer responseFieldLines;
    private final Integer minWordLimit;
    private final Integer maxWordLimit;
    private final Integer attachment;
    private final Integer attachmentRequired;
    private final String graderInfo;
    private final Integer graderInfoFormat;
    private final String responsetemplate;
    private final Integer maxBytes;
    private final String fileTypeList;

    private QtypeEssayQuestion(Builder builder) {
        super.setId(builder.qtypeEssayQuestionId);
        questionId = builder.questionId;
        responseFormat = builder.responseFormat;
        responseRequired = builder.responseRequired;
        responseFieldLines = builder.responseFieldLines;
        minWordLimit = builder.minWordLimit;
        maxWordLimit = builder.maxWordLimit;
        attachment = builder.attachment;
        attachmentRequired = builder.attachmentRequired;
        graderInfo = builder.graderInfo;
        graderInfoFormat = builder.graderInfoFormat;
        responsetemplate = builder.responsetemplate;
        maxBytes = builder.maxBytes;
        fileTypeList = builder.fileTypeList;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private QtypeEssayQuestionId qtypeEssayQuestionId;
        private QuestionId questionId;
        private String responseFormat;
        private Integer responseRequired;
        private Integer responseFieldLines;
        private Integer minWordLimit;
        private Integer maxWordLimit;
        private Integer attachment;
        private Integer attachmentRequired;
        private String graderInfo;
        private Integer graderInfoFormat;
        private String responsetemplate;
        private Integer maxBytes;
        private String fileTypeList;

        private Builder() {
        }

        public Builder id(QtypeEssayQuestionId val) {
            qtypeEssayQuestionId = val;
            return this;
        }

        public Builder questionId(QuestionId val) {
            questionId = val;
            return this;
        }

        public Builder responseFormat(String val) {
            responseFormat = val;
            return this;
        }

        public Builder responseRequired(Integer val) {
            responseRequired = val;
            return this;
        }

        public Builder responseFieldLines(Integer val) {
            responseFieldLines = val;
            return this;
        }

        public Builder minWordLimit(Integer val) {
            minWordLimit = val;
            return this;
        }

        public Builder maxWordLimit(Integer val) {
            maxWordLimit = val;
            return this;
        }

        public Builder attachment(Integer val) {
            attachment = val;
            return this;
        }

        public Builder attachmentRequired(Integer val) {
            attachmentRequired = val;
            return this;
        }

        public Builder graderInfo(String val) {
            graderInfo = val;
            return this;
        }

        public Builder graderInfoFormat(Integer val) {
            graderInfoFormat = val;
            return this;
        }

        public Builder responsetemplate(String val) {
            responsetemplate = val;
            return this;
        }

        public Builder maxBytes(Integer val) {
            maxBytes = val;
            return this;
        }

        public Builder fileTypeList(String val) {
            fileTypeList = val;
            return this;
        }

        public QtypeEssayQuestion build() {
            return new QtypeEssayQuestion(this);
        }
    }
}
