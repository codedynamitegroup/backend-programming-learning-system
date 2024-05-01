package com.backend.programming.learning.system.core.service.domain.implement.message.listener.user;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.user.UserRequest;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.event.user.*;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.outbox.scheduler.user.UserOutboxHelper;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.user.UserResponseMessagePublisher;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
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
public class UserRequestHelper {
    private final UserDataMapper userDataMapper;
    private final UserRepository userRepository;
    private final CoreDomainService coreDomainService;
    private final UserOutboxHelper userOutboxHelper;
    private final UserResponseMessagePublisher userResponseMessagePublisher;


    public UserRequestHelper(UserDataMapper userDataMapper, UserRepository userRepository, CoreDomainService coreDomainService, UserOutboxHelper userOutboxHelper, UserResponseMessagePublisher userResponseMessagePublisher) {
        this.userDataMapper = userDataMapper;
        this.userRepository = userRepository;
        this.coreDomainService = coreDomainService;
        this.userOutboxHelper = userOutboxHelper;
        this.userResponseMessagePublisher = userResponseMessagePublisher;
    }

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
            UserCreatedFailEvent userCreatedFailEvent = coreDomainService.createdUserFail(user, failureMessages);
            userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userCreatedFailEvent),
                    userCreatedFailEvent.getUser().getCopyState(),
                    OutboxStatus.STARTED,
                    UUID.fromString(userRequest.getSagaId()));
            return;
        }

        //Save user
        User userSaved = userRepository.save(user);
        if (userSaved == null) {
            log.error("Could not create user with id: {}", user.getId().getValue().toString());
            failureMessages.add("Could not create user with id: " + user.getId().getValue().toString());
            UserCreatedFailEvent userCreatedFailEvent = coreDomainService.createdUserFail(user, failureMessages);
            userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userCreatedFailEvent),
                    userCreatedFailEvent.getUser().getCopyState(),
                    OutboxStatus.STARTED,
                    UUID.fromString(userRequest.getSagaId()));
            return;
        }

        log.info("User is created with id: {}", userSaved.getId().getValue());
        UserCreatedSuccessEvent userCreatedSuccessEvent = coreDomainService.createdUserSuccess(user);

        userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userCreatedSuccessEvent),
                userCreatedSuccessEvent.getUser().getCopyState(),
                OutboxStatus.STARTED,
                UUID.fromString(userRequest.getSagaId()));
    }

    @Transactional
    public void deletedUser(UserRequest userRequest) {
        if (publishOutboxMessageProcessedForUser(userRequest, CopyState.DELETED)) {
            log.info("An outbox message with saga id: {} is already saved to database", userRequest.getSagaId());
            return;
        }

        User user = userDataMapper.userDeleteRequestToUser(userRequest);
        Optional<User> userFound = userRepository.findUser(user.getId().getValue());
        List<String> failureMessages = new ArrayList<>();
        //Find user with id
        if (userFound.isEmpty()) {
            log.error("Not found user with id: {}", user.getId().getValue());
            failureMessages.add("Not found user with id: " + user.getId().getValue());
            UserDeletedFailEvent userDeletedFailEvent = coreDomainService.deletedUserFail(user, failureMessages);
            userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userDeletedFailEvent),
                    userDeletedFailEvent.getUser().getCopyState(),
                    OutboxStatus.STARTED,
                    UUID.fromString(userRequest.getSagaId()));
            return;
        }

        //Deleting user
        User userDeleted = userFound.get();

        userDeleted.setDeleted(user.getDeleted());

        //Save user
        User userSaved = userRepository.save(userDeleted);
        if (userSaved == null) {
            log.error("Could not delete user with id: {}", user.getId().getValue());
            return;
        }
        log.info("User is deleted with id: {}", userSaved.getId().getValue());

        UserDeletedSuccessEvent userDeletedSuccessEvent = coreDomainService.deletedUserSuccess(user);

        userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userDeletedSuccessEvent),
                userDeletedSuccessEvent.getUser().getCopyState(),
                OutboxStatus.STARTED,
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
            UserUpdatedFailEvent userUpdatedFailEvent = coreDomainService.updatedUserFail(user, failureMessages);
            userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userUpdatedFailEvent),
                    userUpdatedFailEvent.getUser().getCopyState(),
                    OutboxStatus.STARTED,
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
            UserUpdatedFailEvent userUpdatedFailEvent = coreDomainService.updatedUserFail(user, failureMessages);
            userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userUpdatedFailEvent),
                    userUpdatedFailEvent.getUser().getCopyState(),
                    OutboxStatus.STARTED,
                    UUID.fromString(userUpdateRequest.getSagaId()));
            return;
        }

        log.info("User is updated with id: {}", userSaved.getId().getValue());
        UserUpdatedSuccessEvent userUpdatedSuccessEvent = coreDomainService.updatedUserSuccess(user);

        userOutboxHelper.saveUserOutboxMessage(userDataMapper.userEventToUserEventPayload(userUpdatedSuccessEvent),
                userUpdatedSuccessEvent.getUser().getCopyState(),
                OutboxStatus.STARTED,
                UUID.fromString(userUpdateRequest.getSagaId()));
    }

    private boolean publishOutboxMessageProcessedForUser(UserRequest userRequest, CopyState copyState) {
        Optional<UserOutboxMessage> userOutboxMessage =
                userOutboxHelper.getUserOutboxMessageBySagaIdAndCopyState(
                        UUID.fromString(userRequest.getSagaId()), copyState);
        if (userOutboxMessage.isPresent()) {
            userResponseMessagePublisher.publish(userOutboxMessage.get(), userOutboxHelper::updateOutboxMessage);
            return true;
        }
        return false;
    }
}
