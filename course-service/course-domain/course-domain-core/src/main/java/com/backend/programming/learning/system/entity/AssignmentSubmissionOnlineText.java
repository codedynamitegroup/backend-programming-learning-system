package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.AssignmentSubmissionId;
import com.backend.programming.learning.system.valueobject.AssignmentSubmissionOnlineTextId;

public class AssignmentSubmissionOnlineText extends AggregateRoot<AssignmentSubmissionOnlineTextId> {

    private AssignmentSubmissionId assignmentSubmissionId;
    private String content;

    private AssignmentSubmissionOnlineText(Builder builder) {
        super.setId(builder.assignmentSubmissionOnlineTextId);
        assignmentSubmissionId = builder.assignmentSubmissionId;
        content = builder.content;
    }

    public static Builder builder() {
        return new Builder();
    }

    public AssignmentSubmissionId getAssignmentSubmissionId() {
        return assignmentSubmissionId;
    }

    public String getContent() {
        return content;
    }

    public static final class Builder {
        private AssignmentSubmissionOnlineTextId assignmentSubmissionOnlineTextId;
        private AssignmentSubmissionId assignmentSubmissionId;
        private String content;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(AssignmentSubmissionOnlineTextId val) {
            assignmentSubmissionOnlineTextId = val;
            return this;
        }

        public Builder assignmentSubmissionId(AssignmentSubmissionId val) {
            assignmentSubmissionId = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public AssignmentSubmissionOnlineText build() {
            return new AssignmentSubmissionOnlineText(this);
        }
    }
}
