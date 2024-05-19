package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseUserId;

import java.util.UUID;

public class CourseUser extends AggregateRoot<CourseUserId> {
    public User user;
    public Course course;
    public RoleMoodle roleMoodle;

    private CourseUser(Builder builder) {
        super.setId(builder.courseUserId);
        user = builder.user;
        course = builder.course;
        roleMoodle = builder.roleMoodle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public RoleMoodle getRoleMoodle() {
        return roleMoodle;
    }

    public void setRoleMoodle(RoleMoodle roleMoodle) {
        this.roleMoodle = roleMoodle;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void initializeCourseUser() {
        setId(new CourseUserId(UUID.randomUUID()));
    }


    public static final class Builder {
        private CourseUserId courseUserId;
        private User user;
        private Course course;

        private RoleMoodle roleMoodle;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(CourseUserId val) {
            courseUserId = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder course(Course val) {
            course = val;
            return this;
        }

        public Builder roleMoodle(RoleMoodle val) {
            roleMoodle = val;
            return this;
        }

        public CourseUser build() {
            return new CourseUser(this);
        }
    }
}
