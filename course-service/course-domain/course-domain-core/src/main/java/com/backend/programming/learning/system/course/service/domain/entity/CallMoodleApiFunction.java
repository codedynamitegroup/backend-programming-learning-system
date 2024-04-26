package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.course.service.domain.valueobject.CallMoodleApiFunctionId;

import java.util.UUID;

public class CallMoodleApiFunction extends AggregateRoot<CallMoodleApiFunctionId> {

    private String area;
    private String name;
    private String description;

    private CallMoodleApiFunction(Builder builder) {
        super.setId(builder.callMoodleApiFunctionId);
        area = builder.area;
        name = builder.name;
        description = builder.description;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void initializeCallMoodleApiFunction() {
        setId(new CallMoodleApiFunctionId(UUID.randomUUID()));
    }

    public static final class Builder {
        private CallMoodleApiFunctionId callMoodleApiFunctionId;
        private String area;
        private String name;
        private String description;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(CallMoodleApiFunctionId val) {
            callMoodleApiFunctionId = val;
            return this;
        }

        public Builder area(String val) {
            area = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public CallMoodleApiFunction build() {
            return new CallMoodleApiFunction(this);
        }
    }
}
