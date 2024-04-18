package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.valueobject.AssignmentId;
import com.backend.programming.learning.system.valueobject.CourseId;
import com.backend.programming.learning.system.valueobject.ExamId;
import com.backend.programming.learning.system.valueobject.PostId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class Course extends AggregateRoot<CourseId> {

    private String name;
    private String key;
    private Boolean visible;
    private final UserId createdBy;
    private final List<Post> posts;
    private final List<Exam> exams;

    private final List<Assignment> assignments;
    private UserId updatedBy;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public void initializeCourse(CourseId courseId) {
        setId(new CourseId(UUID.randomUUID()));

    }
    public void initializeCourse() {
        setId(new CourseId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
        updatedAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
    }

    private void initializePost(PostId postId) {
        for(Post post: posts){
            post.initializePost(super.getId(), new PostId(UUID.randomUUID()));
        }
    }
    private void initializeExam(ExamId examId) {
        for(Exam exam: exams){
            exam.initializeExam(super.getId(), new ExamId(UUID.randomUUID()));
        }
    }

    private Course(Builder builder) {
        super.setId(builder.courseId);
        name = builder.name;
        key = builder.key;
        visible = builder.visible;
        posts = builder.posts;
        exams = builder.exams;
        assignments = builder.assignments;
        createdBy = builder.createdBy;
        updatedBy = builder.updatedBy;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public Boolean getVisible() {
        return visible;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public UserId getCreatedBy() {
        return createdBy;
    }

    public UserId getUpdatedBy() {
        return updatedBy;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }


    public static final class Builder {
        private CourseId courseId;
        private String name;
        private String key;
        private Boolean visible;

        private List<Post> posts;
        private List<Exam> exams;
        private List<Assignment> assignments;
        private UserId createdBy;
        private UserId updatedBy;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(CourseId val) {
            courseId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder key(String val) {
            key = val;
            return this;
        }

        public Builder visible(Boolean val) {
            visible = val;
            return this;
        }

        public Builder posts(List<Post> val) {
            posts = val;
            return this;
        }

        public Builder exams(List<Exam> val) {
            exams = val;
            return this;
        }

        public Builder createdBy(UserId val) {
            createdBy = val;
            return this;
        }

        public Builder updatedBy(UserId val) {
            updatedBy = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder updatedAt(ZonedDateTime val) {
            updatedAt = val;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}
