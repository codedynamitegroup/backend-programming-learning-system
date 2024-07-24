package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.SynchronizeStateId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStep;

import java.time.ZonedDateTime;
import java.util.UUID;

public class SynchronizeState extends AggregateRoot<SynchronizeStateId>{
    private SynchronizeStatus status;

    private User user;

    private Organization organization;

    private SynchronizeStep step;

    private Integer syncCount;

    private ZonedDateTime timeCreated;

    private SynchronizeState(Builder builder) {
        super.setId(builder.id);
        setStatus(builder.status);
        setOrganization(builder.organization);
        setStep(builder.step);
        setUser(builder.user);
        setSyncCount(builder.syncCount);
        setTimeCreated(builder.timeCreated);

    }

    public void initializeSynchronizeState() {
        setId(new SynchronizeStateId(UUID.randomUUID()));
        timeCreated = ZonedDateTime.now();
        syncCount = 0;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getSyncCount() {
        return syncCount;
    }

    public void setSyncCount(Integer syncCount) {
        this.syncCount = syncCount;
    }

    public SynchronizeStatus getStatus() {
        return status;
    }

    public void setStatus(SynchronizeStatus status) {
        this.status = status;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public SynchronizeStep getStep() {
        return step;
    }

    public void setStep(SynchronizeStep step) {
        this.step = step;
    }

    public ZonedDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(ZonedDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private SynchronizeStateId id;
        private User user;
        private SynchronizeStatus status;
        private Organization organization;
        private SynchronizeStep step;
        private Integer syncCount;
        private ZonedDateTime timeCreated;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(SynchronizeStateId val) {
            id = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder status(SynchronizeStatus val) {
            status = val;
            return this;
        }

        public Builder organization(Organization val) {
            organization = val;
            return this;
        }

        public Builder step(SynchronizeStep val) {
            step = val;
            return this;
        }

        public Builder syncCount(Integer val) {
            syncCount = val;
            return this;
        }

        public Builder timeCreated(ZonedDateTime val) {
            timeCreated = val;
            return this;
        }

        public SynchronizeState build() {
            return new SynchronizeState(this);
        }
    }
}
