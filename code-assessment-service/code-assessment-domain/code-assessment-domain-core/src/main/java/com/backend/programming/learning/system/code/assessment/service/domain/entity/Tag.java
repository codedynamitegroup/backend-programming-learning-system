package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

import java.util.UUID;

public class Tag extends AggregateRoot<TagId> {
    private String name;

    public String getName() {
        return name;
    }

    private Tag(Builder builder) {
        super.setId(builder.id);
        name = builder.name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void inititate() {
        super.setId(new TagId(UUID.randomUUID()));
    }

    public static final class Builder {
        private TagId id;
        private String name;

        private Builder() {
        }

        public Builder id(TagId val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Tag build() {
            return new Tag(this);
        }
    }
}
