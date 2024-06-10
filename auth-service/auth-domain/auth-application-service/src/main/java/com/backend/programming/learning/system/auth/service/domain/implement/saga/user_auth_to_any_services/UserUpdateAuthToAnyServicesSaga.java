package com.backend.programming.learning.system.auth.service.domain.implement.saga.user_auth_to_any_services;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.user.UserResponse;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_auth_to_any_services.UserOutboxAuthToAnyServicesMessage;
import com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.user_auth_to_any_services.UserOutboxAuthToAnyServicesHelper;
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
public class UserUpdateAuthToAnyServicesSaga implements SagaStep<UserResponse> {
    private final UserOutboxAuthToAnyServicesHelper userOutboxHelper;
    private final UserUpdateAuthToAnyServicesSagaHelper userSagaHelper;

    public UserUpdateAuthToAnyServicesSaga(UserOutboxAuthToAnyServicesHelper userOutboxHelper, UserUpdateAuthToAnyServicesSagaHelper userSagaHelper) {
        this.userOutboxHelper = userOutboxHelper;
        this.userSagaHelper = userSagaHelper;
    }

    @Override
    @Transactional
    public void process(UserResponse userResponse) {
        Optional<UserOutboxAuthToAnyServicesMessage> userOutboxMessageResponse =
                userOutboxHelper.getUserOutboxMessageBySagaIdAndServiceNameAndSagaStatus(
                        UUID.fromString(userResponse.getSagaId()), userResponse.getServiceName(), SagaStatus.STARTED);
        if (userOutboxMessageResponse.isEmpty()) {
            log.info("An outbox message with saga id: {} is already processed!", userResponse.getSagaId());
            return;
        }

        UserOutboxAuthToAnyServicesMessage userOutboxMessage = userOutboxMessageResponse.get();

        SagaStatus sagaStatus = userSagaHelper.copyStatusToSagaStatus(userResponse.getState());

        //update outbox
        userOutboxHelper.save(updateOutboxMessage(userOutboxMessage, userResponse.getState(), sagaStatus));

        log.info("User with id: {} is created successfully!", userResponse.getUserId());
    }


    @Override
    @Transactional
    public void rollback(UserResponse userResponse) {
        Optional<UserOutboxAuthToAnyServicesMessage> userOutboxMessageResponse =
                userOutboxHelper.getUserOutboxMessageBySagaIdAndServiceNameAndSagaStatus(
                        UUID.fromString(userResponse.getSagaId()),
                        userResponse.getServiceName(),
                        SagaStatus.STARTED);
        if (userOutboxMessageResponse.isEmpty()) {
            log.info("An outbox message with saga id: {} is already roll backed!", userResponse.getSagaId());
            return;
        }

        UserOutboxAuthToAnyServicesMessage userOutboxMessage = userOutboxMessageResponse.get();

        SagaStatus sagaStatus = userSagaHelper.copyStatusToSagaStatus(userResponse.getState());

        //update outbox
        userOutboxHelper.save(updateOutboxMessage(userOutboxMessage, userResponse.getState(), sagaStatus
        ));

        log.info("User with id: {} is rollback!", userResponse.getUserId());
    }

    private UserOutboxAuthToAnyServicesMessage updateOutboxMessage(UserOutboxAuthToAnyServicesMessage userOutboxMessage,
                                                                   CopyState copyState,
                                                                   SagaStatus sagaStatus) {
        userOutboxMessage.setProcessedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
        userOutboxMessage.setCopyState(copyState);
        userOutboxMessage.setSagaStatus(sagaStatus);
        return userOutboxMessage;
    }
}
