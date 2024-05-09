package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.CourseTypeId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

public class CourseType extends AggregateRoot<CourseTypeId>{
    private Integer moodleId;
    private String name;
    public String getName() {
        return name;
    }

    public Integer getMoodleId() {
        return moodleId;
    }

    public void setMoodleId(Integer moodleId) {
        this.moodleId = moodleId;
    }

    public void setName(String name) {
        this.name = name;
    }

    private CourseType(Builder builder) {
        super.setId(builder.id);
        setName(builder.name);
    }

    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private CourseTypeId id;
        private Integer moodleId;
        private String name;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(CourseTypeId val) {
            id = val;
            return this;
        }

        public Builder moodleId(Integer val) {
            moodleId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public CourseType build() {
            return new CourseType(this);
        }
    }
}
