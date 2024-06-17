package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.course.service.domain.valueobject.AssignmentSubmissionFileId;

import java.time.ZonedDateTime;
import java.util.UUID;

public class SubmissionAssignmentFile extends AggregateRoot<AssignmentSubmissionFileId> {
    private SubmissionAssignment submissionAssignment;
    private String fileName;
    private Integer fileSize;
    private ZonedDateTime timemodified;
    private String mimetype;
    private String fileUrl;

    private SubmissionAssignmentFile(Builder builder) {
        super.setId(builder.assignmentSubmissionFileId);
        submissionAssignment = builder.submissionAssignment;
        fileName = builder.fileName;
        fileSize = builder.fileSize;
        timemodified = builder.timemodified;
        mimetype = builder.mimetype;
        fileUrl = builder.fileUrl;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SubmissionAssignment getAssignmentSubmission() {
        return submissionAssignment;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String filename) {
        this.fileName = filename;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }


    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public ZonedDateTime getTimemodified() {
        return timemodified;
    }

    public void setTimemodified(ZonedDateTime timemodified) {
        this.timemodified = timemodified;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
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
        private String fileName;
        private Integer fileSize;
        private ZonedDateTime timemodified;
        private String mimetype;
        private String fileUrl;

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

        public Builder fileName(String val) {
            fileName = val;
            return this;
        }

        public Builder fileSize(Integer val) {
            fileSize = val;
            return this;
        }

        public Builder timemodified(ZonedDateTime val) {
            timemodified = val;
            return this;
        }

        public Builder mimetype(String val) {
            mimetype = val;
            return this;
        }

        public Builder fileUrl(String val) {
            fileUrl = val;
            return this;
        }

        public SubmissionAssignmentFile build() {
            return new SubmissionAssignmentFile(this);
        }
    }
}
