package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.QtypeCodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZonedDateTime;

public class CodeSubmissionContest extends BaseEntity<CodeSubmissionId> {
    private ContestId contestId;

    private CodeSubmissionContest(Builder builder) {
        super.setId(builder.codeSubmissionId);
        setContestId(builder.contestId);
    }

    public static Builder builder() {
        return new Builder();
    }


    public ContestId getContestId() {
        return contestId;
    }

    public void setContestId(ContestId contestId) {
        this.contestId = contestId;
    }

    public static final class Builder {
        private CodeSubmissionId codeSubmissionId;
        private ContestId contestId;

        private Builder() {
        }

        public Builder id(CodeSubmissionId val) {
            codeSubmissionId = val;
            return this;
        }

        public Builder contestId(ContestId val) {
            contestId = val;
            return this;
        }

        public CodeSubmissionContest build() {
            return new CodeSubmissionContest(this);
        }
    }
}
