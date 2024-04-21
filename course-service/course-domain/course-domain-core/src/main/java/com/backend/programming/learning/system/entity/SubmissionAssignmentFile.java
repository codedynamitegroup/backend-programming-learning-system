package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.AssignmentSubmissionFileId;
import com.backend.programming.learning.system.valueobject.SubmissionAssignmentId;

public class SubmissionAssignmentFile extends AggregateRoot<AssignmentSubmissionFileId> {
    private SubmissionAssignmentId submissionAssignmentId;
    private Integer num_file;

    private SubmissionAssignmentFile(Builder builder) {
        super.setId(builder.assignmentSubmissionFileId);
        submissionAssignmentId = builder.submissionAssignmentId;
        num_file = builder.num_file;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SubmissionAssignmentId getAssignmentSubmissionId() {
        return submissionAssignmentId;
    }

    public Integer getNum_file() {
        return num_file;
    }

    public static final class Builder {
        private AssignmentSubmissionFileId assignmentSubmissionFileId;
        private SubmissionAssignmentId submissionAssignmentId;
        private Integer num_file;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(AssignmentSubmissionFileId val) {
            assignmentSubmissionFileId = val;
            return this;
        }

        public Builder assignmentSubmissionId(SubmissionAssignmentId val) {
            submissionAssignmentId = val;
            return this;
        }

        public Builder num_file(Integer val) {
            num_file = val;
            return this;
        }

        public SubmissionAssignmentFile build() {
            return new SubmissionAssignmentFile(this);
        }
    }
}
