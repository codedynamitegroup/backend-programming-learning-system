package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.valueobject.CallMoodleApiFunctionId;
import com.backend.programming.learning.system.valueobject.CallOrganizationId;

public class CallOrganization extends AggregateRoot<CallOrganizationId> {

    private OrganizationId organizationId;
    private CallMoodleApiFunctionId callMoodleApiFunctionId;

    private CallOrganization(Builder builder) {
        super.setId(builder.callOrganizationId);
        organizationId = builder.organizationId;
        callMoodleApiFunctionId = builder.callMoodleApiFunctionId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public OrganizationId getOrganizationId() {
        return organizationId;
    }

    public CallMoodleApiFunctionId getCallMoodleApiFunctionId() {
        return callMoodleApiFunctionId;
    }

    public static final class Builder {
        private CallOrganizationId callOrganizationId;
        private OrganizationId organizationId;
        private CallMoodleApiFunctionId callMoodleApiFunctionId;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(CallOrganizationId val) {
            callOrganizationId = val;
            return this;
        }

        public Builder organizationId(OrganizationId val) {
            organizationId = val;
            return this;
        }

        public Builder callMoodleApiFunctionId(CallMoodleApiFunctionId val) {
            callMoodleApiFunctionId = val;
            return this;
        }

        public CallOrganization build() {
            return new CallOrganization(this);
        }
    }
}
