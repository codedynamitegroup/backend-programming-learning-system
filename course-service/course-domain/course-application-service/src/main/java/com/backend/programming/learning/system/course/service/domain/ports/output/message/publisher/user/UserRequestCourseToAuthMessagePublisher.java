package com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.user;


import com.backend.programming.learning.system.course.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.function.BiConsumer;

public interface UserRequestCourseToAuthMessagePublisher {
    void publish(UserOutboxMessage userOutboxMessage,
                 BiConsumer<UserOutboxMessage, OutboxStatus> outboxCallback);
}
