package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.SectionId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

public class Section extends AggregateRoot<SectionId> {
    private CourseId courseId;
    private String name;
    private Integer visible;

    private Section(Builder builder) {
        super.setId(builder.id);
        setCourseId(builder.courseId);
        setName(builder.name);
        setVisible(builder.visible);
    }

    public static Builder builder() {
        return new Builder();
    }


    public CourseId getCourseId() {
        return courseId;
    }

    public void setCourseId(CourseId courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public static final class Builder {
        private SectionId id;

        private CourseId courseId;
        private String name;
        private Integer visible;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(SectionId val) {
            id = val;
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



        public Builder visible(Integer val) {
            visible = val;
            return this;
        }

        public Section build() {
            return new Section(this);
        }
    }
}
