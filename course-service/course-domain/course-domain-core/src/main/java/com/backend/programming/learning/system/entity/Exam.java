package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.CourseId;
import com.backend.programming.learning.system.valueobject.ExamId;

import java.time.LocalDateTime;

public class Exam extends AggregateRoot<ExamId> {

    private CourseId courseId;
    private String name;
    private Float scores;
    private Float maxScores;

    private final LocalDateTime time_open;
    private LocalDateTime time_close;
    private Integer time_limit;

    private String intro;
    private String overdue_handing;
    private Boolean can_redo_questions;
    private Integer max_attempts;

    private Boolean shuffle_answers;
    private String grade_method;
    private final LocalDateTime created_at;
    private LocalDateTime updated_at;

    private Exam(Builder builder) {
        super.setId(builder.examId);;
        courseId = builder.courseId;
        name = builder.name;
        scores = builder.scores;
        maxScores = builder.maxScores;
        time_open = builder.time_open;
        time_close = builder.time_close;
        time_limit = builder.time_limit;
        intro = builder.intro;
        overdue_handing = builder.overdue_handing;
        can_redo_questions = builder.can_redo_questions;
        max_attempts = builder.max_attempts;
        shuffle_answers = builder.shuffle_answers;
        grade_method = builder.grade_method;
        created_at = builder.created_at;
        updated_at = builder.updated_at;
    }

    public CourseId getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
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

    public String getIntro() {
        return intro;
    }

    public String getOverdue_handing() {
        return overdue_handing;
    }

    public Boolean getCan_redo_questions() {
        return can_redo_questions;
    }

    public Integer getMax_attempts() {
        return max_attempts;
    }

    public Boolean getShuffle_answers() {
        return shuffle_answers;
    }

    public String getGrade_method() {
        return grade_method;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void initializeExam(CourseId courseId, ExamId examId) {
        this.courseId = courseId;
        this.setId(examId);
    }


    public static final class Builder {
        private ExamId examId;
        private CourseId courseId;
        private String name;
        private Float scores;
        private Float maxScores;
        private LocalDateTime time_open;
        private LocalDateTime time_close;
        private Integer time_limit;
        private String intro;
        private String overdue_handing;
        private Boolean can_redo_questions;
        private Integer max_attempts;
        private Boolean shuffle_answers;
        private String grade_method;
        private LocalDateTime created_at;
        private LocalDateTime updated_at;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder examId(ExamId val) {
            examId = val;
            return this;
        }

        public Builder courseId(CourseId val) {
            courseId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
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

        public Builder intro(String val) {
            intro = val;
            return this;
        }

        public Builder overdue_handing(String val) {
            overdue_handing = val;
            return this;
        }

        public Builder can_redo_questions(Boolean val) {
            can_redo_questions = val;
            return this;
        }

        public Builder max_attempts(Integer val) {
            max_attempts = val;
            return this;
        }

        public Builder shuffle_answers(Boolean val) {
            shuffle_answers = val;
            return this;
        }

        public Builder grade_method(String val) {
            grade_method = val;
            return this;
        }

        public Builder created_at(LocalDateTime val) {
            created_at = val;
            return this;
        }

        public Builder updated_at(LocalDateTime val) {
            updated_at = val;
            return this;
        }

        public Exam build() {
            return new Exam(this);
        }
    }
}
