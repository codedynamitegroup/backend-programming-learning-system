package com.backend.programming.learning.system.core.service.domain.socket.notification.message;

import com.backend.programming.learning.system.core.service.domain.valueobject.MessageType;
import com.backend.programming.learning.system.domain.socket.DomainSocketMessage;

public abstract class NotificationMessage<K> implements DomainSocketMessage<K> {
    private final String room;
    private final String eventName;
    private final K message;

    public NotificationMessage(String room, String eventName, K message) {
        this.room = room;
        this.eventName = eventName;
        this.message = message;
    }

    public String getRoom() {
        return room;
    }

    public String getEventName() {
        return eventName;
    }

    public K getMessage() {
        return message;
    }
}
