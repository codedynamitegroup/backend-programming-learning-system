package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterQuestionId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestQuestionId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;

public class ContestQuestion extends BaseEntity<ContestQuestionId> {
    private final Question question;
    private final Contest contest;

    private ContestQuestion(Builder builder) {
        super.setId(builder.contestQuestionId);
        question = builder.question;
        contest = builder.contest;
    }

    public static Builder builder() {
        return new Builder();
    }


    public Question getQuestion() {
        return question;
    }

    public Contest getContest() {
        return contest;
    }

    public static final class Builder {
        private ContestQuestionId contestQuestionId;
        private Question question;
        private Contest contest;

        private Builder() {
        }

        public Builder id(ContestQuestionId val) {
            contestQuestionId = val;
            return this;
        }

        public Builder question(Question val) {
            question = val;
            return this;
        }

        public Builder contest(Contest val) {
            contest = val;
            return this;
        }

        public ContestQuestion build() {
            return new ContestQuestion(this);
        }
    }
}
