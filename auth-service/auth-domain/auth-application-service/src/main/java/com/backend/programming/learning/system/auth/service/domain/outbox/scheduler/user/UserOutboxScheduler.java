package com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.user;

import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserRequestAuthToAnyServicesMessagePublisher;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserResponseCourseToAuthServiceMessagePublisher;
import com.backend.programming.learning.system.domain.valueobject.UserOutboxServiceType;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
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
    private final UserRequestAuthToAnyServicesMessagePublisher userRequestAuthToAnyServicesMessagePublisher;
    private final UserResponseCourseToAuthServiceMessagePublisher userResponseCourseToAuthServiceMessagePublisher;

    @Override
    @Transactional
    @Scheduled(fixedRateString = "${auth-service.outbox-scheduler-fixed-rate}",
            initialDelayString = "${auth-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
        Optional<List<UserOutboxMessage>> userOutboxMessagesAuthToAnyServices =
                userOutboxHelper.getUserOutboxMessageByOutboxStatusAndSagaStatus(AUTH_TO_ANY_SERVICES_USER_SAGA_NAME, OutboxStatus.STARTED,
                        SagaStatus.STARTED, SagaStatus.COMPENSATING);
        if (userOutboxMessagesAuthToAnyServices.isPresent() && userOutboxMessagesAuthToAnyServices.get().size() > 0) {
            List<UserOutboxMessage> outboxMessages = userOutboxMessagesAuthToAnyServices.get();
            log.info("Received {} UserOutboxMessage with ids {}, sending to kafka!", outboxMessages.size(),
                    outboxMessages.stream().map(outboxMessage ->
                            outboxMessage.getId().toString()).collect(Collectors.joining(",")));
            outboxMessages.forEach(userOutboxMessage -> {
                userRequestAuthToAnyServicesMessagePublisher.publish(userOutboxMessage, userOutboxHelper::updateOutboxMessage);
            });
            log.info("{} UserOutboxMessage sent to message bus!", outboxMessages.size());
        }

        Optional<List<UserOutboxMessage>> userOutboxMessagesCourseToAuthService =
                userOutboxHelper.getUserOutboxMessageByOutboxStatusAndSagaStatus(COURSE_TO_AUTH_SERVICE_USER_SAGA_NAME, OutboxStatus.STARTED,
                        SagaStatus.STARTED, SagaStatus.COMPENSATING);
        if (userOutboxMessagesCourseToAuthService.isPresent() && userOutboxMessagesCourseToAuthService.get().size() > 0) {
            List<UserOutboxMessage> outboxMessages = userOutboxMessagesCourseToAuthService.get();
            log.info("Received {} UserOutboxMessage with ids {}, sending to kafka!", outboxMessages.size(),
                    outboxMessages.stream().map(outboxMessage ->
                            outboxMessage.getId().toString()).collect(Collectors.joining(",")));
            outboxMessages.forEach(userOutboxMessage -> {
                userResponseCourseToAuthServiceMessagePublisher.publish(userOutboxMessage, userOutboxHelper::updateOutboxMessage);
            });
            log.info("{} UserOutboxMessage sent to message bus!", outboxMessages.size());
        }

    }
}
