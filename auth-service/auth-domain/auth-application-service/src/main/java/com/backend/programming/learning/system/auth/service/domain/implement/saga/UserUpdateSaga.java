package com.backend.programming.learning.system.auth.service.domain.implement.saga;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.UserResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.user.UserOutboxHelper;
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
public class UserUpdateSaga implements SagaStep<UserResponse> {
    private final UserOutboxHelper userOutboxHelper;
    private final UserUpdateSagaHelper userSagaHelper;
    private final UserRepository userRepository;

    public UserUpdateSaga(UserOutboxHelper userOutboxHelper, UserUpdateSagaHelper userSagaHelper, UserRepository userRepository) {
        this.userOutboxHelper = userOutboxHelper;
        this.userSagaHelper = userSagaHelper;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void process(UserResponse userResponse) {
        Optional<UserOutboxMessage> userOutboxMessageResponse =
                userOutboxHelper.getUserOutboxMessageBySagaIdAndSagaStatus(UUID.fromString(userResponse.getSagaId()), SagaStatus.STARTED);
        if (userOutboxMessageResponse.isEmpty()) {
            log.info("An outbox message with saga id: {} is already processed!", userResponse.getSagaId());
            return;
        }

        UserOutboxMessage userOutboxMessage = userOutboxMessageResponse.get();

        User user = saveUserSuccessfulState(userResponse);

        SagaStatus sagaStatus = userSagaHelper.copyStatusToSagaStatus(user.getCopyState());

        //update outbox
        userOutboxHelper.save(updateOutboxMessage(userOutboxMessage, user.getCopyState(), sagaStatus
        ));

        log.info("User with id: {} is created successfully!", userResponse.getUserId());
    }


    @Override
    @Transactional
    public void rollback(UserResponse userResponse) {
        Optional<UserOutboxMessage> userOutboxMessageResponse =
                userOutboxHelper.getUserOutboxMessageBySagaIdAndSagaStatus(UUID.fromString(userResponse.getSagaId()),
                        SagaStatus.STARTED);
        if (userOutboxMessageResponse.isEmpty()) {
            log.info("An outbox message with saga id: {} is already roll backed!", userResponse.getSagaId());
            return;
        }

        UserOutboxMessage userOutboxMessage = userOutboxMessageResponse.get();

        User user = saveUserRollbackState(userResponse);

        SagaStatus sagaStatus = userSagaHelper.copyStatusToSagaStatus(user.getCopyState());

        //update outbox
        userOutboxHelper.save(updateOutboxMessage(userOutboxMessage, user.getCopyState(), sagaStatus
        ));

        log.info("User with id: {} is rollback!", userResponse.getUserId());
    }

    private UserOutboxMessage updateOutboxMessage(UserOutboxMessage userOutboxMessage,
                                                                 CopyState copyState,
                                                                 SagaStatus sagaStatus) {
        userOutboxMessage.setProcessedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
        userOutboxMessage.setCopyState(copyState);
        userOutboxMessage.setSagaStatus(sagaStatus);
        return userOutboxMessage;
    }

    private User saveUserSuccessfulState(UserResponse response){
        User user;
        if (response.getState() == CopyState.DELETED) {
            user = userSagaHelper.findUserByIdAndIsDeletedTrue(UUID.fromString(response.getUserId()));
        } else {
            user = userSagaHelper.findUserById(UUID.fromString(response.getUserId()));
        }
        log.info("Completing save user state successful with id: {} with state {}", response.getId(), response.getState().toString());
        user.setCopyState(response.getState());//domain service should do this job but it's quite short so I set it directly
        userRepository.save(user);
        return user;
    }
    private User saveUserRollbackState(UserResponse response){
        User user = userSagaHelper.findUserById(UUID.fromString(response.getUserId()));
        log.info("Completing save user state rollback with id: {} with state {}", response.getId(), response.getState().toString());
        user.setCopyState(response.getState());//domain service should do this job but it's quite short so I set it directly
        userRepository.save(user);
        return user;
    }
}
