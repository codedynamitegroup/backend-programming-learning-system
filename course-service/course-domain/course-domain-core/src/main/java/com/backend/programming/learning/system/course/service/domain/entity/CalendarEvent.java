package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationNotifyTime;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.course.service.domain.valueobject.CalendarEventId;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationComponentType;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationEventType;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class CalendarEvent extends AggregateRoot<CalendarEventId> {
    private String name;
    private String description;
    private NotificationEventType eventType;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private User user;
    private UUID courseId;
    private UUID contestId;
    private NotificationComponentType component;
    private Boolean isStartTimeNotified;
    private Boolean isEndTimeNotified;
    private NotificationNotifyTime notificationNotifyTime;
    private ZonedDateTime createdAt;

    public void initializeCalendarEvent() {
        setId(new CalendarEventId(UUID.randomUUID()));
        isStartTimeNotified = false;
        isEndTimeNotified = false;
        createdAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }

    private CalendarEvent(Builder builder) {
        super.setId(builder.calendarEventId);
        setName(builder.name);
        setDescription(builder.description);
        setEventType(builder.eventType);
        setStartTime(builder.startTime);
        setEndTime(builder.endTime);
        setUser(builder.user);
        setCourseId(builder.courseId);
        setContestId(builder.contestId);
        setComponent(builder.component);
        isStartTimeNotified = builder.isStartTimeNotified;
        isEndTimeNotified = builder.isEndTimeNotified;
        setNotificationNotifyTime(builder.notificationNotifyTime);
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public UUID getContestId() {
        return contestId;
    }

    public void setContestId(UUID contestId) {
        this.contestId = contestId;
    }

    public NotificationComponentType getComponent() {
        return component;
    }

    public void setComponent(NotificationComponentType component) {
        this.component = component;
    }

    public Boolean getStartTimeNotified() {
        return isStartTimeNotified;
    }

    public void setStartTimeNotified(Boolean startTimeNotified) {
        isStartTimeNotified = startTimeNotified;
    }

    public Boolean getEndTimeNotified() {
        return isEndTimeNotified;
    }

    public void setEndTimeNotified(Boolean endTimeNotified) {
        isEndTimeNotified = endTimeNotified;
    }

    public NotificationNotifyTime getNotificationNotifyTime() {
        return notificationNotifyTime;
    }

    public void setNotificationNotifyTime(NotificationNotifyTime notificationNotifyTime) {
        this.notificationNotifyTime = notificationNotifyTime;
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
        private User user;
        private UUID courseId;
        private UUID contestId;
        private NotificationComponentType component;
        private Boolean isStartTimeNotified;
        private Boolean isEndTimeNotified;
        private NotificationNotifyTime notificationNotifyTime;
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

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder courseId(UUID val) {
            courseId = val;
            return this;
        }

        public Builder contestId(UUID val) {
            contestId = val;
            return this;
        }

        public Builder component(NotificationComponentType val) {
            component = val;
            return this;
        }

        public Builder isStartTimeNotified(Boolean val) {
            isStartTimeNotified = val;
            return this;
        }

        public Builder isEndTimeNotified(Boolean val) {
            isEndTimeNotified = val;
            return this;
        }

        public Builder notificationNotifyTime(NotificationNotifyTime val) {
            notificationNotifyTime = val;
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
