package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.IntroFileId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

import java.time.ZonedDateTime;

public class IntroFile extends AggregateRoot<IntroFileId> {
    private Assignment assignment;
    private String fileName;
    private Integer fileSize;
    private ZonedDateTime timemodified;
    private String mimetype;
    private String fileUrl;

    private IntroFile(Builder builder) {
        super.setId(builder.id);
        setAssignment(builder.assignment);
        setFileName(builder.fileName);
        setFileSize(builder.fileSize);
        setTimemodified(builder.timemodified);
        setMimetype(builder.mimetype);
        setFileUrl(builder.fileUrl);
    }

    public static Builder builder() {
        return new Builder();
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
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
        private IntroFileId id;
        private Assignment assignment;
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

        public Builder id(IntroFileId val) {
            id = val;
            return this;
        }

        public Builder assignment(Assignment val) {
            assignment = val;
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

        public IntroFile build() {
            return new IntroFile(this);
        }
    }
}
