package com.backend.programming.learning.system.auth.service.domain.implement.saga.user_course_to_auth_service;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.user.UserResponse;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_course_to_auth_service.UserOutboxCourseToAuthServiceMessage;
import com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.user_course_to_auth_service.UserOutboxCourseToAuthServiceHelper;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.saga.SagaStatus;
import com.backend.programming.learning.system.saga.SagaStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class UserUpdateCourseToAuthServiceSaga implements SagaStep<UserResponse> {
    private final UserOutboxCourseToAuthServiceHelper userOutboxHelper;
    private final UserUpdateCourseToAuthServiceSagaHelper userSagaHelper;

    public UserUpdateCourseToAuthServiceSaga(UserOutboxCourseToAuthServiceHelper userOutboxHelper, UserUpdateCourseToAuthServiceSagaHelper userSagaHelper) {
        this.userOutboxHelper = userOutboxHelper;
        this.userSagaHelper = userSagaHelper;
    }

    @Override
    @Transactional
    public void process(UserResponse userResponse) {
        Optional<UserOutboxCourseToAuthServiceMessage> userOutboxMessageResponse =
                userOutboxHelper.getUserOutboxMessageBySagaIdAndServiceNameAndSagaStatus(
                        UUID.fromString(userResponse.getSagaId()), SagaStatus.STARTED);
        if (userOutboxMessageResponse.isEmpty()) {
            log.info("An outbox message with saga id: {} is already processed!", userResponse.getSagaId());
            return;
        }

        UserOutboxCourseToAuthServiceMessage userOutboxMessage = userOutboxMessageResponse.get();

        SagaStatus sagaStatus = userSagaHelper.copyStatusToSagaStatus(userResponse.getState());

        //update outbox
        userOutboxHelper.save(updateOutboxMessage(userOutboxMessage, userResponse.getState(), sagaStatus
        ));

        log.info("User with id: {} is created successfully!", userResponse.getUserId());
    }


    @Override
    @Transactional
    public void rollback(UserResponse userResponse) {
        Optional<UserOutboxCourseToAuthServiceMessage> userOutboxMessageResponse =
                userOutboxHelper.getUserOutboxMessageBySagaIdAndServiceNameAndSagaStatus(
                        UUID.fromString(userResponse.getSagaId()),
                        SagaStatus.STARTED);
        if (userOutboxMessageResponse.isEmpty()) {
            log.info("An outbox message with saga id: {} is already roll backed!", userResponse.getSagaId());
            return;
        }

        UserOutboxCourseToAuthServiceMessage userOutboxMessage = userOutboxMessageResponse.get();

        SagaStatus sagaStatus = userSagaHelper.copyStatusToSagaStatus(userResponse.getState());

        //update outbox
        userOutboxHelper.save(updateOutboxMessage(userOutboxMessage, userResponse.getState(), sagaStatus
        ));

        log.info("User with id: {} is rollback!", userResponse.getUserId());
    }

    private UserOutboxCourseToAuthServiceMessage updateOutboxMessage(UserOutboxCourseToAuthServiceMessage userOutboxMessage,
                                                                   CopyState copyState,
                                                                   SagaStatus sagaStatus) {
        userOutboxMessage.setProcessedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
        userOutboxMessage.setCopyState(copyState);
        userOutboxMessage.setSagaStatus(sagaStatus);
        return userOutboxMessage;
    }
}
