package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationComponentType;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationEventType;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.NotificationId;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Notification extends AggregateRoot<NotificationId> {
    private User userFrom;
    private User userTo;
    private String subject;
    private String fullMessage;
    private String smallMessage;
    private NotificationComponentType component;
    private NotificationEventType eventType;
    private String contextUrl;
    private String contextUrlName;
    private Boolean isRead;
    private ZonedDateTime timeRead;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private Notification(Builder builder) {
        super.setId(builder.notificationId);
        setUserFrom(builder.userFrom);
        setUserTo(builder.userTo);
        setSubject(builder.subject);
        setFullMessage(builder.fullMessage);
        setSmallMessage(builder.smallMessage);
        setComponent(builder.component);
        setEventType(builder.eventType);
        setContextUrl(builder.contextUrl);
        setContextUrlName(builder.contextUrlName);
        isRead = builder.isRead;
        setTimeRead(builder.timeRead);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
    }

    public static Builder builder() {
        return new Builder();
    }

    public void initializeNotification() {
        setId(new NotificationId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now();
        updatedAt = ZonedDateTime.now();
    }


    public User getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public User getUserTo() {
        return userTo;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFullMessage() {
        return fullMessage;
    }

    public void setFullMessage(String fullMessage) {
        this.fullMessage = fullMessage;
    }

    public String getSmallMessage() {
        return smallMessage;
    }

    public void setSmallMessage(String smallMessage) {
        this.smallMessage = smallMessage;
    }

    public NotificationComponentType getComponent() {
        return component;
    }

    public void setComponent(NotificationComponentType component) {
        this.component = component;
    }

    public NotificationEventType getEventType() {
        return eventType;
    }

    public void setEventType(NotificationEventType eventType) {
        this.eventType = eventType;
    }

    public String getContextUrl() {
        return contextUrl;
    }

    public void setContextUrl(String contextUrl) {
        this.contextUrl = contextUrl;
    }

    public String getContextUrlName() {
        return contextUrlName;
    }

    public void setContextUrlName(String contextUrlName) {
        this.contextUrlName = contextUrlName;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public ZonedDateTime getTimeRead() {
        return timeRead;
    }

    public void setTimeRead(ZonedDateTime timeRead) {
        this.timeRead = timeRead;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static final class Builder {
        private NotificationId notificationId;
        private User userFrom;
        private User userTo;
        private String subject;
        private String fullMessage;
        private String smallMessage;
        private NotificationComponentType component;
        private NotificationEventType eventType;
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

        public Builder userFrom(User val) {
            userFrom = val;
            return this;
        }

        public Builder userTo(User val) {
            userTo = val;
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

        public Builder component(NotificationComponentType val) {
            component = val;
            return this;
        }

        public Builder eventType(NotificationEventType val) {
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
