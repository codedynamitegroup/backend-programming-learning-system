package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.valueobject.CourseId;
import com.backend.programming.learning.system.valueobject.CourseUserId;

import java.util.UUID;

public class CourseUser extends AggregateRoot<CourseUserId> {
    public User user;
    public Course course;

    private CourseUser(Builder builder) {
        super.setId(builder.courseUserId);
        user = builder.user;
        course = builder.course;
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

        public CourseUser build() {
            return new CourseUser(this);
        }
    }
}
