package com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user;

import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_course_to_auth_service.UserOutboxCourseToAuthServiceMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.function.BiConsumer;

public interface UserResponseCourseToAuthServiceMessagePublisher {
    void publish(UserOutboxCourseToAuthServiceMessage userOutboxMessage,
                 BiConsumer<UserOutboxCourseToAuthServiceMessage, OutboxStatus> outboxCallback);
}
