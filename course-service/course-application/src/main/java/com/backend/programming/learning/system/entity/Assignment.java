package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.AssignmentId;
import com.backend.programming.learning.system.valueobject.CourseId;

import java.time.LocalDateTime;

public class Assignment extends AggregateRoot<AssignmentId> {

    private CourseId courseId;
    private String title;
    private String intro;
    private Float scores;

    private Float maxScores;
    private final LocalDateTime time_open;
    private LocalDateTime time_close;
    private Integer time_limit;
    private Integer type;
    private Boolean visible;

    private Assignment(Builder builder) {
        super.setId(builder.assignmentId);
        courseId = builder.courseId;
        title = builder.title;
        intro = builder.intro;
        scores = builder.scores;
        maxScores = builder.maxScores;
        time_open = builder.time_open;
        time_close = builder.time_close;
        time_limit = builder.time_limit;
        type = builder.type;
        visible = builder.visible;
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

    public Float getScores() {
        return scores;
    }

    public Float getMaxScores() {
        return maxScores;
    }

    public LocalDateTime getTime_open() {
        return time_open;
    }

    public LocalDateTime getTime_close() {
        return time_close;
    }

    public Integer getTime_limit() {
        return time_limit;
    }

    public Integer getType() {
        return type;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void initializeAssignment(CourseId couresId, AssignmentId assignmentId) {
        this.courseId = couresId;
        super.setId(assignmentId);
    }


    public static final class Builder {
        private AssignmentId assignmentId;
        private CourseId courseId;
        private String title;
        private String intro;
        private Float scores;
        private Float maxScores;
        private LocalDateTime time_open;
        private LocalDateTime time_close;
        private Integer time_limit;
        private Integer type;
        private Boolean visible;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder assignmentId(AssignmentId val) {
            assignmentId = val;
            return this;
        }

        public Builder courseId(CourseId val) {
            courseId = val;
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

        public Builder scores(Float val) {
            scores = val;
            return this;
        }

        public Builder maxScores(Float val) {
            maxScores = val;
            return this;
        }

        public Builder time_open(LocalDateTime val) {
            time_open = val;
            return this;
        }

        public Builder time_close(LocalDateTime val) {
            time_close = val;
            return this;
        }

        public Builder time_limit(Integer val) {
            time_limit = val;
            return this;
        }

        public Builder type(Integer val) {
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
