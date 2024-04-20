package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.SubmissionAssignmentId;
import com.backend.programming.learning.system.valueobject.AssignmentSubmissionOnlineTextId;

public class AssignmentSubmissionOnlineText extends AggregateRoot<AssignmentSubmissionOnlineTextId> {

    private SubmissionAssignmentId submissionAssignmentId;
    private String content;

    private AssignmentSubmissionOnlineText(Builder builder) {
        super.setId(builder.assignmentSubmissionOnlineTextId);
        submissionAssignmentId = builder.submissionAssignmentId;
        content = builder.content;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SubmissionAssignmentId getAssignmentSubmissionId() {
        return submissionAssignmentId;
    }

    public String getContent() {
        return content;
    }

    public static final class Builder {
        private AssignmentSubmissionOnlineTextId assignmentSubmissionOnlineTextId;
        private SubmissionAssignmentId submissionAssignmentId;
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

        public Builder assignmentSubmissionId(SubmissionAssignmentId val) {
            submissionAssignmentId = val;
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
