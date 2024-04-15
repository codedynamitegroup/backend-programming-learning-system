package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.AssignmentSubmissionFileId;
import com.backend.programming.learning.system.valueobject.AssignmentSubmissionId;

public class AssignmentSubmissionFile extends AggregateRoot<AssignmentSubmissionFileId> {
    private AssignmentSubmissionId assignmentSubmissionId;
    private Integer num_file;

    private AssignmentSubmissionFile(Builder builder) {
        super.setId(builder.assignmentSubmissionFileId);
        assignmentSubmissionId = builder.assignmentSubmissionId;
        num_file = builder.num_file;
    }

    public static Builder builder() {
        return new Builder();
    }

    public AssignmentSubmissionId getAssignmentSubmissionId() {
        return assignmentSubmissionId;
    }

    public Integer getNum_file() {
        return num_file;
    }

    public static final class Builder {
        private AssignmentSubmissionFileId assignmentSubmissionFileId;
        private AssignmentSubmissionId assignmentSubmissionId;
        private Integer num_file;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder assignmentSubmissionFileId(AssignmentSubmissionFileId val) {
            assignmentSubmissionFileId = val;
            return this;
        }

        public Builder assignmentSubmissionId(AssignmentSubmissionId val) {
            assignmentSubmissionId = val;
            return this;
        }

        public Builder num_file(Integer val) {
            num_file = val;
            return this;
        }

        public AssignmentSubmissionFile build() {
            return new AssignmentSubmissionFile(this);
        }
    }
}
