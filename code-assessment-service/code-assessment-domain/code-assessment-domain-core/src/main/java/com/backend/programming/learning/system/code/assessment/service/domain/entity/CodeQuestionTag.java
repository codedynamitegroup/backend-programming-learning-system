package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.code_question_tag.CodeQuestionTagId;
import com.backend.programming.learning.system.domain.entity.BaseEntity;

public class CodeQuestionTag extends BaseEntity<CodeQuestionTagId> {


    private CodeQuestionTag(Builder builder) {
        super.setId(builder.id);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private CodeQuestionTagId id;

        private Builder() {
        }

        public Builder id(CodeQuestionTagId val) {
            id = val;
            return this;
        }

        public CodeQuestionTag build() {
            return new CodeQuestionTag(this);
        }
    }
}
