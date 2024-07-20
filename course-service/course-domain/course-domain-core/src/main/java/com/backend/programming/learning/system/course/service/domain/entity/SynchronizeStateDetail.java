package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.SynchronizeStateDetailId;
import com.backend.programming.learning.system.course.service.domain.valueobject.SynchronizeStateId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronize;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronizeStatus;

import java.time.ZonedDateTime;

public class SynchronizeStateDetail  extends AggregateRoot<SynchronizeStateDetailId> {

    private Organization organization;
    private TypeSynchronize typeSynchronize;
    private TypeSynchronizeStatus status;
    private String webhookMessage;
    private ZonedDateTime timeCreated;

    private SynchronizeStateDetail(Builder builder) {
        super.setId(builder.id);
        organization = builder.organization;
        typeSynchronize = builder.typeSynchronize;
        status = builder.status;
        webhookMessage = builder.webhookMessage;
        timeCreated = builder.timeCreated;
    }

    public static Builder builder() {
        return new Builder();
    }
    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public TypeSynchronize getTypeSynchronize() {
        return typeSynchronize;
    }

    public void setTypeSynchronize(TypeSynchronize typeSynchronize) {
        this.typeSynchronize = typeSynchronize;
    }

    public TypeSynchronizeStatus getStatus() {
        return status;
    }

    public void setStatus(TypeSynchronizeStatus status) {
        this.status = status;
    }

    public String getWebhookMessage() {
        return webhookMessage;
    }

    public void setWebhookMessage(String webhookMessage) {
        this.webhookMessage = webhookMessage;
    }

    public ZonedDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(ZonedDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public static final class Builder {
        private SynchronizeStateDetailId id;
        private Organization organization;
        private TypeSynchronize typeSynchronize;
        private TypeSynchronizeStatus status;
        private String webhookMessage;
        private ZonedDateTime timeCreated;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(SynchronizeStateDetailId val) {
             id= val;
            return this;
        }

        public Builder organization(Organization val) {
            organization = val;
            return this;
        }

        public Builder typeSynchronize(TypeSynchronize val) {
            typeSynchronize = val;
            return this;
        }

        public Builder status(TypeSynchronizeStatus val) {
            status = val;
            return this;
        }

        public Builder webhookMessage(String val) {
            webhookMessage = val;
            return this;
        }

        public Builder timeCreated(ZonedDateTime val) {
            timeCreated = val;
            return this;
        }

        public SynchronizeStateDetail build() {
            return new SynchronizeStateDetail(this);
        }
    }
}
