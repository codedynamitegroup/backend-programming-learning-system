package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.course.service.domain.valueobject.AssignmentId;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.Type;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Assignment extends AggregateRoot<AssignmentId> {
    private CourseId courseId;
    private Integer assignmentIdMoodle;
    private String title;
    private String intro;
    private String activity;

    private String wordLimit;
    private String maxUploadFiles;

    private String maxFileSize;

    private Float maxScores;
    private ZonedDateTime time_open;
    private ZonedDateTime time_close;

    private Boolean allowSubmitLate;
    private ZonedDateTime time_limit;
    private ZonedDateTime createdAt;
    private Type type;
    private Boolean visible;

    private Assignment(Builder builder) {
        super.setId(builder.assignmentId);
        assignmentIdMoodle = builder.assignmentIdMoodle;
        courseId = builder.courseId;
        title = builder.title;
        intro = builder.intro;
        activity = builder.activity;
        wordLimit = builder.wordLimit;
        maxUploadFiles = builder.maxUploadFiles;
        maxFileSize = builder.maxFileSize;
        allowSubmitLate = builder.allowSubmitLate;
        maxScores = builder.maxScores;
        time_open = builder.time_open;
        time_close = builder.time_close;
        time_limit = builder.time_limit;
        type = builder.type;
        visible = builder.visible;
        createdAt = builder.createdAt;
    }

    public void setTime_open(ZonedDateTime time_open) {
        this.time_open = time_open;
    }

    public Boolean getAllowSubmitLate() {
        return allowSubmitLate;
    }

    public void setAllowSubmitLate(Boolean allowSubmitLate) {
        this.allowSubmitLate = allowSubmitLate;
    }

    public String getWordLimit() {
        return wordLimit;
    }

    public void setWordLimit(String wordLimit) {
        this.wordLimit = wordLimit;
    }

    public String getMaxUploadFiles() {
        return maxUploadFiles;
    }

    public void setMaxUploadFiles(String maxUploadFiles) {
        this.maxUploadFiles = maxUploadFiles;
    }

    public String getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(String maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getActivity() {
        return activity;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Integer getAssignmentIdMoodle() {
        return assignmentIdMoodle;
    }

    public void setAssignmentIdMoodle(Integer assignmentIdMoodle) {
        this.assignmentIdMoodle = assignmentIdMoodle;
    }

    public CourseId getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getIntro() {
        return intro;
    }

    public Float getMaxScores() {
        return maxScores;
    }

    public ZonedDateTime getTime_open() {
        return time_open;
    }

    public ZonedDateTime getTime_close() {
        return time_close;
    }

    public ZonedDateTime getTime_limit() {
        return time_limit;
    }

    public Type getType() {
        return type;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setCourseId(CourseId courseId) {
        this.courseId = courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setMaxScores(Float maxScores) {
        this.maxScores = maxScores;
    }

    public void setTime_close(ZonedDateTime time_close) {
        this.time_close = time_close;
    }

    public void setTime_limit(ZonedDateTime time_limit) {
        this.time_limit = time_limit;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public void initializeAssignment() {
        super.setId(new AssignmentId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }



    public static final class Builder {
        private AssignmentId assignmentId;
        private Integer assignmentIdMoodle;
        private CourseId courseId;
        private String title;
        private String intro;

        private String activity;

        private String wordLimit;
        private String maxUploadFiles;

        private String maxFileSize;

        private Boolean allowSubmitLate;
        private Float maxScores;
        private ZonedDateTime time_open;
        private ZonedDateTime createdAt;
        private ZonedDateTime time_close;
        private ZonedDateTime time_limit;
        private Type type;
        private Boolean visible;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(AssignmentId val) {
            assignmentId = val;
            return this;
        }

        public Builder assignmentIdMoodle(Integer val) {
            assignmentIdMoodle = val;
            return this;
        }

        public Builder courseId(CourseId val) {
            courseId = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder intro(String val) {
            intro = val;
            return this;
        }


        public Builder activity(String val) {
            activity = val;
            return this;
        }


        public Builder wordLimit(String val) {
            wordLimit = val;
            return this;
        }

        public Builder maxUploadFiles(String val) {
            maxUploadFiles = val;
            return this;
        }

        public Builder maxFileSize(String val) {
            maxFileSize = val;
            return this;
        }

        public Builder allowSubmitLate(Boolean val) {
            allowSubmitLate = val;
            return this;
        }


        public Builder maxScores(Float val) {
            maxScores = val;
            return this;
        }

        public Builder time_open(ZonedDateTime val) {
            time_open = val;
            return this;
        }

        public Builder time_close(ZonedDateTime val) {
            time_close = val;
            return this;
        }

        public Builder time_limit(ZonedDateTime val) {
            time_limit = val;
            return this;
        }

        public Builder type(Type val) {
            type = val;
            return this;
        }

        public Builder visible(Boolean val) {
            visible = val;
            return this;
        }

        public Assignment build() {
            return new Assignment(this);
        }
    }
}
