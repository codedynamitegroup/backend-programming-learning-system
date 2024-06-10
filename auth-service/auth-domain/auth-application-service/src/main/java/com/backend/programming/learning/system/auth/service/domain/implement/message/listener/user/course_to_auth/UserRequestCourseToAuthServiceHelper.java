package com.backend.programming.learning.system.auth.service.domain.implement.message.listener.user.course_to_auth;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.dto.method.message.user.UserRequest;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.course_to_auth.UserCreatedFailEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.course_to_auth.UserCreatedSuccessEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.course_to_auth.UserUpdatedFailEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.course_to_auth.UserUpdatedSuccessEvent;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserDataMapper;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_auth_to_any_services.UserOutboxAuthToAnyServicesMessage;
import com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.user_auth_to_any_services.UserOutboxAuthToAnyServicesHelper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserRequestAuthToAnyServicesMessagePublisher;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserRequestCourseToAuthServiceHelper {
    private final UserDataMapper userDataMapper;
    private final UserRepository userRepository;
    private final AuthDomainService authDomainService;
    private final UserOutboxAuthToAnyServicesHelper userOutboxHelper;
    private final UserRequestAuthToAnyServicesMessagePublisher userRequestAuthToAnyServicesMessagePublisher;

    @Transactional
    public void createdUser(UserRequest userRequest) {
        if (publishOutboxMessageProcessedForUser(userRequest, CopyState.CREATED)) {
            log.info("An outbox message with saga id: {} is already saved to database", userRequest.getSagaId());
            return;
        }

        User user = userDataMapper.userCreateRequestToUser(userRequest);
        Optional<User> userResult = userRepository.findUserByEmail(user.getEmail());
        List<String> failureMessages = new ArrayList<>();
        //Find user with email
        if (userResult.isPresent()) {
            log.error("Found user with email: {}", user.getEmail());
            failureMessages.add("Found user with email: " + user.getEmail());
            UserCreatedFailEvent userCreatedFailEvent = authDomainService.createdUserFail(user, failureMessages);
            userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userCreatedFailEvent, CopyState.CREATE_FAILED),
                    ServiceName.AUTH_SERVICE,
                    CopyState.CREATE_FAILED,
                    OutboxStatus.STARTED,
                    SagaStatus.STARTED,
                    UUID.fromString(userRequest.getSagaId()));
            return;
        }

        //Save user
        User userSaved = userRepository.save(user);
        if (userSaved == null) {
            log.error("Could not create user with id: {}", user.getId().getValue().toString());
            failureMessages.add("Could not create user with id: " + user.getId().getValue().toString());
            UserCreatedFailEvent userCreatedFailEvent = authDomainService.createdUserFail(user, failureMessages);
            userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userCreatedFailEvent, CopyState.CREATE_FAILED),
                    ServiceName.AUTH_SERVICE,
                    CopyState.CREATE_FAILED,
                    OutboxStatus.STARTED,
                    SagaStatus.STARTED,
                    UUID.fromString(userRequest.getSagaId()));
            return;
        }

        log.info("User is created with id: {}", userSaved.getId().getValue());
        UserCreatedSuccessEvent userCreatedSuccessEvent = authDomainService.createdUserSuccess(user);

        userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userCreatedSuccessEvent, CopyState.CREATED),
                ServiceName.AUTH_SERVICE,
                CopyState.CREATING,
                OutboxStatus.STARTED,
                SagaStatus.STARTED,
                UUID.fromString(userRequest.getSagaId()));
    }

    @Transactional
    public void updatedUser(UserRequest userUpdateRequest) {
        if (publishOutboxMessageProcessedForUser(userUpdateRequest, CopyState.UPDATED)) {
            log.info("An outbox message with saga id: {} is already saved to database", userUpdateRequest.getSagaId());
            return;
        }

        User user = userDataMapper.userUpdateRequestToUser(userUpdateRequest);
        Optional<User> userFound = userRepository.findUser(user.getId().getValue());
        List<String> failureMessages = new ArrayList<>();

        //Find user with id
        if (userFound.isEmpty()) {
            log.error("Not found user with id: {}", user.getId().getValue());
            failureMessages.add("Not found user with id: " + user.getId().getValue());
            UserUpdatedFailEvent userUpdatedFailEvent = authDomainService.updatedUserFail(user, failureMessages);
            userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userUpdatedFailEvent, CopyState.UPDATE_FAILED),
                    ServiceName.AUTH_SERVICE,
                    CopyState.UPDATE_FAILED,
                    OutboxStatus.STARTED,
                    SagaStatus.STARTED,
                    UUID.fromString(userUpdateRequest.getSagaId()));
            return;
        }

        //Update user
        User userUpdated = userFound.get();

        userUpdated.setUpdatedAt(user.getUpdatedAt());

        if (userUpdateRequest.getDob().get(ChronoField.NANO_OF_SECOND) != 0) {
            userUpdated.setDob(user.getDob());
        }
        if (userUpdateRequest.getFirstName() != null) {
            userUpdated.setFirstName(user.getFirstName());
        }
        if (userUpdateRequest.getLastName() != null) {
            userUpdated.setLastName(user.getLastName());
        }
        if (userUpdateRequest.getPhone() != null) {
            userUpdated.setPhone(user.getPhone());
        }
        if (userUpdateRequest.getAddress() != null) {
            userUpdated.setAddress(user.getAddress());
        }
        if (userUpdateRequest.getAvatarUrl() != null) {
            userUpdated.setAvatarUrl(user.getAvatarUrl());
        }

        //Save user
        User userSaved = userRepository.save(userUpdated);
        if (userSaved == null) {
            log.error("Could not update user with id: {}", user.getId().getValue());
            failureMessages.add("Could not update user with id: " + user.getId().getValue());
            UserUpdatedFailEvent userUpdatedFailEvent = authDomainService.updatedUserFail(user, failureMessages);
            userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userUpdatedFailEvent, CopyState.UPDATE_FAILED),
                    ServiceName.AUTH_SERVICE,
                    CopyState.UPDATE_FAILED,
                    OutboxStatus.STARTED,
                    SagaStatus.STARTED,
                    UUID.fromString(userUpdateRequest.getSagaId()));
            return;
        }

        log.info("User is updated with id: {}", userSaved.getId().getValue());
        UserUpdatedSuccessEvent userUpdatedSuccessEvent = authDomainService.updatedUserSuccess(user);

        userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userUpdatedSuccessEvent, CopyState.UPDATED),
                ServiceName.AUTH_SERVICE,
                CopyState.UPDATED,
                OutboxStatus.STARTED,
                SagaStatus.STARTED,
                UUID.fromString(userUpdateRequest.getSagaId()));
    }

    private boolean publishOutboxMessageProcessedForUser(UserRequest userRequest, CopyState copyState) {
        Optional<UserOutboxAuthToAnyServicesMessage> userOutboxMessage =
                userOutboxHelper.getUserOutboxMessageBySagaIdAndCopyState(
                        UUID.fromString(userRequest.getSagaId()), copyState);
        if (userOutboxMessage.isPresent()) {
            userRequestAuthToAnyServicesMessagePublisher.publish(userOutboxMessage.get(), userOutboxHelper::updateOutboxMessage);
            return true;
        }
        return false;
    }
}
