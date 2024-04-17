package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.CalendarEventId;
import com.backend.programming.learning.system.core.service.domain.valueobject.NotificationEventType;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

import java.time.ZonedDateTime;

public class CalendarEvent extends AggregateRoot<CalendarEventId> {
    private String name;
    private String description;
    private NotificationEventType eventType;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private ZonedDateTime createdAt;

    private CalendarEvent(Builder builder) {
        super.setId(builder.calendarEventId);
        setName(builder.name);
        setDescription(builder.description);
        setEventType(builder.eventType);
        setStartTime(builder.startTime);
        setEndTime(builder.endTime);
        setCreatedAt(builder.createdAt);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NotificationEventType getEventType() {
        return eventType;
    }

    public void setEventType(NotificationEventType eventType) {
        this.eventType = eventType;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static final class Builder {
        private CalendarEventId calendarEventId;
        private String name;
        private String description;
        private NotificationEventType eventType;
        private ZonedDateTime startTime;
        private ZonedDateTime endTime;
        private ZonedDateTime createdAt;

        private Builder() {
        }

        public Builder id(CalendarEventId val) {
            calendarEventId = val;
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

        public Builder eventType(NotificationEventType val) {
            eventType = val;
            return this;
        }

        public Builder startTime(ZonedDateTime val) {
            startTime = val;
            return this;
        }

        public Builder endTime(ZonedDateTime val) {
            endTime = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public CalendarEvent build() {
            return new CalendarEvent(this);
        }
    }
}
