package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.CourseTypeId;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class CourseType extends AggregateRoot<CourseTypeId>{
    private Integer moodleId;
    private String name;

    private Organization organization;

    public void initializeCourseType() {
        setId(new CourseTypeId(UUID.randomUUID()));
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
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
        setMoodleId(builder.moodleId);
        setOrganization(builder.organization);
    }

    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private CourseTypeId id;
        private Integer moodleId;
        private String name;

        private Organization organization;

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

        public Builder organization(Organization val) {
            organization = val;
            return this;
        }

        public CourseType build() {
            return new CourseType(this);
        }
    }
}
