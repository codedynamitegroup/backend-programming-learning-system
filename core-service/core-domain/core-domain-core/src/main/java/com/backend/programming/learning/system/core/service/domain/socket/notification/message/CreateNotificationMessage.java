package com.backend.programming.learning.system.core.service.domain.socket.notification.message;

import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionEvent;
import com.backend.programming.learning.system.core.service.domain.valueobject.MessageType;

import java.time.ZonedDateTime;
import java.util.UUID;

public class CreateNotificationMessage<K> extends NotificationMessage<K> {
    public CreateNotificationMessage(
            String room,
            String eventName,
            K message
    ) {
        super(room, eventName, message);
    }
}
