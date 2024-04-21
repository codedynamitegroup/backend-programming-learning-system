package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.SubmissionAssignmentOnlineTextId;

import java.util.UUID;

public class SubmissionAssignmentOnlineText extends AggregateRoot<SubmissionAssignmentOnlineTextId> {
    private SubmissionAssignment submissionAssignment;
    private String content;

    private SubmissionAssignmentOnlineText(Builder builder) {
        super.setId(builder.submissionAssignmentOnlineTextId);
        submissionAssignment = builder.submissionAssignment;
        content = builder.content;
    }
    public SubmissionAssignment getSubmissionAssignment() {
        return submissionAssignment;
    }

    public void setSubmissionAssignment(SubmissionAssignment submissionAssignment) {
        this.submissionAssignment = submissionAssignment;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getContent() {
        return content;
    }

    public void initializeSubmissionAssignmentOnlineText() {
        setId(new SubmissionAssignmentOnlineTextId(UUID.randomUUID()));
    }



    public static final class Builder {
        private SubmissionAssignmentOnlineTextId submissionAssignmentOnlineTextId;
        private SubmissionAssignment submissionAssignment;
        private String content;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(SubmissionAssignmentOnlineTextId val) {
            submissionAssignmentOnlineTextId = val;
            return this;
        }

        public Builder assignmentSubmission(SubmissionAssignment val) {
            submissionAssignment = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public SubmissionAssignmentOnlineText build() {
            return new SubmissionAssignmentOnlineText(this);
        }
    }
}
