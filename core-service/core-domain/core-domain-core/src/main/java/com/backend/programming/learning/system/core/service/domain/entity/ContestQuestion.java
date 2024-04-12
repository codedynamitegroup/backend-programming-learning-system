package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterQuestionId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestQuestionId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;

public class ContestQuestion extends AggregateRoot<ContestQuestionId> {
    private final QuestionId questionId;
    private final ContestId contestId;

    private ContestQuestion(Builder builder) {
        super.setId(builder.contestQuestionId);
        questionId = builder.questionId;
        contestId = builder.contestId;
    }

    public static Builder builder() {
        return new Builder();
    }


    public QuestionId getQuestionId() {
        return questionId;
    }

    public ContestId getContestId() {
        return contestId;
    }

    public static final class Builder {
        private ContestQuestionId contestQuestionId;
        private QuestionId questionId;
        private ContestId contestId;

        private Builder() {
        }

        public Builder id(ContestQuestionId val) {
            contestQuestionId = val;
            return this;
        }

        public Builder questionId(QuestionId val) {
            questionId = val;
            return this;
        }

        public Builder contestId(ContestId val) {
            contestId = val;
            return this;
        }

        public ContestQuestion build() {
            return new ContestQuestion(this);
        }
    }
}
