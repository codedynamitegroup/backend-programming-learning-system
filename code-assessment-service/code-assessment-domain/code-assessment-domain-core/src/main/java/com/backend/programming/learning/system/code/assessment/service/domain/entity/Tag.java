package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

import java.util.UUID;

public class Tag extends AggregateRoot<TagId> {
    private String name;
    private Integer numOfCodeQuestion;

    public String getName() {
        return name;
    }

    public Integer getNumOfCodeQuestion() {
        return numOfCodeQuestion;
    }

    private Tag(Builder builder) {
        super.setId(builder.id);
        name = builder.name;
        numOfCodeQuestion = builder.numOfCodeQuestion;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void inititate() {
        super.setId(new TagId(UUID.randomUUID()));
    }

    public static final class Builder {
        private String name;
        private Integer numOfCodeQuestion;
        private TagId id;

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

        public Builder numOfCodeQuestion(Integer val) {
            numOfCodeQuestion = val;
            return this;
        }

        public Tag build() {
            return new Tag(this);
        }

    }
}
