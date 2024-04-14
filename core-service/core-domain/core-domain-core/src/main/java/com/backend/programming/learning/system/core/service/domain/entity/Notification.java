package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.NotificationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Notification extends AggregateRoot<NotificationId> {
    private UserId userIdFrom;
    private UserId userIdTo;
    private String subject;
    private String fullMessage;
    private String smallMessage;
    private String component;
    private String eventType;
    private String contextUrl;
    private String contextUrlName;
    private Boolean isRead;
    private ZonedDateTime timeRead;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public void initializeNotification() {
        setId(new NotificationId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
        updatedAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
    }

    private Notification(Builder builder) {
        super.setId(builder.notificationId);
        userIdFrom = builder.userIdFrom;
        userIdTo = builder.userIdTo;
        subject = builder.subject;
        fullMessage = builder.fullMessage;
        smallMessage = builder.smallMessage;
        component = builder.component;
        eventType = builder.eventType;
        contextUrl = builder.contextUrl;
        contextUrlName = builder.contextUrlName;
        isRead = builder.isRead;
        timeRead = builder.timeRead;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public UserId getUserIdFrom() {
        return userIdFrom;
    }

    public UserId getUserIdTo() {
        return userIdTo;
    }

    public String getSubject() {
        return subject;
    }

    public String getFullMessage() {
        return fullMessage;
    }

    public String getSmallMessage() {
        return smallMessage;
    }

    public String getComponent() {
        return component;
    }

    public String getEventType() {
        return eventType;
    }

    public String getContextUrl() {
        return contextUrl;
    }

    public String getContextUrlName() {
        return contextUrlName;
    }

    public Boolean getRead() {
        return isRead;
    }

    public ZonedDateTime getTimeRead() {
        return timeRead;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static final class Builder {
        private NotificationId notificationId;
        private UserId userIdFrom;
        private UserId userIdTo;
        private String subject;
        private String fullMessage;
        private String smallMessage;
        private String component;
        private String eventType;
        private String contextUrl;
        private String contextUrlName;
        private Boolean isRead;
        private ZonedDateTime timeRead;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;

        private Builder() {
        }

        public Builder id(NotificationId val) {
            notificationId = val;
            return this;
        }

        public Builder userIdFrom(UserId val) {
            userIdFrom = val;
            return this;
        }

        public Builder userIdTo(UserId val) {
            userIdTo = val;
            return this;
        }

        public Builder subject(String val) {
            subject = val;
            return this;
        }

        public Builder fullMessage(String val) {
            fullMessage = val;
            return this;
        }

        public Builder smallMessage(String val) {
            smallMessage = val;
            return this;
        }

        public Builder component(String val) {
            component = val;
            return this;
        }

        public Builder eventType(String val) {
            eventType = val;
            return this;
        }

        public Builder contextUrl(String val) {
            contextUrl = val;
            return this;
        }

        public Builder contextUrlName(String val) {
            contextUrlName = val;
            return this;
        }

        public Builder isRead(Boolean val) {
            isRead = val;
            return this;
        }

        public Builder timeRead(ZonedDateTime val) {
            timeRead = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder updatedAt(ZonedDateTime val) {
            updatedAt = val;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}
