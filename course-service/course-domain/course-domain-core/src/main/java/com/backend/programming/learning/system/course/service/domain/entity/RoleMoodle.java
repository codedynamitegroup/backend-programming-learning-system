package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.RoleMoodleId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;


public class RoleMoodle extends AggregateRoot<RoleMoodleId> {
    private String name;

    private RoleMoodle(Builder builder) {
        super.setId(builder.id);
        setName(builder.name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private RoleMoodleId id;
        private String name;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(RoleMoodleId val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public RoleMoodle build() {
            return new RoleMoodle(this);
        }
    }
}
