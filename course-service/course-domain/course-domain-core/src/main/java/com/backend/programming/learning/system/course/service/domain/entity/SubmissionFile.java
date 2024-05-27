package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.SubmissionFileId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

import java.time.ZonedDateTime;
import java.util.UUID;

public class SubmissionFile extends AggregateRoot<SubmissionFileId> {
    private SubmissionAssignmentFile submissionAssignmentFile;
    private String fileName;
    private Integer fileSize;
    private ZonedDateTime timemodified;
    private String mimetype;
    private String fileUrl;

    private SubmissionFile(Builder builder) {
        super.setId(builder.id);
        setSubmissionAssignmentFile(builder.submissionAssignmentFile);
        setFileName(builder.fileName);
        setFileSize(builder.fileSize);
        setTimemodified(builder.timemodified);
        setMimetype(builder.mimetype);
        setFileUrl(builder.fileUrl);
    }

    public static Builder builder() {
        return new Builder();
    }

    public SubmissionAssignmentFile getSubmissionAssignmentFile() {
        return submissionAssignmentFile;
    }

    public void setSubmissionAssignmentFile(SubmissionAssignmentFile submissionAssignmentFile) {
        this.submissionAssignmentFile = submissionAssignmentFile;
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


    public static final class Builder {
        private SubmissionFileId id;
        private SubmissionAssignmentFile submissionAssignmentFile;
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

        public Builder id(SubmissionFileId val) {
            id = val;
            return this;
        }

        public Builder submissionAssignmentFile(SubmissionAssignmentFile val) {
            submissionAssignmentFile = val;
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

        public SubmissionFile build() {
            return new SubmissionFile(this);
        }
    }
}
