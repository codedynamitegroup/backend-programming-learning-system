package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.user;

import com.backend.programming.learning.system.course.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.user.UserRequestCourseToAuthMessagePublisher;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.user.UserResponseCourseToAuthMessagePublisher;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.backend.programming.learning.system.saga.user.SagaConstants.AUTH_TO_ANY_SERVICES_USER_SAGA_NAME;
import static com.backend.programming.learning.system.saga.user.SagaConstants.COURSE_TO_AUTH_SERVICE_USER_SAGA_NAME;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserOutboxScheduler implements OutboxScheduler {
    private final UserOutboxHelper userOutboxHelper;
    private final UserRequestCourseToAuthMessagePublisher userRequestCourseToAuthMessagePublisher;
    private final UserResponseCourseToAuthMessagePublisher userResponseCourseToAuthMessagePublisher;

    @Override
    @Transactional
    @Scheduled(fixedRateString = "${course-service.outbox-scheduler-fixed-rate}",
    initialDelayString = "${course-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
        Optional<List<UserOutboxMessage>> userOutboxMessagesAuthToAnyServices =
                userOutboxHelper.getUserOutboxMessageByOutboxStatus(AUTH_TO_ANY_SERVICES_USER_SAGA_NAME, OutboxStatus.STARTED);
        if (userOutboxMessagesAuthToAnyServices.isPresent() && userOutboxMessagesAuthToAnyServices.get().size() > 0) {
            List<UserOutboxMessage> outboxMessages = userOutboxMessagesAuthToAnyServices.get();
            log.info("Received {} UserOutboxMessage with ids {}, sending to kafka!", outboxMessages.size(),
                    outboxMessages.stream().map(outboxMessage ->
                            outboxMessage.getId().toString()).collect(Collectors.joining(",")));
            outboxMessages.forEach(userOutboxMessage -> {
                userResponseCourseToAuthMessagePublisher.publish(userOutboxMessage, userOutboxHelper::updateOutboxMessage);
            });
            log.info("{} UserOutboxMessage sent to message bus!", outboxMessages.size());
        }

        Optional<List<UserOutboxMessage>> userOutboxMessagesCourseToAuth =
                userOutboxHelper.getUserOutboxMessageByOutboxStatus(COURSE_TO_AUTH_SERVICE_USER_SAGA_NAME, OutboxStatus.STARTED);
        if (userOutboxMessagesCourseToAuth.isPresent() && userOutboxMessagesCourseToAuth.get().size() > 0) {
            List<UserOutboxMessage> outboxMessages = userOutboxMessagesCourseToAuth.get();
            log.info("Received {} UserOutboxMessage with ids {}, sending to kafka!", outboxMessages.size(),
                    outboxMessages.stream().map(outboxMessage ->
                            outboxMessage.getId().toString()).collect(Collectors.joining(",")));
            outboxMessages.forEach(userOutboxMessage -> {
                userRequestCourseToAuthMessagePublisher.publish(userOutboxMessage, userOutboxHelper::updateOutboxMessage);
            });
            log.info("{} UserOutboxMessage sent to message bus!", outboxMessages.size());
        }
    }
}
