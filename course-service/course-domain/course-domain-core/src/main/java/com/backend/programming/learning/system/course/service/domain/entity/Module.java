package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.ModuleId;
import com.backend.programming.learning.system.course.service.domain.valueobject.SectionId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

import java.time.ZonedDateTime;

public class Module extends AggregateRoot<ModuleId> {
    private Section section;
    private String name;
    private Integer visible;
    private ZonedDateTime timeOpen;
    private ZonedDateTime timeClose;

    private Module(Builder builder) {
        super.setId(builder.id);
        setSection(builder.section);
        setName(builder.name);
        setVisible(builder.visible);
        setTimeOpen(builder.timeOpen);
        setTimeClose(builder.timeClose);
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
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

    public ZonedDateTime getTimeOpen() {
        return timeOpen;
    }

    public void setTimeOpen(ZonedDateTime timeOpen) {
        this.timeOpen = timeOpen;
    }

    public ZonedDateTime getTimeClose() {
        return timeClose;
    }

    public void setTimeClose(ZonedDateTime timeClose) {
        this.timeClose = timeClose;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private ModuleId id;
        private Section section;
        private String name;
        private Integer visible;
        private ZonedDateTime timeOpen;
        private ZonedDateTime timeClose;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(ModuleId val) {
            id = val;
            return this;
        }

        public Builder section(Section val) {
            section = val;
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

        public Builder timeOpen(ZonedDateTime val) {
            timeOpen = val;
            return this;
        }

        public Builder timeClose(ZonedDateTime val) {
            timeClose = val;
            return this;
        }

        public Module build() {
            return new Module(this);
        }
    }
}
