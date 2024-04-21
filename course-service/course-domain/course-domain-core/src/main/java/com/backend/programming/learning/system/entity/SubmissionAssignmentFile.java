package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.AssignmentSubmissionFileId;
import com.backend.programming.learning.system.valueobject.SubmissionAssignmentId;

import java.util.UUID;

public class SubmissionAssignmentFile extends AggregateRoot<AssignmentSubmissionFileId> {
    private SubmissionAssignment submissionAssignment;
    private Integer num_file;

    private SubmissionAssignmentFile(Builder builder) {
        super.setId(builder.assignmentSubmissionFileId);
        submissionAssignment = builder.submissionAssignment;
        num_file = builder.num_file;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SubmissionAssignment getAssignmentSubmission() {
        return submissionAssignment;
    }

    public Integer getNum_file() {
        return num_file;
    }

    public void setSubmissionAssignment(SubmissionAssignment submissionAssignment) {

        this.submissionAssignment = submissionAssignment;
    }

    public void initializeSubmissionAssignmentFile() {
        setId(new AssignmentSubmissionFileId(UUID.randomUUID()));
    }

    public static final class Builder {
        private AssignmentSubmissionFileId assignmentSubmissionFileId;
        private SubmissionAssignment submissionAssignment;
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

        public Builder assignmentSubmission(SubmissionAssignment val) {
            submissionAssignment = val;
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
