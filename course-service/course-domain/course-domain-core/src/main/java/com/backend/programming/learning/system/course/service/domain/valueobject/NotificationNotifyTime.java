package com.backend.programming.learning.system.course.service.domain.valueobject;

public enum NotificationNotifyTime {
    TWENTY_FOUR_HOURS(86400000),
    TWELVE_HOURS(43200000),
    SIX_HOURS(21600000),
    THREE_HOURS(10800000),
    ONE_HOUR(3600000),
    THIRTY_MINUTES(1800000);

    private final int timeInMillis;

    NotificationNotifyTime(int timeInMillis) {
        this.timeInMillis = timeInMillis;
    }

    public int getTimeInMillis() {
        return timeInMillis;
    }
}