package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;


public class Course extends AggregateRoot<CourseId> {
    private String name;
    private Integer courseIdMoodle;
    private List<User> teachers;
    private Organization organization;
    private CourseType courseType;
    private String key;
    private Boolean visible;
    private User createdBy;
    private List<Post> posts;
    private List<Exam> exams;
    private List<Assignment> assignments;
    private User updatedBy;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private Course(Builder builder) {
        super.setId(builder.courseId);
        courseIdMoodle = builder.courseIdMoodle;
        teachers = builder.teachers;
        organization = builder.organization;
        name = builder.name;
        courseType = builder.courseType;
        key = builder.key;
        visible = builder.visible;
        createdBy = builder.createdBy;
        posts = builder.posts;
        exams = builder.exams;
        assignments = builder.assignments;
        updatedBy = builder.updatedBy;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public void initializeCourse() {
        setId(new CourseId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of("UTC"));
        updatedAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Integer getCourseIdMoodle() {
        return courseIdMoodle;
    }

    public void setCourseIdMoodle(Integer courseIdMoodle) {
        this.courseIdMoodle = courseIdMoodle;
    }
    public List<User> getTeachers() {
        return teachers;
    }
    public void setTeachers(List<User> teachers) {
        this.teachers = teachers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private CourseId courseId;
        private Integer courseIdMoodle;
        private List<User> teachers;
        private Organization organization;
        private String name;
        private CourseType courseType;
        private String key;
        private Boolean visible;
        private User createdBy;
        private List<Post> posts;
        private List<Exam> exams;
        private List<Assignment> assignments;
        private User updatedBy;
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

        public Builder courseIdMoodle(Integer val) {
            courseIdMoodle = val;
            return this;
        }

        public Builder teachers(List<User> val) {
            teachers = val;
            return this;
        }

        public Builder organization(Organization val) {
            organization = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder courseType(CourseType val) {
            courseType = val;
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

        public Builder createdBy(User val) {
            createdBy = val;
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

        public Builder assignments(List<Assignment> val) {
            assignments = val;
            return this;
        }

        public Builder updatedBy(User val) {
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
