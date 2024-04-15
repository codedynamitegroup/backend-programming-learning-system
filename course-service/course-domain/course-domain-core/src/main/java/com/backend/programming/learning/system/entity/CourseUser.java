package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.valueobject.CourseId;
import com.backend.programming.learning.system.valueobject.CourseUserId;

public class CourseUser extends AggregateRoot<CourseUserId> {
    private UserId userId;
    private CourseId courseId;

    private CourseUser(Builder builder) {
        super.setId(builder.courseUserId);
        userId = builder.userId;
        courseId = builder.courseId;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private CourseUserId courseUserId;
        private UserId userId;
        private CourseId courseId;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(CourseUserId val) {
            courseUserId = val;
            return this;
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }

        public Builder courseId(CourseId val) {
            courseId = val;
            return this;
        }

        public CourseUser build() {
            return new CourseUser(this);
        }
    }
}
